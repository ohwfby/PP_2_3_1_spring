package web.dao;

import web.Model.User;

import java.util.List;

public interface UserDAO {
    void save(User user);

    void delete(Long id);

    void edit(User user);

    User findById(Long id);

    List<User> findAll();
}
