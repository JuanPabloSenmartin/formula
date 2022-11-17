package edu.austral.ingsis.math.visitorTest;

import edu.austral.ingsis.math.composite.Function;
import edu.austral.ingsis.math.composite.Operation;
import edu.austral.ingsis.math.composite.Operator;
import edu.austral.ingsis.math.composite.Variable;
import edu.austral.ingsis.math.visitors.CalculateVisitor;

import edu.austral.ingsis.math.visitors.Visitor;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        Function f = new Operation(new Variable(1), new Variable("x", 3), Operator.SUM);
        Visitor v = new CalculateVisitor();
        f.accept(v);
        final double result = (double) v.getResult();
        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        Function f = new Operation(new Variable(12), new Variable("div", 4), Operator.DIVIDE);
        Visitor v = new CalculateVisitor();
        f.accept(v);
        final double result = (double) v.getResult();
        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        Function f = new Operation(new Operation(new Variable(9), new Variable("x", 3), Operator.DIVIDE), new Variable("y", 4), Operator.MULTIPLY);
        Visitor v = new CalculateVisitor();
        f.accept(v);
        final double result = (double) v.getResult();
        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        Function f = new Operation(new Operation(new Variable(27), new Variable("a", 9), Operator.DIVIDE), new Variable("b", 3), Operator.EXPONENT);
        Visitor v = new CalculateVisitor();
        f.accept(v);
        final double result = (double) v.getResult();
        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        Function f = new Operation(new Variable("z", 36),new Operation(new Variable(1), new Variable(2), Operator.DIVIDE), Operator.EXPONENT);
        Visitor v = new CalculateVisitor();
        f.accept(v);
        final double result = (double) v.getResult();
        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        Function f = new Operation(new Operation(new Variable("value",8), new Variable(0), Operator.ABSOLUTE),new Variable("value", 8), Operator.SUBTRACT);
        Visitor v = new CalculateVisitor();
        f.accept(v);
        final double result = (double) v.getResult();
        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        Function f = new Operation(new Operation(new Variable("value",-8), new Variable(0), Operator.ABSOLUTE),new Variable("value", 8), Operator.SUBTRACT);
        Visitor v = new CalculateVisitor();
        f.accept(v);
        final double result = (double) v.getResult();
        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        Function f = new Operation(new Operation(new Variable(5), new Variable("i", 2), Operator.SUBTRACT), new Variable(8), Operator.MULTIPLY);
        Visitor v = new CalculateVisitor();
        f.accept(v);
        final double result = (double) v.getResult();
        assertThat(result, equalTo(24d));
    }
}
