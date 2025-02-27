package view;
import model.User;

public class UserView {
    public void displayUser(User user){
        System.out.println("User " + user.getName());
    }

}
