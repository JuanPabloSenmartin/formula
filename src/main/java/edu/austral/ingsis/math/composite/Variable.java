package edu.austral.ingsis.math.composite;

public class Variable implements Function{
    private final String name;
    private final double value;

    public Variable(String name, double value) {
        this.name = name;
        this.value = value;
    }
    public Variable(double value) {
        this.name = null;
        this.value = value;
    }

    @Override
    public double calculate() {
        return this.value;
    }

    @Override
    public String print() {
        return String.valueOf((int)this.value);
    }
}
