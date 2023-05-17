package org.bbloggsbott.blocks.base.operands;

import lombok.Getter;
import lombok.ToString;
import org.bbloggsbott.blocks.Block;
import org.bbloggsbott.blocks.base.datatypes.DataType;
import org.bbloggsbott.environment.Context;
import org.bbloggsbott.exceptions.InvalidTypeException;

@ToString
public abstract class Operator<T, T1> extends Block {

    @Getter
    private final T left;
    @Getter
    private final T1 right;

    protected Operator(Context context, T left, T1 right) throws InvalidTypeException {
        super(context);
        if ( left instanceof DataType && right instanceof DataType ){
            this.left = left;
            this.right = right;
        } else {
            throw new InvalidTypeException("Operators can only work with DataTypes");
        }
    }
}
