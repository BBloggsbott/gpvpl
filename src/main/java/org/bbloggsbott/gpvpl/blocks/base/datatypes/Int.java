package org.bbloggsbott.gpvpl.blocks.base.datatypes;

public class Int extends DataType<Integer, Int>{

    public Int(Integer value){
        super(value);
    }



    @Override
    public Int add(Int obj){
        return new Int(this.getValue() + obj.getValue());
    }

}
