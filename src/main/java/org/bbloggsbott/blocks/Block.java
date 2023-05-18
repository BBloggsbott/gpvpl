package org.bbloggsbott.blocks;

import lombok.Getter;
import org.bbloggsbott.environment.Context;

import java.lang.reflect.InvocationTargetException;

public abstract class Block {

    @Getter
    private Context context;

    public Block(Context context){
        this.context = new Context();
        this.context.setVariables(context.getVariables());
    }

    public abstract Object execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

}
