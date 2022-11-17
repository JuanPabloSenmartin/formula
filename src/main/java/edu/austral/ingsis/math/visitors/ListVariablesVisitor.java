package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.composite.Operation;
import edu.austral.ingsis.math.composite.Variable;

import java.util.ArrayList;
import java.util.List;

public class ListVariablesVisitor implements Visitor{
    List<String> result = new ArrayList<>();
    @Override
    public void visitOperation(Operation operation) {
        operation.getFunction1().accept(this);
        operation.getFunction2().accept(this);
    }

    @Override
    public void visitVariable(Variable variable) {
        if (!variable.isNumber() && !result.contains(variable.getName())) result.add(variable.getName());
    }

    @Override
    public Object getResult() {
        return result;
    }
}
