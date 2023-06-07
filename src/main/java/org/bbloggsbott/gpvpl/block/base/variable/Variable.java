package org.bbloggsbott.gpvpl.block.base.variable;

import lombok.Getter;
import org.bbloggsbott.gpvpl.block.Block;

public class Variable extends Block {

    @Getter
    private String dataType;

    @Getter
    private Block value;

    public Variable(String dataType, Block data){
        this.dataType = dataType;
        this.value = data;
    }

    @Override
    public Block execute() {
        return value;
    }
}
