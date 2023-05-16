package org.bbloggsbott.blocks.base.datatypes;

import lombok.Getter;
import lombok.ToString;
import org.bbloggsbott.blocks.Block;
import org.bbloggsbott.environment.Context;
import org.bbloggsbott.exceptions.NotImplementedException;

@ToString
public class DataType<T> extends Block {

    @Getter
    private final T value;

    DataType(Context context, T value){
        super(context);
        this.value = value;
    }

    public DataType<T> add(DataType<?> obj) throws NotImplementedException{
        throw new NotImplementedException("add not implemented for DataType");
    }

}
