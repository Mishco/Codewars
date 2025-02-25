package kata.kyu6;

/**
 * Implement a pseudo-encryption algorithm which given a string S and an integer N
 * concatenates all the odd-indexed characters of S with all the even-indexed characters of S,
 * this process should be repeated N times.
 * </br>
 * Examples:
 * </br>
 * encrypt("012345", 1)  =>  "135024"
 * encrypt("012345", 2)  =>  "135024"  ->  "304152"
 * encrypt("012345", 3)  =>  "135024"  ->  "304152"  ->  "012345"
 * </br>
 * encrypt("01234", 1)  =>  "13024"
 * encrypt("01234", 2)  =>  "13024"  ->  "32104"
 * encrypt("01234", 3)  =>  "13024"  ->  "32104"  ->  "20314"
 * </br>
 * Together with the encryption function, you should also implement a decryption function which reverses the process.
 * </br>
 * If the string S is an empty value or the integer N is not positive, return the first argument without changes.
 * </br>
 */
public class Kata {
    private Kata() {
    }

    public static String encrypt(final String text, final int n) {
        if (n == 0) {
            return text;
        }

        StringBuilder result = new StringBuilder(text);
        for (int j = 0; j < n; j++) {
            StringBuilder sr = new StringBuilder();
            StringBuilder sr2 = new StringBuilder();
            for (int i = 0; i < result.length(); i++) {
                if (i % 2 != 0) {
                    sr.append(result.charAt(i));
                } else {
                    sr2.append(result.charAt(i));
                }
            }
            result = sr.append(sr2);
        }


        return result.toString();
    }


    public static String decrypt(final String encryptedText, final int n) {
        if (encryptedText == null || encryptedText.isEmpty() || n <= 0) {
            return encryptedText;
        }

        String result = encryptedText; // Hold the current state of decrypted text

        for (int i = 0; i < n; i++) {
            int len = result.length();
            String evenHalf = result.substring(0, len / 2); // Characters that were originally odd
            String oddHalf = result.substring(len / 2); // Characters that were originally even

            StringBuilder original = new StringBuilder(); // Use StringBuilder for efficiency

            for (int j = 0; j < len; j++) {
                if (j % 2 == 0) {
                    original.append(oddHalf.charAt(0)); // Append from oddHalf
                    oddHalf = oddHalf.substring(1); // Remove the first character from oddHalf
                } else {
                    original.append(evenHalf.charAt(0)); // Append from evenHalf
                    evenHalf = evenHalf.substring(1); // Remove the first character from evenHalf
                }
            }

            result = original.toString(); // Update result with the newly decrypted string
        }

        return result; // Return the fully decrypted string
    }

}
