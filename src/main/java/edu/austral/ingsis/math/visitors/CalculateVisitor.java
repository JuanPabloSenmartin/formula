package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.composite.Function;
import edu.austral.ingsis.math.composite.Operation;
import edu.austral.ingsis.math.composite.Resolver;
import edu.austral.ingsis.math.composite.Variable;

public class CalculateVisitor implements Visitor{
    Double result;
    @Override
    public void visitOperation(Operation operation) {
        double r1 = aux(operation.getFunction1());
        double r2 = aux(operation.getFunction2());
        result = Resolver.resolve(r1, r2, operation.getOperator());
    }
    private Double aux(Function function){
        function.accept(this);
        return result;
    }

    @Override
    public void visitVariable(Variable variable) {
        result = variable.calculate();
    }

    @Override
    public Object getResult() {
        return result;
    }
}
