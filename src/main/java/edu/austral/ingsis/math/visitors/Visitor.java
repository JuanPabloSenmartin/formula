package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.composite.Operation;
import edu.austral.ingsis.math.composite.Variable;

public interface Visitor {
    void visitOperation(Operation operation);
    void visitVariable(Variable variable);

    Object getResult();
}
