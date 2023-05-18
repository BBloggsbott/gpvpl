package org.bbloggsbott.gpvpl.exceptions;

public class InvalidTypeException extends Exception {

    private final String msg;

    public InvalidTypeException(String msg){
        this.msg = msg;
    }

    @Override
    public String toString(){
        return "InvalidTypeException - " + msg;
    }
}
