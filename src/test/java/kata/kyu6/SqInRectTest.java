package kata.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SqInRectTest {
    @Test
    void test1() {
        assertEquals(new ArrayList<Integer>(Arrays.asList(3, 2, 1, 1)), SqInRect.sqInRect(5, 3));
    }

    @Test
    void test2() {
        assertEquals(null, SqInRect.sqInRect(5, 5));
    }

    @Test
    void test3() {
        assertEquals(new ArrayList<Integer>(Arrays.asList(3, 2, 1, 1)), SqInRect.sqInRect(3, 5));
    }

    @Test
    void test4() {
        assertEquals(new ArrayList<Integer>(Arrays.asList(2, 1, 1)), SqInRect.sqInRect(3, 2));
    }

    @Test
    void test5() {
        assertEquals(new ArrayList<Integer>(Arrays.asList(1, 1)), SqInRect.sqInRect(1, 2));
    }

}