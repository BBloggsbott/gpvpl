package org.bbloggsbott.gpvpl.block.base.datatype;

import org.bbloggsbott.gpvpl.block.Block;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Int extends DataType<Integer>{

    public Int(Integer value){
        super(value);
    }



    @Override
    public Int add(Block obj) throws NumberFormatException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method getValueMethod = obj.getClass().getMethod("getValue");
        // Throws NumberFormatException when String cannot be parsed
        Integer parsedInt = Integer.parseInt(getValueMethod.invoke(obj).toString());
        return new Int(this.getValue() + parsedInt);
    }

}
