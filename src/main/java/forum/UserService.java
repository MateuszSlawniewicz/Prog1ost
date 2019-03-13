package forum;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users = new ArrayList<>();


    public boolean registration(String name, String password, String mail) {

        boolean noneExistenceUser = users.stream()
                .map(User::getName)
                .noneMatch(name::equals);
        if (noneExistenceUser) {
            User user = new User(name, password, mail);
            users.add(user);
        }
        return noneExistenceUser;
    }

    public boolean login(String name, String password) {
        User user = users.stream()
                .filter(us -> us.getName().equals(name) && us.getPassword().equals(password))
                .findAny()
                .orElse(null);
        Main.user = user;
        return user != null;
    }

}
