package exercise3;

import java.util.Optional;

public class MultiplicationNode implements ExpressionNode{
     ValueNode valnode;
     AdditionNote add;

    public MultiplicationNode (ValueNode valnode , AdditionNote add){
     this.valnode = valnode;
     this.add = add;
    }

    @Override
    public Optional<Integer> evaluate() {

        int sumval = add.evaluate().get();
        int mult = valnode.evaluate().get() * sumval;

        return Optional.of(mult);
    }



}
