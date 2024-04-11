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
    void codeOneReturnsSeven() {
        assertEquals("7", digitter.calculateCheckDigit("1"));
    }

    @Test
    void codeTwoReturnsFour() {
        assertEquals("4", digitter.calculateCheckDigit("2"));
    }

    @Test
    void codeOneOneReturnsSix() {
        assertEquals("6", digitter.calculateCheckDigit("11"));
    }

    @Test
    void codeOneTwoReturnsThree() {
        assertEquals("3", digitter.calculateCheckDigit("12"));
    }

    @Test
    void codeTwoOneReturnsFive() {
        assertEquals("5", digitter.calculateCheckDigit("21"));
    }

    @Test
    void codeOneTwoThreeReturnsSix() {
        // 123 -> 3*3 + 2 + 3*1 = 14
        // 14 % 10 = 4
        assertEquals("6", digitter.calculateCheckDigit("123"));
    }

    @Test
    void appendSixWhenGivenCodeOneTwoThree() {
        assertEquals("1236", digitter.appendCheckDigit("123"));
    }
    @Test
    void appendFiveWhenGivenCodeOneThreeThree() {
        assertEquals("1335", digitter.appendCheckDigit("133"));
    }

    @Test
    void appendOneWhenGivenCode400638133393() {
        // For EAN-13 barcode 400638133393x, where x is the unknown check digit, (Stabilo Point 88 Art. No. 88/57)
        // [...] x = 1.
        // [Wikipedia: https://en.wikipedia.org/wiki/International_Article_Number]
        assertEquals("4006381333931", digitter.appendCheckDigit("400638133393"));
    }

    @Test
    void appendSevenWhenGivenCode7351353() {
        assertEquals("73513537", digitter.appendCheckDigit("7351353"));
    }
}
