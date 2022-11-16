package edu.austral.ingsis.math.composite;

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
}
