package web.Service;

import web.Model.User;
import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(int id);
    public void save(User user);
    public void delete(User user);
}
