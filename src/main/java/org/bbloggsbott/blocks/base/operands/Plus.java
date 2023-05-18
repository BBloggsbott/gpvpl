package org.bbloggsbott.blocks.base.operands;

import org.bbloggsbott.environment.Context;
import org.bbloggsbott.exceptions.InvalidTypeException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Plus<T, T1> extends Operator<T, T1> {

    public Plus(Context context, T left, T1 right) throws InvalidTypeException {
        super(context, left, right);
    }


    @Override
    public T execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method addMethod = this.getLeft().getClass().getMethod("add", this.getRight().getClass());
        return (T) addMethod.invoke(this.getLeft(), this.getRight());
    }

}
