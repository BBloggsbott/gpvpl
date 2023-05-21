package org.bbloggsbott.gpvpl.blocks.base.datatypes;

import org.bbloggsbott.gpvpl.blocks.Block;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Int extends DataType<Integer>{

    public Int(Integer value){
        super(value);
    }



    @Override
    public Int add(Block obj) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method getValueMethod = obj.getClass().getMethod("getValue");
        return new Int(this.getValue() + (Integer) getValueMethod.invoke(obj));
    }

}
