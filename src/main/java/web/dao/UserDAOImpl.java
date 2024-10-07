package web.dao;

import org.springframework.stereotype.Component;
import web.Model.User;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    public static List<User> users;
    private static int USER_COUNT;
    static {
        users = new ArrayList<>();
        users.add(new User("Michael","Semenov", (byte) 29));
        users.add(new User("Julia","Potapova", (byte) 21));
        users.add(new User("Ivan","Semenov", (byte) 20));
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void addUser(List<User> users) {
        UserDAOImpl.users = users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }
}
