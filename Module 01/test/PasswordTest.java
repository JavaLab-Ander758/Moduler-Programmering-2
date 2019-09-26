import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {
    private Password password;

    @BeforeEach
    void setUp() {
        password = new Password();
    }

    @Test
    void passwordCanNotBeLessThan10InLength() {
        assertFalse(password.checkPassword("jesus123"));
    }
    @Test
    void passwordWithOnlyDigitsShouldPass() {
        assertTrue(password.checkPassword("123456123456"));
    }
    @Test
    void passwordWithOnlyLettersShouldFail() {
        assertFalse(password.checkPassword("abcdefghijklmnopqrstuvwxyz"));
    }
    @Test
    void passwordWithLessThan3DigitsShouldFail() {
        assertFalse(password.checkPassword("jesuschrist23"));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "passwordsWithNonAlphanumerics.csv")
    void passwordExceedingAlphanumericRestrictionsShouldFail(String nonAlphanumericPassword) {
        assertFalse(password.checkPassword(nonAlphanumericPassword));
    }
}