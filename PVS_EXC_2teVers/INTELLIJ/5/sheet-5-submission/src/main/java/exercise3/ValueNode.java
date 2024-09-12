package exercise3;

import java.util.Optional;

public class ValueNode implements ExpressionNode{
    int value;

    public ValueNode(int value) {

        this.value = value;
    }


    @Override
    public Optional<Integer> evaluate(){
        Optional<Integer> printnode = Optional.of(value);
        return printnode;
    }


}
