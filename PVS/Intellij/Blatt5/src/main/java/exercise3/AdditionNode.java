package main.java.exercise3;

import java.util.Optional;

public class AdditionNode extends ValueNode {

    ValueNode node1;
    ValueNode node2;

    public AdditionNode(ValueNode node1, ValueNode node2) {
        super(node1.val);
        this.node1 = node1;
        this.node2 = node2;

    }

    @Override
    public Optional<Integer> evaluate() {
        int nodesum = node1.evaluate().get() + node2.evaluate().get();

        return Optional.of(nodesum);
    }

    @Override
    public String prettyprint(){

        return "" + node1.prettyprint() + " + " +  node2.prettyprint();
    }





}
