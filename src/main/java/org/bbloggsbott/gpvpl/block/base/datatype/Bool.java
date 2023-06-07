package org.bbloggsbott.gpvpl.block.base.datatype;

import lombok.Getter;
import lombok.ToString;
import org.bbloggsbott.gpvpl.block.Block;

@ToString
public class Bool extends Block {

    @Getter
    private final Boolean value;

    public Bool(Boolean value){
        super();
        this.value = value;
    }


    @Override
    public Bool execute() {
        return this;
    }

}
