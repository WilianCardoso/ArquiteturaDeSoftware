

import java.sql.*;
import javax.swing.JOptionPane;



public class Conexao {

    public static Conexao conector() {
        Conexao conexao = null;

        // Definição do Driver
        String driver = "com.mysql.cj.jdbc.Driver";
        // Informações do banco de dados
        String url = "jdbc:mysql://localhost:3306/DB_DAO";
        String user = "root";
        String password = "";

        // tentativa de conexão
        try {
            Class.forName(driver);
            conexao = (Conexao) DriverManager.getConnection(url, user, password);
            return conexao;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    "Erro no módulo de conexão: " + erro);
            return null;
        }

    }

}
