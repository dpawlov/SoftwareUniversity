package StrategyPattern_06;

import ComparingObjects_05.Person;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person>peopleByNames=new TreeSet<>(new ComparatorPeople());
        TreeSet<Person>peopleByAges=new TreeSet<>(new ComparatorPeopleByAge());

        int n = Integer.parseInt(scanner.nextLine());

        while (n-->0) {

            String[] tokens = scanner.nextLine().split(" ");

            Person p = new Person(tokens[0],Integer.parseInt(tokens[1]));

            peopleByNames.add(p);
            peopleByAges.add(p);
        }
        for (Person person : peopleByNames) {
            System.out.println(person.toString());
        }
        for (Person person : peopleByAges) {
            System.out.println(person.toString());
        }

    }
}