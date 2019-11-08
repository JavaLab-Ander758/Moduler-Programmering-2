import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    @Test
    void of_UnderZeroReturnsErrorMessage() {
        assertEquals("Input must be 0 or higher!", FizzBuzz.of(-1));
    }

    @Test
    void of_0Returns0() {
        assertEquals("0", FizzBuzz.of(0));
    }

    @Test
    void of_1Returns1() {
        assertEquals("1", FizzBuzz.of(1));
    }

    @Test
    void of_3ReturnsFizz() {
        assertEquals("Fizz", FizzBuzz.of(3));
    }

    @Test
    void of_5ReturnsBuzz() {
        assertEquals("Buzz", FizzBuzz.of(5));
    }

    @Test
    void of_6ReturnsFizz() {
        assertEquals("Fizz", FizzBuzz.of(6));
    }

    @Test
    void of_10ReturnsBuzz() {
        assertEquals("Buzz", FizzBuzz.of(10));
    }

    @Test
    void of_15ReturnsFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.of(15));
    }
}