package br.com.centroweg.escola.infrastructure.jdbc;

import br.com.centroweg.escola.domain.aluno.Aluno;
import br.com.centroweg.escola.domain.aluno.AlunoRepository;
import br.com.centroweg.escola.domain.nota.Nota;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AlunoJdbcRepository implements AlunoRepository {
    private final DataSource dataSource;
    public AlunoJdbcRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Aluno> findAll() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = """
                SELECT id,
                       nome,
                       email,
                       matricula,
                       data_nascimento
                FROM aluno
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                alunos.add(new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("matricula"),
                        rs.getDate("data_nascimento").toLocalDate()
                ));
            }
            return alunos;
        } catch (SQLException e){
            throw new RuntimeException("Erro ao buscar alunos", e);
        }
    }

    @Override
    public Optional<Aluno> findById(Integer id) {
        String sql = """
                SELECT id,
                       nome,
                       email,
                       matricula,
                       data_nascimento
                FROM aluno
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    return Optional.of(new Aluno(rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("matricula"),
                            rs.getDate("data_nascimento").toLocalDate())
                    );
                }
            }
            return Optional.empty();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao buscar aluno", e);
        }
    }

    @Override
    public Aluno save(Aluno aluno) {
        String sql = """
                INSERT INTO aluno
                (nome, email, matricula, data_nascimento)
                VALUES
                (?,?,?,?)
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getMatricula());
            stmt.setDate(4, Date.valueOf(aluno.getDataNascimento()));
            stmt.executeUpdate();
            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    aluno.setId(rs.getInt(1));
                }
            }
            return aluno;
        } catch (SQLException e){
            throw new RuntimeException("Erro ao cadastrar aluno", e);
        }
    }

    @Override
    public void update(Aluno aluno) {
        String sql = """
                UPDATE aluno
                SET nome = ?,
                    email = ?,
                    matricula = ?,
                    data_nascimento = ?
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getMatricula());
            stmt.setDate(4, Date.valueOf(aluno.getDataNascimento()));
            stmt.setInt(5, aluno.getId());
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao atualizar dados de aluno", e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = """
                DELETE FROM aluno
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao deletar aluno", e);
        }
    }

    @Override
    public boolean exists(Integer id) {
        String sql = """
                SELECT id
                FROM aluno
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                return rs.next();
            }
        } catch (SQLException e){
            throw new RuntimeException("Aluno não existe", e);
        }
    }

    @Override
    public boolean vefifyEmail(String email) {
        String sql = """
                SELECT 1
                FROM aluno
                WHERE email = ?
                LIMIT 1
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, email);
            try(ResultSet rs = stmt.executeQuery()){
                return rs.next();
            }
        } catch (SQLException e){
            throw new RuntimeException("Erro ao verificar email", e);
        }
    }

    @Override
    public boolean verifyEmailUpdate(String email, Integer id) {
        String sql = """
                SELECT id
                FROM aluno
                WHERE email = ?
                AND id != ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setInt(2, id);
            try(ResultSet rs = stmt.executeQuery()){
                return rs.next();
            }
        } catch (SQLException e){
            throw new RuntimeException("Erro ao verificar email", e);
        }
    }

    @Override
    public List<Nota> listNotas(Integer id) {
        List<Nota> notas = new ArrayList<>();
        String sql = """
                SELECT n.valor,
                       a.nome,
                       au.assunto
                FROM nota n
                JOIN aluno a ON n.aluno_id = a.id
                LEFT JOIN aula au ON n.aula_id = au.id
                WHERE n.aluno_id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    notas.add(new Nota(
                            rs.getString("nome"),
                            rs.getString("assunto"),
                            rs.getDouble("valor")
                    ));
                }
            }
            return notas;
        } catch (SQLException e){
            throw new RuntimeException("Erro ao buscar notas de aluno", e);
        }
    }
}
