package org.bbloggsbott.gpvpl.block;

import java.lang.reflect.InvocationTargetException;

public abstract class Block {

    public abstract Block execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

}
