package web.dao;

import web.Model.User;
import java.util.List;

public interface UserDAO {
    public List<User> getUsers();
    public void save(User user);
    public void delete(User user);
    public void addUser(List<User> users);
}
