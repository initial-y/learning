package algorithm.algo4.charpter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParenthesesTest {

    @Test
    void isParentheses() {
        Parentheses parentheses = new Parentheses();
        assertTrue(parentheses.isParentheses("[()]{}{[()()]()}"));
        assertFalse(parentheses.isParentheses("[(])"));
        assertTrue(parentheses.isParentheses("()[]{}"));
        assertFalse(parentheses.isParentheses("][)(}{"));
    }

}