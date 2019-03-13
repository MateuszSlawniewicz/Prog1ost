package forum;

public class Post {
    private Integer postNumber;
    private String text;
    private Topic topic;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;


    public Post(String text, Topic topic) {
        this.text = text;
        this.topic = topic;
        this.postNumber = topic.getPosts().size();
        topic.getPosts().add(this);
        this.user = Main.user;
    }

    @Override
    public String toString() {
        return "User: " + user.getName() + "\n" + text + "\n\n";
    }

    public Integer getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(Integer postNumber) {
        this.postNumber = postNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
