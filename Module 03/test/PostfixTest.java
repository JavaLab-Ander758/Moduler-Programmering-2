import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PostfixTest {
    private static Postfix postfix = new Postfix();

    @ParameterizedTest
    @CsvFileSource(resources = "PostfixExamplesWithResults.csv")
    void testMultiplePostfixResults(String postfixExample, int result) {
        assertEquals(postfix.evaluateExpression(postfixExample), result);
    }
    @Test
    void postfix_mathOperationWithPlus() {
        assertThat(postfix.evaluateExpression("22 22 +"), is(equalTo(44)));
    }
    @Test
    void postfix_mathOperationWithMinus() {
        assertThat(postfix.evaluateExpression("55 22 -"), is(equalTo(33)));
    }
    @Test
    void postfix_mathOperationWithDivision() {
        assertThat(postfix.evaluateExpression("18 3 /"), is(equalTo(6)));
    }
    @Test
    void postfix_mathOperationWithTimes() {
        assertThat(postfix.evaluateExpression("4 4 *"), is(equalTo(16)));
    }
    @Test
    void posfix_mathOperationWithModulo() {
        assertThat(postfix.evaluateExpression("20 3 %"), is(equalTo(2)));
    }
}