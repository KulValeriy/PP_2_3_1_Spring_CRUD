package usergroup.service;

import usergroup.model.User;

import java.util.List;


public interface UserService {
    List<User> userList();

    void addUser(User user);

    void deleteUser(int id);

    void changeUser(User user);

    User getUserById(int id);
}
