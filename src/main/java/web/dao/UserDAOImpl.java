package web.dao;

import org.springframework.stereotype.Component;
import web.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    private static List<User> users;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
