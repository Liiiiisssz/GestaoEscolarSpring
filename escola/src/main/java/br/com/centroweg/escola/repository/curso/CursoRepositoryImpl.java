package br.com.centroweg.escola.repository.curso;

import br.com.centroweg.escola.model.Curso;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

@Repository
public class CursoRepositoryImpl implements CursoRepository{
    private final DataSource dataSource;
    public CursoRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Curso> findAll() {
        Map<Integer, Curso> cursos = new LinkedHashMap<>();
        String sql = """
            SELECT c.id,
                   c.nome,
                   c.codigo,
                   p.nome AS professor_nome
            FROM curso c
            LEFT JOIN turma t ON t.curso_id = c.id
            LEFT JOIN professor p ON p.id = t.professor_id
            """;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Integer id = rs.getInt("id");
                Curso curso = cursos.computeIfAbsent(id, k -> {
                    try {
                        return new Curso(
                                id,
                                rs.getString("nome"),
                                rs.getString("codigo"),
                                new ArrayList<>()
                        );
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                });
                String nomeProfessor = rs.getString("professor_nome");
                if (nomeProfessor != null && !curso.getNomesProfessores().contains(nomeProfessor)) {
                    curso.getNomesProfessores().add(nomeProfessor);
                }
            }
            return new ArrayList<>(cursos.values());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cursos", e);
        }
    }

    @Override
    public Optional<Curso> findById(Integer id) {
        String sql = """
                SELECT id,
                       nome,
                       codigo
                FROM curso
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    Curso curso = new Curso(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("codigo")
                    );
                    curso.setNomesProfessores(findProfessors(id, conn));
                    return Optional.of(curso);
                }
            }
            return Optional.empty();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao buscar curso", e);
        }
    }

    @Override
    public Curso save(Curso curso) {
        String sql = """
                INSERT INTO curso
                (nome, codigo)
                VALUES
                (?,?)
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCodigo());
            stmt.executeUpdate();
            try(ResultSet rs = stmt.getGeneratedKeys()){
                if (rs.next()) {
                    curso.setId(rs.getInt(1));

                }
            }
            return curso;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao cadastrar curso", e);
        }
    }

    @Override
    public void update(Curso curso) {
        String sql = """
                UPDATE curso
                SET nome = ?,
                    codigo = ?
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCodigo());
            stmt.setInt(3, curso.getId());
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao atualizar dados de curso", e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = """
                DELETE FROM curso
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao excluir curso", e);
        }
    }

    @Override
    public boolean exists(Integer id) {
        String sql = """
                SELECT id
                FROM curso
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                return rs.next();
            }
        } catch (SQLException e){
            throw new RuntimeException("Curso não existe", e);
        }
    }

    @Override
    public List<String> findProfessors(Integer id, Connection conn) throws SQLException{
        List<String> nomes = new ArrayList<>();
        String sql = """
                SELECT DISTINCT p.nome
                FROM professor p
                JOIN turma t ON t.professor_id = p.id
                WHERE t.curso_id = ?
                """;
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    nomes.add(rs.getString("nome"));
                }
            }
            return nomes;
        }
    }
}
