package org.bbloggsbott.gpvpl.blocks.base.operands;

import org.bbloggsbott.gpvpl.blocks.Block;
import org.bbloggsbott.gpvpl.exceptions.InvalidTypeException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Plus extends Operator {

    public Plus(Block left, Block right) throws InvalidTypeException {
        super(left, right);
    }

    @Override
    public Block execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method addMethod = this.getLeft().getClass().getMethod("add", this.getRight().getClass());
        return (Block) addMethod.invoke(this.getLeft(), this.getRight());
    }

}
