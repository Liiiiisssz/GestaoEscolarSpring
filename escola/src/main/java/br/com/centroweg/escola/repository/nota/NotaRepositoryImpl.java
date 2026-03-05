package br.com.centroweg.escola.repository.nota;

import br.com.centroweg.escola.model.Nota;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NotaRepositoryImpl implements NotaRepository {
    private final DataSource dataSource;
    public NotaRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Nota> findAll() {
        List<Nota> notas = new ArrayList<>();
        String sql = """
                SELECT n.id,
                       n.aluno_id,
                       a.nome AS nome_aluno,
                       n.aula_id,
                       au.assunto AS assunto_aula,
                       n.valor
                FROM nota n
                JOIN aluno a ON n.aluno_id = a.id
                LEFT JOIN aula au ON n.aula_id = au.id
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                notas.add(new Nota(
                        rs.getInt("id"),
                        rs.getInt("aluno_id"),
                        rs.getString("nome_aluno"),
                        rs.getInt("aula_id"),
                        rs.getString("assunto_aula"),
                        rs.getDouble("valor")
                ));
            }
            return notas;
        } catch (SQLException e){
            throw new RuntimeException("Erro ao buscar notas", e);
        }
    }

    @Override
    public Optional<Nota> findById(Integer id) {
        String sql = """
                SELECT n.id,
                       n.aluno_id,
                       a.nome AS nome_aluno,
                       n.aula_id,
                       au.assunto AS assunto_aula,
                       n.valor
                FROM nota n
                JOIN aluno a ON n.aluno_id = a.id
                LEFT JOIN aula au ON n.aula_id = au.id
                WHERE n.id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()){
                    return Optional.of(new Nota(
                            rs.getInt("id"),
                            rs.getInt("aluno_id"),
                            rs.getString("nome_aluno"),
                            rs.getInt("aula_id"),
                            rs.getString("assunto_aula"),
                            rs.getDouble("valor")
                    ));
                }
            }
            return Optional.empty();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao buscar nota", e);
        }
    }

    @Override
    public Nota save(Nota nota) {
        String sql = """
                INSERT INTO nota
                (aluno_id, aula_id, valor)
                VALUES
                (?,?,?)
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setInt(1, nota.getAlunoId());
            stmt.setInt(2, nota.getAulaId());
            stmt.setDouble(3, nota.getValor());
            stmt.executeUpdate();
            try(ResultSet rs = stmt.getGeneratedKeys()){
                if (rs.next()) {
                    nota.setId(rs.getInt(1));
                }
            }
            return nota;
        } catch (SQLException e){
            throw new RuntimeException("Erro ao salvar nota", e);
        }
    }

    @Override
    public void update(Nota nota) {
        String sql = """
                UPDATE nota
                SET aluno_id = ?,
                    aula_id = ?,
                    valor = ?
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nota.getAlunoId());
            stmt.setInt(2, nota.getAulaId());
            stmt.setDouble(3, nota.getValor());
            stmt.setInt(4, nota.getId());
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao atualizar dados da nota", e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = """
                DELETE FROM nota
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao excluir nota", e);
        }
    }

    @Override
    public boolean exists(Integer id) {
        String sql = """
                SELECT id
                FROM nota
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                return rs.next();
            }
        } catch (SQLException e){
            throw new RuntimeException("Erro ao verificar se nota existe", e);
        }
    }
}
