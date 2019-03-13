package forum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TopicService {
    private List<Topic> topics = new ArrayList<>();

    public boolean addATopic(Topic topic) {
        if (!topics.contains(topic)) {
            topics.add(topic);
            System.out.println("Topic successfully added");
        } else {
            System.out.println("Topic exist");
        }
        return !topics.contains(topic);

    }

    public boolean removeTopic(String topic) {

        if (topics.stream()
                .map(Topic::getName)
                .noneMatch(e -> e.equals(topic))) {
            System.out.println("Topic don't exist");
        } else {
            topics = topics.stream()
                    .filter(e -> !e.getName().equals(topic))
                    .collect(Collectors.toList());
            System.out.println("Topic successfully removed");
        }
        return topics.stream()
                .map(Topic::getName)
                .noneMatch(e -> e.equals(topic));
    }

    public List<Topic> getTopics() {
        return topics;
    }


    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public void show(String name) {
        topics.stream()
                .filter(e -> e.getName().equals(name))
                .forEach(System.out::println);
    }

    public void showWithNumber(String name) {
        topics.stream()
                .filter(e -> e.getName().equals(name))
                .map(Topic::getPosts)
                .findAny()
                .get()
                .forEach(post -> System.out.println(post.getPostNumber() + ".     " + post.getText()));


    }

    @Override
    public String toString() {
        return "TopicService{" +
                "topics=" + topics +
                '}';
    }


}
