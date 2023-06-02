package org.bbloggsbott.gpvpl.block.base.variable;

import lombok.Getter;
import org.bbloggsbott.gpvpl.block.Block;
import org.bbloggsbott.gpvpl.environment.Context;

import java.lang.reflect.InvocationTargetException;

public class DefinedVariable extends Block {

    @Getter
    private String name;

    @Getter
    private Context context;

    public DefinedVariable(String name, Context context){
        this.name = name;
        this.context = context;
    }

    @Override
    public Block execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Variable variable = this.context.getVariable(this.name);
        return variable.getValue();
    }
}
