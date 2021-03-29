package OpinionPoll03;

public class Person <Person> {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person p) {
        return this.getName().compareTo(p.getName());
    }
}
