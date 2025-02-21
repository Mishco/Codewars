package kata.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DuplicateEncoderTest {

    @Test
    void sampleTest() {
//        "din"      =>  "((("
//        "recede"   =>  "()()()"
//        "Success"  =>  ")())())"
//        "(( @"     =>  "))(("
        assertEquals("(((",
                DuplicateEncoder.encode("din"));
        assertEquals("()()()",
                DuplicateEncoder.encode("recede"));
        assertEquals(")())())",
                DuplicateEncoder.encode("Success"));
        assertEquals("))((",
                DuplicateEncoder.encode("(( @"));
    }


    @Test
    void test() {
        assertEquals(")()())()(()()(",
                DuplicateEncoder.encode("Prespecialized"));
    }

    @Test
    void test2() {
        assertEquals("))))())))", DuplicateEncoder.encode("   ()(   "));
    }
}