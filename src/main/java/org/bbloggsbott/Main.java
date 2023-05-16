package org.bbloggsbott;

import org.bbloggsbott.blocks.base.datatypes.Int;
import org.bbloggsbott.blocks.base.operands.Plus;
import org.bbloggsbott.environment.Context;
import org.bbloggsbott.exceptions.NotImplementedException;

public class Main {
    public static void main(String[] args) throws NotImplementedException {
        Context baseContext = new Context();
        Int int1 = new Int(baseContext, 2);
        Int int2 = new Int(baseContext, 5);
        Plus<Int, Int> plus = new Plus<>(baseContext, int1, int2);
        Int result = plus.execute();
        System.out.println(result);
    }
}