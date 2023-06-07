package org.bbloggsbott.gpvpl.executor;

import org.bbloggsbott.gpvpl.block.Block;
import org.bbloggsbott.gpvpl.environment.Context;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Executor {

    private final List<Block> blocks;
    private Context baseContext;

    public Executor(Context baseContext, List<Block> blocks){
        this.baseContext = baseContext;
        this.blocks = blocks;
    }

    public void execute() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        for(Block block: blocks){
            Block returnedBlock = (Block) block.execute();
            System.out.println(returnedBlock);
        }
    }

}
