import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

class GenericStackTest {
    private GenericStack genericStack;
    private GenericStack<String> gsString;
    private GenericStack<Integer> gsInteger;

    @BeforeEach
    void setUp() {
        genericStack = new GenericStack(100);
        gsString = new GenericStack<>(100);
        gsInteger = new GenericStack<>(100);
    }

    @Test
    void sizeMethodShouldReturnCorrectSizeOfArray() {
        gsString.push("Java");
        gsString.push("er");
        gsString.push("morsomt! :D");
        assertThat(gsString.size(), is(equalTo(3)));
    }
    @Test
    void peekMethodShouldReturnLastElementInTheArray() {
        gsString.push("First");
        gsString.push("Second");
        gsString.push("Last");
        assertThat(gsString.peek(), is(equalTo("Last")));
    }
    @Test
    void peekMethodReturnsNULLifArrayIsEmpty() {
        assertThat(genericStack.peek(), is(equalTo(null)));
    }
    @Test
    void pushMethodShouldDoubleSizeOfArrayIfArrayIsFullWhenPushing() {
        for (int i = 0; i < 100; i++) {
            gsString.push("foo");
        }
        gsString.push("Fighters");
        assertThat(gsString.getTotalLengthOfElements(), is(equalTo(100 * 2)));
    }
    @Test
    void popMethodShouldRemoveLastElementInArray() {
        gsString.push("One");
        gsString.push("Two");
        gsString.push("Three");
        gsString.push("Four");
        gsString.push("Five");
        gsString.pop();
        assertThat(gsString.peek(), is(equalTo("Four")));
    }
    @Test
    void popMethodDoesNothingIfArrayIsEmpty() {
        genericStack.pop();
        assertThat(genericStack.size(), is(equalTo(0)));
    }
    @Test
    void isEmptyMethodShouldReturnTrueIfArrayIsEmpty() {
        assertTrue(genericStack.isEmpty());
    }
    @Test
    void toStringMethodPrintsCorrectlyWithStrings() {
        gsString.push("One");
        gsString.push("Two");
        gsString.push("Three");
        assertThat(gsString.toString(), is(equalTo("[One, Two, Three]")));
    }
    @Test
    void toStringMethodPrintsCorrectlyWithInteger() {
        gsInteger.push(1);
        gsInteger.push(2);
        gsInteger.push(3);
        assertThat(gsInteger.toString(), is(equalTo("[1, 2, 3]")));
    }
}