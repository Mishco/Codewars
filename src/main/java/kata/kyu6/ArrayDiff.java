package kata.kyu6;

import java.util.Arrays;
import java.util.List;

public class ArrayDiff {

    private ArrayDiff() {}

    public static int[] arrayDiff(int[] a, int[] b) {
        List<Integer> diff = Arrays.stream(b).boxed().toList();

        return Arrays.stream(a).filter(item -> !diff.contains(item)).toArray();
    }

}
