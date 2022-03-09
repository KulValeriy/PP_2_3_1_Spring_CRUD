package usergroup.DAO;

import org.springframework.stereotype.Repository;
import usergroup.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class UserDAOImpl implements UserDAO {


    @PersistenceContext
    private EntityManager entityManager;

    public UserDAOImpl() {
    }

    @Override
    public List<User> userList() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void changeUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }
}
