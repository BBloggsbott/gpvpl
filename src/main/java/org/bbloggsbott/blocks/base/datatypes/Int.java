package org.bbloggsbott.blocks.base.datatypes;

import org.bbloggsbott.environment.Context;

import java.lang.Integer;

public class Int extends DataType<Integer>{

    public Int(Context context, Integer value){
        super(context, value);
    }

    public Int add(Int obj){
        return new Int(this.getContext(), this.getValue() + obj.getValue());
    }

}
