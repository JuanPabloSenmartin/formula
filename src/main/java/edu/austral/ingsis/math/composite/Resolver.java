package edu.austral.ingsis.math.composite;

public class Resolver {
    public static double resolve(double value1, double value2, Operator operator){
        switch (operator){
            case SUM:
                return value1 + value2;
            case SUBTRACT:
                return value1 - value2;
            case MULTIPLY:
                return value1 * value2;
            case DIVIDE:
                return value1 / value2;
            case EXPONENT:
                return Math.pow(value1, value2);
            case SQRT:
                return Math.sqrt(value1);
            case ABSOLUTE:
                return Math.abs(value1);
            default:
                throw new UnsupportedOperationException("Invalid operation!");
        }
    }
}
