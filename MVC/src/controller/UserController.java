package controller;

import model.User;
import view.UserView;

public class UserController {

    private User model;
    private UserView view;

    public UserController(User model, UserView view) {
        this.model = model;
        this.view = view;
    }

    public void setUserName(String name) {
        model.setName(name);
    }

    public String gerUserName() {
        return model.getName();
    }

    public void updateView() {
        view.displayUser(model);
    }
}
