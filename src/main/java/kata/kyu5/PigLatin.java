package kata.kyu5;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PigLatin {

    private PigLatin() {}

    public static String pigIt(String str) {
        // Write code here
        return Arrays.stream(str.trim().split(" "))
                .map(word -> {
                    if (word.matches("[a-zA-Z]+")) {
                        return word.substring(1) + word.charAt(0) + "ay";
                    } else {
                        return word;
                    }
                })
                .collect(Collectors.joining(" "));
    }
}
