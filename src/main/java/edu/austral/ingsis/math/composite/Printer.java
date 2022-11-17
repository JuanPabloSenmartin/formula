package edu.austral.ingsis.math.composite;

import java.util.List;

public class Printer {
    public static String print(Function f1, Function f2, Operator operator){
        String str = "";
        String f1Str = f1.print();
        String f2Str = f2.print();
        if ((!f1.isVariable()) && f1.getOperator() != Operator.ABSOLUTE && f1.getOperator() != Operator.SQRT){
            f1Str = "(" + f1Str + ")";
        }
        if ((!f2.isVariable()) && f2.getOperator() != Operator.ABSOLUTE && f2.getOperator() != Operator.SQRT){
            f2Str = "(" + f2Str + ")";
        }

        switch (operator){
            case SUM:
                str += f1Str + " + " + f2Str;
                break;
            case SUBTRACT:
                str += f1Str + " - " + f2Str;
                break;
            case MULTIPLY:
                str += f1Str + " * " + f2Str;
                break;
            case DIVIDE:
                str += f1Str + " / " + f2Str;
                break;
            case EXPONENT:
                str += f1Str + " ^ " + f2Str;
                break;
            case SQRT:
                str += "sqrt(" + f1Str + ")";
                break;
            case ABSOLUTE:
                str += "|" + f1Str + "|";
                break;
            default:
                throw new UnsupportedOperationException("Invalid operation!");
        }
        return str;
    }
}
