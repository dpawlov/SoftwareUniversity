package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInaString01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        Map<Character, Integer> charCount = new LinkedHashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char x =  word.charAt(i);

            if (x == ' ') {
                continue;
            }
            if (!charCount.containsKey(x)) {
                charCount.put(x, 1);
            } else {
                charCount.put(x, charCount.get(x) + 1);
            }

        }


        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
