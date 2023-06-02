package org.bbloggsbott.gpvpl.block.base.operator;

import lombok.Getter;
import lombok.ToString;
import org.bbloggsbott.gpvpl.block.Block;

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
