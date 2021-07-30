package ValidPerson_04;

public class Person {
    private String name;
    private String lastName;
    private int age;

    public Person(String name, String lastName, int age) {
        setName(name);
        setLastName(lastName);
        setAge(age);
    }

    private void setName(String name) {
        if (!isValidString(name)) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        } else {
            this.name = name;
        }

    }

    private boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    private void setLastName(String lastName) {
        if (!isValidString(lastName)) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        } else {
            this.lastName = lastName;
        }

    }

    private void setAge(int age) {
        if (age < 0 || age >= 110) {
            throw new IllegalArgumentException("Age must be in range [0...110]");
        } else {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
