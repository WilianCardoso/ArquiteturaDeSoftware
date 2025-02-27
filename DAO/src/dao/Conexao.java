package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    // Método para obter a conexão com o banco de dados
    public static Connection getConexao() {
        Connection conexao = null;

        // Definição do Driver
        String driver = "com.mysql.cj.jdbc.Driver";
        // Informações do banco de dados
        String url = "jdbc:mysql://localhost:3306/db_DAO";
        String user = "root";
        String password = "";

        try {
            // Carrega o driver do MySQL (opcional para Java 8+)
            Class.forName(driver);

            // Obtém a conexão com o banco de dados
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados: " + e.getMessage());
        }

        return null; // Retorna null em caso de erro
    }
}