package ifpb.ads.jsf.infra;

import ifpb.ads.jsf.domain.Pessoa;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 25/01/2017, 08:28:19
 */
//@Named
//@Dependent
//@RequestScoped
@Stateless
@Remote(Pessoas.class)
public class PessoaBD implements Pessoas, Serializable {

    private Connection connection;

    public PessoaBD() {
//        init();
    }

    @PostConstruct
    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dac-jsf", "postgres", "12345");
        } catch (SQLException ex) {
            Logger.getLogger(PessoaBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PessoaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizarPessoa(Pessoa pessoa) {
         try {

            String sql = "UPDATE Pessoa SET nome=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pessoa.getNome());
            statement.setInt(2, pessoa.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluirPessoa(Pessoa pessoa) {
        try {
            String sql = "DELETE FROM Pessoa WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pessoa.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void salvar(Pessoa pessoa) {
        try {
            String sql = "INSERT INTO Pessoa (nome) VALUES(?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pessoa.getNome());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Pessoa> todasAsPessoas() {
        try {
            String consulta = "SELECT * FROM Pessoa";

            PreparedStatement statement = connection.prepareStatement(consulta);
            return criarPessoa(statement);

        } catch (SQLException ex) {
            Logger.getLogger(PessoaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.emptyList();
    }

    private List<Pessoa> criarPessoa(PreparedStatement statement) throws SQLException {
        List<Pessoa> pessoas = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Pessoa pessoa = new Pessoa(
                    resultSet.getInt("id"),
                    resultSet.getString("nome"));
            pessoas.add(pessoa);
        }

        return pessoas;
    }

}
