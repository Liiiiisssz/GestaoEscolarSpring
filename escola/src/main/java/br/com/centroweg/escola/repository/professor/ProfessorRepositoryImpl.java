package br.com.centroweg.escola.repository.professor;

import br.com.centroweg.escola.model.Professor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProfessorRepositoryImpl implements ProfessorRepository{
    private final DataSource dataSource;
    public ProfessorRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Professor> findAll() {
        List<Professor> professors = new ArrayList<>();
        String sql = """
                SELECT id,
                       nome,
                       email,
                       disciplina
                FROM professor
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            try(ResultSet rs = stmt.executeQuery()){
                professors.add(new Professor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("disciplina")
                ));
            }
        } catch (SQLException e){
            throw new RuntimeException("Erro ao buscar professores", e);
        }
        return professors;
    }

    @Override
    public Optional<Professor> findById(Integer id) {
        String sql = """
                SELECT id,
                       nome,
                       email,
                       disciplina
                FROM professor
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return Optional.of(new Professor(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("disciplina"))
                    );
                }
            }
            return Optional.empty();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao buscar professor", e);
        }
    }

    @Override
    public Professor save(Professor professor) {
        String sql = """
                INSERT INTO professor
                (nome, email, disciplina)
                VALUES
                (?,?,?)
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDisciplina());
            stmt.executeUpdate();
            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    professor.setId(rs.getInt(1));
                }
            }
            return professor;
        } catch (SQLException e){
            throw new RuntimeException("Erro ao cadastrar professor", e);
        }
    }

    @Override
    public void update(Professor professor) {
        String sql = """
                UPDATE professor
                SET nome = ?,
                    email = ?,
                    disciplina = ?
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDisciplina());
            stmt.setInt(4, professor.getId());
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao atualizar dados de professor", e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = """
                DELETE FROM professor
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao excluir professor", e);
        }
    }

    @Override
    public boolean exists(Integer id) {
        String sql = """
                SELECT id
                FROM professor
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                return rs.next();
            }
        } catch (SQLException e){
            throw new RuntimeException("Professor não existe", e);
        }
    }
}
