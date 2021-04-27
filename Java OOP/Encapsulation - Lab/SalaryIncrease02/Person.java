package Encapsulation02;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName() {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName() {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge() {
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary() {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return String.format("%s %s gets %f leva.",
                this.firstName,
                this.lastName,
                this.salary);
    }

    public void increaseSalary(double bonus) {
        if (this.age > 30) {
            this.salary += this.salary * bonus / 100;
        } else {
            this.salary += this.salary * bonus / 200;
        }
    }
}
