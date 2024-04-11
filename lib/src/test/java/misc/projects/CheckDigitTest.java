package misc.projects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckDigitTest {
    private CheckDigit digitter;

    @BeforeEach
    void setupClass() {
        digitter = new CheckDigit();
    }

    @Test
    void testClassInitialization() {
        assertTrue(digitter != null, "Created class should not be null");
        assertTrue(digitter instanceof CheckDigit, "Created class should be an instance of CheckDigit");
    }
    
    @Test
    void codeOneReturnsThree() {
        assertEquals(3, digitter.calculateCheckDigit(1));
    }

    @Test
    void codeTwoReturnsSix() {
        assertEquals(6, digitter.calculateCheckDigit(2));
    }

    @Test
    void codeOneOneReturnsFour() {
        assertEquals(4, digitter.calculateCheckDigit(11));
    }

    @Test
    void codeOneTwoReturnsSeven() {
        assertEquals(7, digitter.calculateCheckDigit(12));
    }

    @Test
    void codeTwoOneReturnsThree() {
        assertEquals(5, digitter.calculateCheckDigit(21));
    }

    @Test
    void codeOneTwoThreeReturnsFour() {
        // 123 -> 3*3 + 2 + 3*1 = 14
        // 14 % 10 = 4
        assertEquals(4, digitter.calculateCheckDigit(123));
    }

    @Test
    void appendFourWhenGivenCodeOneTwoThree() {
        assertEquals(1234, digitter.appendCheckDigit(123));
    }
    @Test
    void appendFiveWhenGivenCodeOneThreeThree() {
        assertEquals(1335, digitter.appendCheckDigit(133));
    }

//     @Test
//     void appendSevenWhenGivenCode400638133393() {
//         //TODO: switch from int to string, since long ints cause problems
//         assertEquals(400638133393, digitter.appendCheckDigit(4006381333931));
//     }
}
