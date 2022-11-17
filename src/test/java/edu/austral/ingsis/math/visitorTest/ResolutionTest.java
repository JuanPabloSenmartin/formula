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


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        Function f = new Operation(new Variable(1), new Variable(6), Operator.SUM);
        Visitor v = new CalculateVisitor();
        f.accept(v);
        final double result = (double) v.getResult();
        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        Function f = new Operation(new Variable(12), new Variable(2), Operator.DIVIDE);
        Visitor v = new CalculateVisitor();
        f.accept(v);
        final double result = (double) v.getResult();
        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        Function f = new Operation(new Operation(new Variable(9), new Variable(2), Operator.DIVIDE),new Variable(3),Operator.MULTIPLY);
        Visitor v = new CalculateVisitor();
        f.accept(v);
        final double result = (double) v.getResult();
        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        Function f = new Operation(new Operation(new Variable(27), new Variable(6), Operator.DIVIDE),new Variable(2),Operator.EXPONENT);
        Visitor v = new CalculateVisitor();
        f.accept(v);
        final double result = (double) v.getResult();
        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        Function f = new Operation(new Variable(36),new Operation(new Variable(1), new Variable(2), Operator.DIVIDE),Operator.EXPONENT);
        Visitor v = new CalculateVisitor();
        f.accept(v);
        final double result = (double) v.getResult();
        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        Function f = new Operation(new Variable(136), new Variable(0), Operator.ABSOLUTE);
        Visitor v = new CalculateVisitor();
        f.accept(v);
        final double result = (double) v.getResult();
        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        Function f = new Operation(new Variable(-136), new Variable(0), Operator.ABSOLUTE);
        Visitor v = new CalculateVisitor();
        f.accept(v);
        final double result = (double) v.getResult();
        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Function f = new Operation(new Operation(new Variable(5), new Variable(5), Operator.SUBTRACT),new Variable(8),Operator.MULTIPLY);
        Visitor v = new CalculateVisitor();
        f.accept(v);
        final double result = (double) v.getResult();
        assertThat(result, equalTo(0d));
    }
}
