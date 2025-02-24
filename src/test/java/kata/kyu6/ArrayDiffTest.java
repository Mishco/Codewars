package kata.kyu6;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayDiffTest {
    @Test
    public void sampleTests() {
        assertArrayEquals(new int[]{2}, ArrayDiff.arrayDiff(new int[]{1, 2}, new int[]{1}));
        assertArrayEquals(new int[]{2, 2}, ArrayDiff.arrayDiff(new int[]{1, 2, 2}, new int[]{1}));
        assertArrayEquals(new int[]{1}, ArrayDiff.arrayDiff(new int[]{1, 2, 2}, new int[]{2}));
        assertArrayEquals(new int[]{1, 2, 2}, ArrayDiff.arrayDiff(new int[]{1, 2, 2}, new int[]{}));
        assertArrayEquals(new int[]{}, ArrayDiff.arrayDiff(new int[]{}, new int[]{1, 2}));
    }
}