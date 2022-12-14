package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.visitors.Visitor;

import java.util.List;

public class Operation implements Function{
    private final Function function1;
    private final Function function2;
    private final Operator operator;

    public Operation(Function function1, Function function2, Operator operator) {
        this.function1 = function1;
        this.function2 = function2;
        this.operator = operator;
    }


    @Override
    public double calculate() {
        return Resolver.resolve(function1.calculate(), function2.calculate(), operator);
    }

    @Override
    public String print() {
        return Printer.print(function1, function2, operator);
    }

    @Override
    public boolean isVariable() {
        return false;
    }

    @Override
    public Operator getOperator() {
        return operator;
    }

    @Override
    public List<String> getVariableList(List<String> list) {
        list = function1.getVariableList(list);
        list = function2.getVariableList(list);
        return list;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitOperation(this);
    }

    public Function getFunction1() {
        return function1;
    }

    public Function getFunction2() {
        return function2;
    }
}
