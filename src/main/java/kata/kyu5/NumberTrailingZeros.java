package kata.kyu5;

public class NumberTrailingZeros {

    private NumberTrailingZeros() {
    }

    public static int zeros(int n) {
        int count = 0;

        // Keep dividing N by powers of 5 and update count
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
