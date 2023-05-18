package org.bbloggsbott.gpvpl.blocks.base.datatypes;

import lombok.Getter;
import lombok.ToString;
import org.bbloggsbott.gpvpl.blocks.Block;

import java.lang.reflect.InvocationTargetException;

@ToString
public abstract class DataType<T, ChildName> extends Block {

    @Getter
    private final T value;

    DataType(T value){
        super();
        this.value = value;
    }

    public abstract DataType<T, ?> add(Block obj) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException;

    @Override
    public DataType<T, ChildName> execute() {
        return this;
    }

}
