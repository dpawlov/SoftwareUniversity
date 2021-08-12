package BirthdayCelebrations_03;

public class Citizen implements Person, Identifiable, Birthable, Machine, Creature {
    private String name;
    private int age;
    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthDate() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getModel() {
        return null;
    }
}