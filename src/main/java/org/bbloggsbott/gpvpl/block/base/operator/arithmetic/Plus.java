package org.bbloggsbott.gpvpl.block.base.operator.arithmetic;

import org.bbloggsbott.gpvpl.block.Block;
import org.bbloggsbott.gpvpl.block.base.operator.Operator;

import java.lang.reflect.InvocationTargetException;

public class Plus extends Operator {

    private final String ADD = "add";

    public Plus(Block left, Block right) {
        super(left, right);
    }


    @Override
    public Block execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return this.performArithmeticOperation(ADD);
    }

}
