package org.bbloggsbott.gpvpl.block.base.operator;

import org.bbloggsbott.gpvpl.block.Block;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Plus extends Operator {

    public Plus(Block left, Block right) {
        super(left, right);
    }

    @Override
    public Block execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Block executedLeft = this.getLeft().execute();
        Block executedRight = this.getRight().execute();
        Method addMethod = executedLeft.getClass().getMethod("add", Block.class);
        return executedLeft.getClass().cast(addMethod.invoke(executedLeft, executedRight));
    }

}