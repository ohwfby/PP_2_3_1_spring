package web.dao;

import web.Model.User;
import java.util.List;

public interface UserDAO {
    public void save(User user);
    public void delete(User user);
    public void update(User user);
    public User findById(int id);
    public List<User> findAll();
}
