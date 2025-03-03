package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDaoImpl implements UserDao {

    private Connection connection;

    public UserDaoImpl() {
        this.connection = Conexao.getConexao(); 
    }

    @Override
    public User findUserByUserId(int id) {
        User user = null;
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void saveUser(User user) {
        String sql = "INSERT INTO usuario (nome) VALUES (?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Usuário salvo com sucesso!");
            } else {
                System.out.println("Erro ao salvar o usuário.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletarUser(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(int id, String name) {
        String sql = "UPDATE usuario SET nome = ? WHERE id = ?";
    
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setString(1, name);
            stmt.setInt(2, id);
    
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                System.out.println("Nenhum usuário foi atualizado. Verifique se o ID existe.");
            } else {
                System.out.println("Usuário atualizado com sucesso!");
            }
    
        } catch (SQLException e) {
            e.printStackTrace(); // Exibe o erro exato no console
        }
    }
}