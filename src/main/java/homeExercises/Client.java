package homeExercises;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Client {

    static HashMap<Long, Client> clients = new HashMap<>();


    private Long id;
    private String name;
    private String lastName;
    private String phoneNumber;
    long counter = 0;

    {
        counter++;
        id = counter;
    }


    public Client(String name, String lastName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static void addClient(Client client) {
        clients.put(client.getId(), client);

    }

    public static void showClients() {
        Collection<Client> names = clients.values();
        names.stream()
                .forEach(e -> System.out.println(e.name + " " + e.lastName));

    }
}

