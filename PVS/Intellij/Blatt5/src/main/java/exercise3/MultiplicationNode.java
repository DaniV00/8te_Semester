package main.java.exercise3;

import java.util.Optional;

public class MultiplicationNode extends ValueNode {

    ValueNode left;
    ValueNode right;


    public MultiplicationNode(ValueNode left, ValueNode right) {
        super(left.val);
        this.left = left;
        this.right = right;
    }

    @Override
    public Optional<Integer> evaluate() {
        int leftVal = left.evaluate().get();
        int rightVal = right.evaluate().get();

        return Optional.of(leftVal * rightVal);
    }

    @Override
    public String prettyprint(){

        return left.prettyprint() + " * " + right.prettyprint();
    }






}
