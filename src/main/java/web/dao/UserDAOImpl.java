package web.dao;

import org.springframework.stereotype.Component;
import web.Model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void delete(User user) {
        if(!em.contains(user)) {
            user = em.find(User.class, user.getId());
        }
        em.remove(user);
        em.flush();
    }

    @Override
    public void edit(User user) {
//        User userToEdit = em.find(User.class, user.getId());
        if (!em.contains(user)) {
            user = em.find(User.class, user.getId());
        }
        em.merge(user);
    }

    @Override
    public User findById(Long id) {
        User user = em.find(User.class, id);
        if(user == null) {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("FROM User ", User.class).getResultList();
    }
}
