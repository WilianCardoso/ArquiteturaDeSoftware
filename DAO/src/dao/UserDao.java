package dao;
import model.User;

public interface UserDao {

    User findUserByUserId(int id);

    void saveUser(User id);

    void deletarUser(int id);

}
