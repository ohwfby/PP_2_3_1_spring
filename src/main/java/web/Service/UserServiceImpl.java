package web.Service;

import org.springframework.stereotype.Component;
import web.Model.User;

import java.util.ArrayList;
import java.util.List;
@Component

public class UserServiceImpl implements UserService {
    public static List<User> users;

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

    public void addUser(List<User> users) {
        UserServiceImpl.users = users;

    }
}
