package br.com.centroweg.escola.repository.curso;

import br.com.centroweg.escola.model.Curso;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CursoRepositoryImpl implements CursoRepository{
    private final DataSource dataSource;
    public CursoRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Curso> findAll() {
        List<Curso> cursos = new ArrayList<>();
        String sql = """
                SELECT id,
                       nome,
                       codigo
                FROM curso
                """;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            try(ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    cursos.add(new Curso(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("codigo")
                    ));
                }
            }
            return cursos;
        } catch (SQLException e){
            throw new RuntimeException("Erro ao buscar cursos", e);
        }
    }

    @Override
    public Optional<Curso> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Curso save(Curso curso) {
        return null;
    }

    @Override
    public void update(Curso curso) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public boolean exists(Integer id) {
        return false;
    }
}
