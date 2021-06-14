package Jar;

public class Main {
    public static void main(String[] args) {
        Jar<String> jarOne = new Jar<String>();
        Jar<Integer> jarTwo = new Jar<Integer>();

        jarOne.add("Pesho");
        jarTwo.add(3);

        System.out.println(jarOne.remove());
        System.out.println(jarTwo.remove());
    }
}
