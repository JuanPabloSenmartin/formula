package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.composite.*;

public class PrintVisitor implements Visitor{
    String result;
    @Override
    public void visitOperation(Operation operation) {
        Function f1 = operation.getFunction1();
        Function f2 = operation.getFunction2();
        String s1 = aux(f1);
        String s2 = aux(f2);
        result = Printer.print(s1,s2, operation.getOperator(),f1.getOperator(), f2.getOperator(), f1.isVariable(), f2.isVariable());
    }
    private String aux(Function function){
        function.accept(this);
        return result;
    }
    @Override
    public void visitVariable(Variable variable) {
        if (variable.isNumber()){
            result = String.valueOf((int)variable.getValue());
        }
        else{
            result = variable.getName();
        }
    }

    @Override
    public Object getResult() {
        return result;
    }
}
