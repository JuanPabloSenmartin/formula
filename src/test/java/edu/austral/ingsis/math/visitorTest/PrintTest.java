package edu.austral.ingsis.math.visitorTest;

import edu.austral.ingsis.math.composite.Function;
import edu.austral.ingsis.math.composite.Operation;
import edu.austral.ingsis.math.composite.Operator;
import edu.austral.ingsis.math.composite.Variable;
import edu.austral.ingsis.math.visitors.PrintVisitor;
import edu.austral.ingsis.math.visitors.Visitor;
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
        Function f = new Operation(new Variable(1), new Variable(6), Operator.SUM);
        Visitor v = new PrintVisitor();
        f.accept(v);
        final String result = (String) v.getResult();
        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "12 / 2";
        Function f = new Operation(new Variable(12), new Variable(2), Operator.DIVIDE);
        Visitor v = new PrintVisitor();
        f.accept(v);
        final String result = (String) v.getResult();
        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9 / 2) * 3";
        Function f = new Operation(new Operation(new Variable(9), new Variable(2), Operator.DIVIDE),new Variable(3),Operator.MULTIPLY);
        Visitor v = new PrintVisitor();
        f.accept(v);
        final String result = (String) v.getResult();
        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";
        Function f = new Operation(new Operation(new Variable(27), new Variable(6), Operator.DIVIDE),new Variable(2),Operator.EXPONENT);
        Visitor v = new PrintVisitor();
        f.accept(v);
        final String result = (String) v.getResult();
        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";
        Function f = new Operation(new Operation(new Variable("value"), new Variable(0), Operator.ABSOLUTE),new Variable(8),Operator.SUBTRACT);
        Visitor v = new PrintVisitor();
        f.accept(v);
        final String result = (String) v.getResult();
        assertThat(result, equalTo(expected));
    }
    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";
        Function f = new Operation(new Operation(new Variable(5), new Variable("i"), Operator.SUBTRACT),new Variable(8),Operator.MULTIPLY);
        Visitor v = new PrintVisitor();
        f.accept(v);
        final String result = (String) v.getResult();

        assertThat(result, equalTo(expected));
    }
}
