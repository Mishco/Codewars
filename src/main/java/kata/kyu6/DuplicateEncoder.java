package kata.kyu6;

import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * The goal of this exercise is:
 * to convert a string to a new string where each character in the new string is "("
 * if that character appears only once in the original string,
 * or ")" if that character appears more than once in the original string.
 * Ignore capitalization when determining if a character is a duplicate.
 */
class DuplicateEncoder {
    private DuplicateEncoder() {
    }

    static String encode(String word) {
        HashMap<Character, Integer> setOfCharacters = new HashMap<>();
        StringBuilder result = new StringBuilder();
        IntStream.range(0, word.length()).forEach(i -> {
            char lowerCase = Character.toLowerCase(word.charAt(i));
            if (setOfCharacters.containsKey(lowerCase)) {
                setOfCharacters.put(lowerCase, setOfCharacters.get(lowerCase) + 1);
            } else {
                setOfCharacters.put(lowerCase, 1);
            }
        });

        IntStream.range(0, word.length()).forEach(i -> {
            char lowerCase = Character.toLowerCase(word.charAt(i));
            if (setOfCharacters.containsKey(lowerCase) && setOfCharacters.get(lowerCase) <= 1) {
                result.append("(");
            } else {
                result.append(")");
            }
        });

        return result.toString();
    }
}
