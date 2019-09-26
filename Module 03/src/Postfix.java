import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Postfix {

    /**
     * The backing {@link Deque} used as a stack when evaluating postfix expressions.
     */
    private final Deque<Integer> stack;

    /**
     * Instantiates a new {@link Postfix} object, assigning it its own {@link ArrayDeque}.
     */
    public Postfix() {
        this.stack = new ArrayDeque<>();
    }

    /**
     * Evaluates a postfix expression.
     *
     * @param expression The postfix expression to evaluate.
     * @return The result of evaluating the specified postfix expression.
     */
    public int evaluateExpression(String expression) {
        var tokenizer = new StringTokenizer(expression, "+-/*% ", true);
        scanAndProcessTokens(tokenizer);
        return stack.pop();
    }

    /**
     * Scans all tokens contained in the specified {@link StringTokenizer} and either pushes them to this class'
     * {@link #stack} field (after parsing the token as an {@code int}) or treats the token as an operator and
     * evaluates the expression using the two top-most elements of the backing stack.
     *
     * @param tokenizer The {@link StringTokenizer} that contains the tokens of the postfix expression to evaluate.
     */
    private void scanAndProcessTokens(StringTokenizer tokenizer) {
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();

            if (token.isEmpty()) {
                continue;
            }

            if (token.matches("[+-/*%]")) {
                evaluate(token, stack.pop(), stack.pop());
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
    }

    /**
     * Evaluates the following infix expression and stores it in this class' {@code stack} field:
     * <pre>{@code secondOperand operator firstOperand}</pre>
     *
     * For example, if {@code secondOperand} is {@code 1}, {@code operator} is {@code +}, and {@code firstOperand} is
     * {@code 2}, then the result would be {@code 3}.
     *
     * @param operator      The operator to use when evaluating the expression.
     * @param firstOperand  The first operand of the expression.
     * @param secondOperand The second operand of the expression.
     */
    private void evaluate(String operator, int firstOperand, int secondOperand) {
        switch (operator) {
            case "+":
                stack.push(secondOperand + firstOperand);
                break;
            case "-":
                stack.push(secondOperand - firstOperand);
                break;
            case "/":
                stack.push(secondOperand / firstOperand);
                break;
            case "*":
                stack.push(secondOperand * firstOperand);
                break;
            case "%":
                stack.push(secondOperand % firstOperand);
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Postfix().evaluateExpression("4 2 + 3 5 1 - * +"));
    }
}