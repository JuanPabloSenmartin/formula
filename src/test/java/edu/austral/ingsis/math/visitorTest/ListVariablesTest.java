package edu.austral.ingsis.math.visitorTest;

import edu.austral.ingsis.math.composite.Function;
import edu.austral.ingsis.math.composite.Operation;
import edu.austral.ingsis.math.composite.Operator;
import edu.austral.ingsis.math.composite.Variable;
import edu.austral.ingsis.math.visitors.ListVariablesVisitor;
import edu.austral.ingsis.math.visitors.Visitor;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Function f = new Operation(new Variable(1), new Variable(6), Operator.SUM);
        Visitor v = new ListVariablesVisitor();
        f.accept(v);
        final List<String> result = (List<String>) v.getResult();
        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        Function f = new Operation(new Variable(12), new Variable("div"), Operator.DIVIDE);
        Visitor v = new ListVariablesVisitor();
        f.accept(v);
        final List<String> result = (List<String>) v.getResult();
        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Function f = new Operation(new Operation(new Variable(9), new Variable("x"), Operator.DIVIDE), new Variable("y"), Operator.MULTIPLY);
        Visitor v = new ListVariablesVisitor();
        f.accept(v);
        final List<String> result = (List<String>) v.getResult();
        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Function f = new Operation(new Operation(new Variable(27), new Variable("a"), Operator.DIVIDE), new Variable("b"), Operator.EXPONENT);
        Visitor v = new ListVariablesVisitor();
        f.accept(v);
        final List<String> result = (List<String>) v.getResult();
        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Function f = new Operation(new Variable("z"),new Operation(new Variable(1), new Variable(2), Operator.DIVIDE), Operator.EXPONENT);
        Visitor v = new ListVariablesVisitor();
        f.accept(v);
        final List<String> result = (List<String>) v.getResult();
        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Function f = new Operation(new Operation(new Variable("value"), new Variable(0), Operator.ABSOLUTE), new Variable(8), Operator.SUBTRACT);
        Visitor v = new ListVariablesVisitor();
        f.accept(v);
        final List<String> result = (List<String>) v.getResult();
        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Function f = new Operation(new Operation(new Variable(5), new Variable("i"), Operator.SUBTRACT),new Variable(8),Operator.MULTIPLY);
        Visitor v = new ListVariablesVisitor();
        f.accept(v);
        final List<String> result = (List<String>) v.getResult();
        assertThat(result, containsInAnyOrder("i"));
    }
}