package forum;

import java.util.ArrayList;
import java.util.Objects;

public class User {

    private Long id;
    private String name;
    private String mailAddres;
    private String password;
    private ArrayList<Post> userPosts;
    static long counter = 0;

    public User(String name, String password, String mailAddres) {
        counter = counter + 1;
        this.id = counter;
        this.name = name;
        this.password = password;
        this.mailAddres = mailAddres;
    }

    @Override
    public String toString() {
        return "User login: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // todo  deletePost, editPost,

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailAddres() {
        return mailAddres;
    }

    public void setMailAddres(String mailAddres) {
        this.mailAddres = mailAddres;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Post> getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(ArrayList<Post> userPosts) {
        this.userPosts = userPosts;
    }
}
