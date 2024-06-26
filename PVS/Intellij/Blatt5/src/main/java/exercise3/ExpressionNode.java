package main.java.exercise3;

import java.util.Optional;

public interface ExpressionNode {
   Optional<Integer> evaluate();
   String prettyprint();

}
