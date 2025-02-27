package kata.kyu6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MultiplicationTest {

    @Test
    @DisplayName("n = 3")
    void test3() {
        int[][] test = {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        assertArrayEquals(test, Multiplication.multiplicationTable(3));
    }

    @Test
    @DisplayName("n = 4")
    void test4() {
        int[][] test = {{1, 2, 3, 4}, {2, 4, 6, 8}, {3, 6, 9, 12}, {4, 8, 12, 16}};
        assertArrayEquals(test, Multiplication.multiplicationTable(4));
    }

    @Test
    @DisplayName("n = 1")
    void test1() {
        int[][] test1 = {{1}};
        assertArrayEquals(test1, Multiplication.multiplicationTable(1));
    }

}