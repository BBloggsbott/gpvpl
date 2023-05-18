package org.bbloggsbott.gpvpl.blocks;

import lombok.Getter;
import org.bbloggsbott.gpvpl.environment.Context;

public abstract class ContextualBlock extends Block {

    @Getter
    private Context context;

    public ContextualBlock(Context context){
        super();
        this.context = new Context(context);
    }

}
