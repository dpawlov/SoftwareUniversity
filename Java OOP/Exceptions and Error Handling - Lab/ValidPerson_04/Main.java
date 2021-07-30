package ValidPerson_04;

public class Main {
    public static void main(String[] args) {
        try {
            Person p = new Person("Dimitar", "Pavlov", 27);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception throw: " + ex.getMessage());
        }

    }
}