package ExEcapsulation02;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setAge(age);
        this.setName(name);
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        if (this.age < 6) {
            return 2;
        } else if (this.age < 12) {
            return 1;
        } else {
            return 0.75;
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.0f eggs per day.",
                this.name, this.age, this.productPerDay());
    }


    private double calculateProductionPerDay() {
        return this.calculateProductionPerDay();
    }
}
