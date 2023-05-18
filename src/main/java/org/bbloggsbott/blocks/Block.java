package org.bbloggsbott.blocks;

import java.lang.reflect.InvocationTargetException;

public abstract class Block {

    public abstract Object execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

}
