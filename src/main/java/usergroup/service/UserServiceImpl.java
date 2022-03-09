package usergroup.service;

import org.springframework.beans.factory.annotation.Autowired;
import usergroup.DAO.UserDAO;
import org.springframework.stereotype.Service;
import usergroup.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> userList() {
        return userDAO.userList();
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Override
    public void changeUser(User user) {
        userDAO.changeUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }
}
