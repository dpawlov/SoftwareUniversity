package Interfaces03lab;

public interface Person {
    String getName();

    default String sayHello() {
        return "Hello";
    }
}
