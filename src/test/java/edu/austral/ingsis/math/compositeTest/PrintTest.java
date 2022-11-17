package edu.austral.ingsis.math.compositeTest;

import edu.austral.ingsis.math.composite.Operation;
import edu.austral.ingsis.math.composite.Operator;
import edu.austral.ingsis.math.composite.Variable;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1 + 6";
        final String result = new Operation(new Variable(1), new Variable(6), Operator.SUM).print();
        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "12 / 2";
        final String result = new Operation(new Variable(12), new Variable(2), Operator.DIVIDE).print();
        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9 / 2) * 3";
        final String result = new Operation(new Operation(new Variable(9), new Variable(2), Operator.DIVIDE),new Variable(3),Operator.MULTIPLY).print();
        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";
        final String result = new Operation(new Operation(new Variable(27), new Variable(6), Operator.DIVIDE),new Variable(2),Operator.EXPONENT).print();
        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";
        final String result = new Operation(new Operation(new Variable("value"), new Variable(0), Operator.ABSOLUTE),new Variable(8),Operator.SUBTRACT).print();
        assertThat(result, equalTo(expected));
    }
    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";
        final String result = new Operation(new Operation(new Variable(5), new Variable("i"), Operator.SUBTRACT),new Variable(8),Operator.MULTIPLY).print();

        assertThat(result, equalTo(expected));
    }
}
