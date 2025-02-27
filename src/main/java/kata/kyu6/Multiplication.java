package kata.kyu6;

public class Multiplication {
    private Multiplication() {
    }

    public static int[][] multiplicationTable(int n) {
        int[][] result = new int[n][n];

        if (n == 1) {
            return new int[][]{{1}};
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = (i + 1) * (j + 1);
            }
        }
        return result;
    }
}
