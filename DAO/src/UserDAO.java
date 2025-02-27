
public interface UserDAO {

    User findUserByUserId(int id);

    void saveUser(User id);

    void deletarUser(int id);
}
