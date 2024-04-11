package misc.projects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CheckDigitTest {

    @Test
    void testClassInitialization() {
        CheckDigit digitter = new CheckDigit();
        assertTrue(digitter != null, "Created class should not be null");
        assertTrue(digitter instanceof CheckDigit, "Created class should be an instance of CheckDigit");
    }

}
