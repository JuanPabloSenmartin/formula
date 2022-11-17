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
    public static String print(String s1, String s2, Operator op, Operator firstOperator, Operator secondOperator, boolean isFirstVariable, boolean isSecondVariable){
        String str = "";
        if ((!isFirstVariable) && firstOperator != Operator.ABSOLUTE && firstOperator != Operator.SQRT){
            s1 = "(" + s1 + ")";
        }
        if ((!isSecondVariable) && secondOperator != Operator.ABSOLUTE && secondOperator != Operator.SQRT){
            s2 = "(" + s2 + ")";
        }
        switch (op){
            case SUM:
                str += s1 + " + " + s2;
                break;
            case SUBTRACT:
                str += s1 + " - " + s2;
                break;
            case MULTIPLY:
                str += s1 + " * " + s2;
                break;
            case DIVIDE:
                str += s1 + " / " + s2;
                break;
            case EXPONENT:
                str += s1 + " ^ " + s2;
                break;
            case SQRT:
                str += "sqrt(" + s1 + ")";
                break;
            case ABSOLUTE:
                str += "|" + s1 + "|";
                break;
            default:
                throw new UnsupportedOperationException("Invalid operation!");
        }
        return str;
    }
}
