package AssociativeArrays;

import java.util.*;

public class WordSynonyms02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfPairs = Integer.parseInt(scanner.nextLine());

       Map<String, List<String>> synonymDictionary= new LinkedHashMap<>();

        for (int i = 0; i < countOfPairs; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!synonymDictionary.containsKey(word)) {
                List<String> synonymsForCurrentWord = new ArrayList<>();
                synonymsForCurrentWord.add(synonym);
                synonymDictionary.put(word,synonymsForCurrentWord);

            } else {
                List<String> synonymsForCurrentWord = synonymDictionary.get(word);
                synonymsForCurrentWord.add(synonym);
                synonymDictionary.put(word, synonymsForCurrentWord);
            }
        }

        for (Map.Entry<String, List<String>> entry : synonymDictionary.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }

    }
}
