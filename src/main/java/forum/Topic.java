package forum;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Topic {
    private ArrayList<Post> posts;
    private String name;

    public Topic(String name) {
        this.name = name;
        this.posts = new ArrayList<Post>();

    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "\n"
                + posts;
    }

    public void removePostFromTopic(String numberOfPost) {
        if (posts.stream()
                .mapToInt(Post::getPostNumber)
                .noneMatch(e -> e == Integer.parseInt(numberOfPost))) {
            System.out.println("Wrong number");
        }
        posts = (ArrayList<Post>) posts.stream()
                .filter(e -> !e.getPostNumber().toString().equals(numberOfPost))
                .collect(Collectors.toList());

    }
}
