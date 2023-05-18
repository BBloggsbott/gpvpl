package org.bbloggsbott;

import org.bbloggsbott.blocks.base.datatypes.Int;
import org.bbloggsbott.blocks.base.operands.Plus;
import org.bbloggsbott.environment.Context;
import org.bbloggsbott.exceptions.InvalidTypeException;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvalidTypeException, InvocationTargetException {
        Context baseContext = new Context();
        Int int1 = new Int(baseContext, 13);
        Int int2 = new Int(baseContext, 5);
        Plus<Int, Int> plus = new Plus<>(baseContext, int1, int2);
        Int result = plus.execute();
        System.out.println(result);
    }
}