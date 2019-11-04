import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
    private FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    void of_ReturnsExceptionIfInputIsLessThan0() {
        IllegalArgumentException thrown =
                assertThrows(IllegalArgumentException.class,
                        () -> fizzBuzz.of(-1),
                        "Expected fizzBuzz.of(-1) to throw, but it didn't!");
        assertTrue(thrown.getMessage().contains("-1 received as input, only numbers >= 0 is allowed!"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "NumbersThatAreDividableByThree.csv")
    void of_Returns_fizz_IfInputIsDividableByThree(int number) {
        assertEquals("fizz", fizzBuzz.of(number));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "NumbersThatAreDividableByFive.csv")
    void of_Returns_buzz_IfInputIsDividableByFive(int number) {
        assertEquals("buzz", fizzBuzz.of(number));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "NumbersThatAreDividableByThreeAndFive.csv")
    void of_Returns_fizzbuzz_IfInputIsDividableByThreeAndFive(int number) {
        assertEquals("fizzbuzz", fizzBuzz.of(number));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "NumbersThatAreNotDividableByThreeAndFive.csv")
    void of_ReturnsNumberAsStringIfNotDividableByThreeOrFive(int number) {
        assertEquals(Integer.toString(number), fizzBuzz.of(number));
    }
}