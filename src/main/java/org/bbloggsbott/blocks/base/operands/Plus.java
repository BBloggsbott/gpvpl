package org.bbloggsbott.blocks.base.operands;

import org.bbloggsbott.environment.Context;
import org.bbloggsbott.blocks.base.datatypes.DataType;
import org.bbloggsbott.exceptions.NotImplementedException;

public class Plus<T extends DataType<?>, T1 extends DataType<?>> extends Operator<T, T1> {

    public Plus(Context context, T left, T1 right){
        super(context, left, right);
    }


    @Override
    public T execute() throws NotImplementedException {
        return (T) this.getLeft().add(this.getRight());
    }

}
