package org.bbloggsbott.gpvpl.block.base.operator;

import org.bbloggsbott.gpvpl.block.Block;
import org.bbloggsbott.gpvpl.block.base.variable.Variable;
import org.bbloggsbott.gpvpl.environment.Context;

import java.lang.reflect.InvocationTargetException;

public class Assignment extends Block{

    private String variableName;
    private Block value;
    private Context context;

    public Assignment(String variableName, Block value, Context context) {
        this.variableName = variableName;
        this.value = value;
        this.context = context;
    }

    @Override
    public Block execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Block executedBlock = this.value.execute();
        Variable variable = new Variable(executedBlock.getClass().getSimpleName(), executedBlock);
        this.context.addVariable(this.variableName, variable);
        return executedBlock;
    }
}
