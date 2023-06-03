package org.bbloggsbott.gpvpl.block.base.datatype;

import org.bbloggsbott.gpvpl.block.Block;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Floating extends DataType<Float>{

    public Floating(Float value) {
        super(value);
    }

    @Override
    public DataType<Float> add(Block obj) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method getValueMethod = obj.getClass().getMethod("getValue");
        // Throws NumberFormatException when String cannot be parsed
        Float parsedFloat = Float.parseFloat(getValueMethod.invoke(obj).toString());
        return new Floating(this.getValue() + parsedFloat);
    }
}
