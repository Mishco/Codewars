package kata.kyu5;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberTrailingZerosTest {
    @Test
    public void testZeros() {
        assertThat(NumberTrailingZeros.zeros(0), is(0));
        assertThat(NumberTrailingZeros.zeros(6), is(1));
        assertThat(NumberTrailingZeros.zeros(14), is(2));

    }
}