package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.visitors.Visitor;

import java.util.List;

public class Variable implements Function{
    private final String name;
    private final double value;
    private final boolean isVariable;
    private final boolean isNumber;

    public Variable(String name, double value) {
        this.name = name;
        this.value = value;
        this.isVariable = true;
        this.isNumber = true;
    }
    public Variable(double value) {
        this.name = null;
        this.value = value;
        this.isVariable = true;
        this.isNumber = true;
    }
    public Variable(String name) {
        this.name = name;
        this.value = 0;
        this.isVariable = true;
        this.isNumber = false;
    }

    @Override
    public double calculate() {
        return this.value;
    }

    @Override
    public String print() {
        if (isNumber) return String.valueOf((int)this.value);
        return name;
    }

    @Override
    public boolean isVariable() {
        return isVariable;
    }

    public boolean isNumber() {
        return isNumber;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Operator getOperator() {
        return null;
    }

    @Override
    public List<String> getVariableList(List<String> list) {
        if (!isNumber && !list.contains(name)) list.add(name);
        return list;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitVariable(this);
    }

}
