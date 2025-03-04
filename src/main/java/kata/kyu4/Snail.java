package kata.kyu4;

import java.util.ArrayList;

public class Snail {

    private Snail() {
    }

    public static int[] snail(int[][] array) {
        if (array[0].length == 0) return new int[0];

        // Initialize boundaries
        int m = array.length;
        int n = array[0].length;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        ArrayList<Integer> res = new ArrayList<>();

        while (top <= bottom && left <= right) {

            // top row from left to right
            for (int i = left; i <= right; i++) res.add(array[top][i]);
            top++;

            // right column from top to bottom
            for (int i = top; i <= bottom; i++) res.add(array[i][right]);
            right--;

            // bottom row from right to left, if present
            if (top <= bottom) {
                for (int i = right; i >= left; i--) res.add(array[bottom][i]);
                bottom--;
            }

            // left column from bottom to top (if present)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) res.add(array[i][left]);
                left++;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

}
