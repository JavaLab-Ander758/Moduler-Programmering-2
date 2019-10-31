package Del_01;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class HashForStringTest {
    @Test
    void hashCodeForString_ReturnsCorrectHashForString() {
        // Casting to int because jdk java.base/java/StringUTF16.java uses int for its hashcode method
        assertThat((int) HashForString.hashCodeForString("Donald Trump"),equalTo("Donald Trump".hashCode()));
    }

    @Test
    void hashCodeForString_ReturnsCorrectHashForEmptyString() {
        // Casting to int because jdk java.base/java/StringUTF16.java uses int for its hashcode method
        assertThat((int) HashForString.hashCodeForString(""), equalTo("".hashCode()));
    }
}