package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.visitors.Visitor;

import java.util.List;

public interface Function {
    double calculate();
    String print();
    boolean isVariable();
    Operator getOperator();
    List<String> getVariableList(List<String> list);
    void accept(Visitor visitor);
}
