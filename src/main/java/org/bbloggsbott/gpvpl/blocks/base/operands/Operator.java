package org.bbloggsbott.gpvpl.blocks.base.operands;

import lombok.Getter;
import lombok.ToString;
import org.bbloggsbott.gpvpl.blocks.Block;

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
}
