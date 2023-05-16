package org.bbloggsbott.exceptions;

import lombok.ToString;

public class NotImplementedException extends Exception {

    private String msg;

    public NotImplementedException(String msg){
        this.msg = msg;
    }

    @Override
    public String toString(){
        return "NotImplementedException - " + msg;
    }

}
