package zoo;

public abstract class Animal {

    private String name;
    private Integer age;
    public Animal(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "name : " + getName() + " age : " + getAge();
    }
}
