package exercise3;

import java.util.Optional;

public class AdditionNote implements ExpressionNode{
     ValueNode valueL;
     ValueNode valueR;

    public AdditionNote(ValueNode valueL, ValueNode valueR) {
        this.valueL = valueL;
        this.valueR = valueR;
    }

    public Optional<Integer> evaluate(){

        int ValueL = valueL.value;
        int ValueR = valueR.value;
        int sum = ValueL + ValueR;

        Optional<Integer> printnode = Optional.of(sum);
        return printnode;

    }








}
