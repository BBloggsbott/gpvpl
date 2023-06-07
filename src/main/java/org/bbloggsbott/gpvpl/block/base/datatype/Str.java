package org.bbloggsbott.gpvpl.block.base.datatype;

import org.bbloggsbott.gpvpl.block.Block;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Str extends DataType<String>{

    public Str(String value){
        super(value);
    }

    @Override
    public DataType<String> add(Block obj) throws InvocationTargetException, IllegalAccessException {
        try{
            Method getValueMethod = obj.getClass().getMethod("getValue");
            return new Str(this.getValue() + getValueMethod.invoke(obj).toString());
        } catch (NoSuchMethodException noSuchMethodException){
            return new Str(this.getValue() + obj.toString());
        }

    }
}
