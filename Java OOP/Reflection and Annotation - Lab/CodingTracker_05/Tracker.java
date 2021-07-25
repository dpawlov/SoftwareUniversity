package CodingTracker_05;

import java.lang.reflect.Method;
import java.util.*;


@Author(name = "George")
public class Tracker {
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }

    public static void printMethodsByAuthor(Class<?> cl) {
        Map<String, List<String>> methodsByAuthor = new HashMap<>();
        Method[] methods = cl.getDeclaredMethods();

        for (Method method : methods) {

            Author annotation = method.getAnnotation(Author.class);
            if (annotation != null) {

                methodsByAuthor
                        .putIfAbsent(annotation.name(), new ArrayList<>());

                methodsByAuthor
                        .get(annotation.name()).add(method.getName() + "()");

            }
        }
    }
}

