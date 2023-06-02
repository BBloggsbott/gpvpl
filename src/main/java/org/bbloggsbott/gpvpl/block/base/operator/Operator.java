package org.bbloggsbott.gpvpl.block.base.operator;

import lombok.Getter;
import lombok.ToString;
import org.bbloggsbott.gpvpl.block.Block;
import org.bbloggsbott.gpvpl.block.base.operator.arithmetic.ResultTypeSelector;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@ToString
public abstract class Operator extends Block {

    @Getter
    private final Block left;
    @Getter
    private final Block right;

    protected Operator(Block left, Block right) {
        super();
        this.left = left;
        this.right = right;
    }

    protected Block callOperation(Block block1, Block block2, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = block1.getClass().getMethod(methodName, Block.class);
        return block1.getClass().cast(method.invoke(block1, block2));
    }

    protected Block performArithmeticOperation(String methodName) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Block executedLeft = this.getLeft().execute();
        Block executedRight = this.getRight().execute();
        String leftType = executedLeft.getClass().getSimpleName();
        String rightType = executedRight.getClass().getSimpleName();
        String return_type = ResultTypeSelector.getResultType(leftType, rightType);
        if (leftType.equals(return_type)){
            return this.callOperation(executedLeft, executedRight, methodName);
        } else {
            return this.callOperation(executedRight, executedLeft, methodName);
        }
    }
}
