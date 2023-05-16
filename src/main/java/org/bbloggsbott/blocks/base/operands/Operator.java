package org.bbloggsbott.blocks.base.operands;

import lombok.Getter;
import lombok.ToString;
import org.bbloggsbott.blocks.Block;
import org.bbloggsbott.blocks.base.datatypes.DataType;
import org.bbloggsbott.environment.Context;

@ToString
public class Operator<T extends DataType<?>, T1 extends DataType<?>> extends Block {

    @Getter
    private final T left;
    @Getter
    private final T1 right;

    protected Operator(Context context, T left, T1 right) {
        super(context);
        this.left = left;
        this.right = right;
    }
}
