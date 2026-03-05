package br.com.centroweg.escola.infrastructure.jdbc;

import br.com.centroweg.escola.domain.turma.Turma;
import br.com.centroweg.escola.domain.turma.TurmaRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

@Repository
public class TurmaJdbcRepository implements TurmaRepository {
    private final DataSource dataSource;
    public TurmaJdbcRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Turma> findAll() {
        Map<Integer, Turma> turmas = new LinkedHashMap<>();
        String sql = """
                SELECT t.id,
                       t.nome,
                       t.curso_id,
                       c.nome AS curso_nome,
                       t.professor_id,
                       p.nome AS professor_nome,
                       a.nome AS aluno_nome
                FROM turma t
                JOIN curso c ON t.curso_id = c.id
                JOIN professor p ON t.professor_id = p.id
                LEFT JOIN turma_aluno ta ON ta.turma_id = t.id
                LEFT JOIN aluno a ON a.id = ta.aluno_id
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            while (rs.next()){
                Integer id = rs.getInt("id");
                Turma turma = turmas.computeIfAbsent(id, t ->{
                    try{
                        return new Turma(
                                id,
                                rs.getString("nome"),
                                rs.getInt("curso_id"),
                                rs.getString("curso_nome"),
                                rs.getInt("professor_id"),
                                rs.getString("professor_nome"),
                                new ArrayList<>()
                        );
                    } catch (SQLException e){
                        throw new RuntimeException(e);
                    }
                });
                String nomeAluno = rs.getString("aluno_nome");
                if(nomeAluno != null){
                    turma.getNomeAlunos().add(nomeAluno);
                }
            }
            return new ArrayList<>(turmas.values());
        } catch (SQLException e){
            throw new RuntimeException("Erro ao buscar turmas", e);
        }
    }

    @Override
    public Optional<Turma> findById(Integer id) {
        String sql = """
                SELECT t.id,
                       t.nome,
                       t.curso_id,
                       c.nome as curso_nome,
                       t.professor_id,
                       p.nome as professor_nome
                FROM turma t
                JOIN curso c ON t.curso_id = c.id
                JOIN professor p ON t.professor_id = p.id
                WHERE t.id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    Turma turma = new Turma(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getInt("curso_id"),
                            rs.getString("curso_nome"),
                            rs.getInt("professor_id"),
                            rs.getString("professor_nome"),
                            new ArrayList<>()
                    );
                    turma.setNomeAlunos(findAlunosByTurmaId(id, conn));
                    return Optional.of(turma);
                }
            }
            return Optional.empty();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao buscar turma", e);
        }
    }

    @Override
    public Turma save(Turma turma) {
        String sql = """
                INSERT INTO turma
                (nome, curso_id, professor_id)
                VALUES
                (?,?,?)
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, turma.getNome());
            stmt.setInt(2, turma.getCursoId());
            stmt.setInt(3, turma.getProfessorId());
            stmt.executeUpdate();
            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    turma.setId(rs.getInt(1));
                }
            }
            return turma;
        } catch (SQLException e){
            throw new RuntimeException("Erro ao cadastrar turma", e);
        }
    }

    @Override
    public void update(Turma turma) {
        String sql = """
                UPDATE turma
                SET nome = ?,
                    curso_id = ?,
                    professor_id = ?
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, turma.getNome());
            stmt.setInt(2, turma.getCursoId());
            stmt.setInt(3, turma.getProfessorId());
            stmt.setInt(4, turma.getId());
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao atualizar dados da turma", e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = """
                DELETE FROM turma
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao excluir turma", e);
        }
    }

    @Override
    public boolean exists(Integer id) {
        String sql = """
                SELECT id
                FROM turma
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                return rs.next();
            }
        } catch (SQLException e){
            throw new RuntimeException("Erro ao verificar se turma existe", e);
        }
    }

    @Override
    public List<String> findAlunosByTurmaId(Integer id, Connection conn) throws SQLException {
        List<String> alunos = new ArrayList<>();
        String sql = """
                SELECT a.nome
                FROM aluno a
                JOIN turma_aluno ta ON ta.aluno_id = a.id
                WHERE ta.turma_id = ?
                """;
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next()){
                    alunos.add(rs.getString("nome"));
                }
            }
        }
        return alunos;
    }
}
