package br.com.centroweg.escola.repository.aula;

import br.com.centroweg.escola.model.Aula;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class AulaRepositoryImpl implements AulaRepository{
    private final DataSource dataSource;
    public AulaRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Aula> findAll() {
        List<Aula> aulas = new ArrayList<>();
        String sql = """
                SELECT a.id,
                       a.turma_id,
                       t.nome AS nome_turma,
                       a.data_hora,
                       a.assunto
                FROM aula a
                LEFT JOIN turma t ON a.turma_id = t.id
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                aulas.add(new Aula(
                        rs.getInt("id"),
                        rs.getInt("turma_id"),
                        rs.getString("nome_turma"),
                        rs.getObject("data_hora", LocalDateTime.class),
                        rs.getString("assunto")
                ));
            }
            return aulas;
        } catch (SQLException e){
            throw new RuntimeException("Erro ao buscar aulas", e);
        }
    }

    @Override
    public Optional<Aula> findById(Integer id) {
        String sql = """
                SELECT a.id,
                       a.turma_id,
                       t.nome AS nome_turma,
                       a.data_hora,
                       a.assunto
                FROM aula a
                LEFT JOIN turma t ON a.turma_id = t.id
                WHERE a.id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return Optional.of(new Aula(
                            rs.getInt("id"),
                            rs.getInt("turma_id"),
                            rs.getString("nome_turma"),
                            rs.getObject("data_hora", LocalDateTime.class),
                            rs.getString("assunto")
                    ));
                }
            }
            return Optional.empty();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao buscar aula", e);
        }
    }

    @Override
    public Aula save(Aula aula) {
        String sql = """
                INSERT INTO aula
                (turma_id, data_hora, assunto)
                VALUES
                (?,?,?)
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, aula.getTurmaId());
            stmt.setObject(2, aula.getDataHora());
            stmt.setString(3, aula.getAssunto());
            stmt.executeUpdate();
            try(ResultSet rs = stmt.getGeneratedKeys()){
                if (rs.next()) {
                    aula.setId(rs.getInt(1));
                }
            }
            return aula;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar aula", e);
        }
    }

    @Override
    public void update(Aula aula) {
        String sql = """
                UPDATE aula
                SET turma_id = ?,
                    data_hora = ?,
                    assunto = ?
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aula.getTurmaId());
            stmt.setObject(2, aula.getDataHora());
            stmt.setString(3, aula.getAssunto());
            stmt.setInt(4, aula.getId());
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao atualizar dados de aula", e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = """
                DELETE FROM aula
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao excluir aula", e);
        }
    }

    @Override
    public boolean exists(Integer id) {
        String sql = """
                SELECT id
                FROM aula
                WHERE id = ?
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                return rs.next();
            }
        } catch (SQLException e){
            throw new RuntimeException("Erro ao verificar se aula existe", e);
        }
    }
}
