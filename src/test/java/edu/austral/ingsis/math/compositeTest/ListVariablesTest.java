package edu.austral.ingsis.math.compositeTest;

import edu.austral.ingsis.math.composite.Operation;
import edu.austral.ingsis.math.composite.Operator;
import edu.austral.ingsis.math.composite.Variable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final List<String> result = new Operation(new Variable(1), new Variable(6), Operator.SUM).getVariableList(new ArrayList<>());
        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final List<String> result = new Operation(new Variable(12), new Variable("div"), Operator.DIVIDE).getVariableList(new ArrayList<>());
        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        final List<String> result = new Operation(new Operation(new Variable(9), new Variable("x"), Operator.DIVIDE), new Variable("y"), Operator.MULTIPLY).getVariableList(new ArrayList<>());
        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        final List<String> result = new Operation(new Operation(new Variable(27), new Variable("a"), Operator.DIVIDE), new Variable("b"), Operator.EXPONENT).getVariableList(new ArrayList<>());
        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        final List<String> result = new Operation(new Variable("z"),new Operation(new Variable(1), new Variable(2), Operator.DIVIDE), Operator.EXPONENT).getVariableList(new ArrayList<>());

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        final List<String> result = new Operation(new Operation(new Variable("value"), new Variable(0), Operator.ABSOLUTE), new Variable(8), Operator.SUBTRACT).getVariableList(new ArrayList<>());
        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        final List<String> result = new Operation(new Operation(new Variable(5), new Variable("i"), Operator.SUBTRACT),new Variable(8),Operator.MULTIPLY).getVariableList(new ArrayList<>());


        assertThat(result, containsInAnyOrder("i"));
    }
}
