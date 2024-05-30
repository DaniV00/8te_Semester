package main.java.exercise3;
import java.util.Optional;

 public class ValueNode implements ExpressionNode {
  int val;

  public ValueNode(int val) {
   this.val = val;
  }

  @Override
  public Optional<Integer> evaluate() {
   return Optional.of(val);
  }

  @Override
  public String prettyprint(){
   return "" + val;
  }



 }
