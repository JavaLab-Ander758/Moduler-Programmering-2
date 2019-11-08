package Del_01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashForStringTest {
    // Casting to int because jdk java.base/java/StringUTF16.java uses int for its hashcode method

    @Test
    void hashCodeForString_ReturnsCorrectHashForString() {
        assertEquals("Donald Trump".hashCode(), (int)HashForString.hashCodeForString("Donald Trump"));
    }

    @Test
    void hashCodeForString_ReturnsCorrectHashForEmptyString() {
        assertEquals("".hashCode(), (int)HashForString.hashCodeForString(""));
    }
}