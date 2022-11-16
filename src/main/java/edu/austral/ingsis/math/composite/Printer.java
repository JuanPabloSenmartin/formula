package edu.austral.ingsis.math.composite;

public class Printer {
    public static String print(Function f1, Function f2, Operator operator){
        switch (operator){
            case SUM:
                return f1.print() + " + " + f2.print();
            case SUBTRACT:
                return f1.print() + " - " + f2.print();
            case MULTIPLY:
                return f1.print() + " * " + f2.print();
            case DIVIDE:
                return f1.print() + " / " + f2.print();
            case EXPONENT:
                return f1.print() + " ^ " + f2.print();
            case SQRT:
                return "sqrt(" + f1.print() + ")";
            case ABSOLUTE:
                return "|" + f1.print() + "|";
            default:
                throw new UnsupportedOperationException("Invalid operation!");
        }
    }
}
