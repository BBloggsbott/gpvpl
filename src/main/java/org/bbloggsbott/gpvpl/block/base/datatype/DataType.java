package org.bbloggsbott.gpvpl.block.base.datatype;

import lombok.Getter;
import lombok.ToString;
import org.bbloggsbott.gpvpl.block.Block;

import java.lang.reflect.InvocationTargetException;

@ToString
public abstract class DataType<T> extends Block {

    @Getter
    private final T value;

    DataType(T value){
        super();
        this.value = value;
    }

    public abstract DataType<T> add(Block obj) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException;

    @Override
    public DataType<T> execute() {
        return this;
    }

}
