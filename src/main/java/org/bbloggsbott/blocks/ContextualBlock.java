package org.bbloggsbott.blocks;

import lombok.Getter;
import org.bbloggsbott.environment.Context;

public abstract class ContextualBlock extends Block {

    @Getter
    private Context context;

    public ContextualBlock(Context context){
        super();
        this.context = new Context(context);
    }

}
