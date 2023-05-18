package org.bbloggsbott.blocks.base.operands;

import lombok.Getter;
import lombok.ToString;
import org.bbloggsbott.blocks.Block;
import org.bbloggsbott.blocks.base.datatypes.DataType;
import org.bbloggsbott.exceptions.InvalidTypeException;

@ToString
public abstract class Operator extends Block {

    @Getter
    private final Block left;
    @Getter
    private final Block right;

    protected Operator(Block left, Block right) throws InvalidTypeException {
        super();
        if ( left instanceof DataType && right instanceof DataType ){
            this.left = left;
            this.right = right;
        } else {
            throw new InvalidTypeException("Operators can only work with DataTypes");
        }
    }
}
