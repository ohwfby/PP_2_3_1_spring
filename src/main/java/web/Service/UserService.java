package web.Service;

import web.Model.User;
import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void delete(Long id);

    void edit(User user);
}
