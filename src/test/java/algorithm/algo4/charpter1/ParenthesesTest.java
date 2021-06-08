package algorithm.algo4.charpter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesesTest {

    @Test
    void isParentheses() {
        Parentheses parentheses = new Parentheses();
        assertTrue(parentheses.isParentheses("[()]{}{[()()]()}"));
        assertFalse(parentheses.isParentheses("[(])"));
        assertTrue(parentheses.isParentheses("()[]{}"));
        assertFalse(parentheses.isParentheses("][)(}{"));
    }

    @Test
    void addLeftParentheses() {
        Parentheses parentheses = new Parentheses();

        assertEquals("((1+2)*((3-4)*(5-6)))", parentheses.addLeftParentheses("1+2)*3-4)*5-6)))"));
        assertEquals("(1+2)/(3-4)*5", parentheses.addLeftParentheses("1+2)/3-4)*5"));
    }

}