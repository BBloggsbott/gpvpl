package org.bbloggsbott.environment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bbloggsbott.blocks.ContextualBlock;

import java.util.HashMap;

@ToString
public class Context {

    @Getter @Setter
    private HashMap<String, ContextualBlock> variables;
    private final Context prevContext;

    public Context(){
        this.prevContext = null;
        this.variables = new HashMap<>();
    }
    
    public Context(Context prevContext){
        this.prevContext = prevContext;
        this.variables = new HashMap<>();
    }

    public void addVariable(String name, ContextualBlock value){
        this.variables.put(name, value);
    }

    public void addVariables(HashMap<String, ContextualBlock> variables){
        this.variables.putAll(variables);
    }

    public ContextualBlock getVariable(String name){
        if (this.variables.containsKey(name)){
            return this.variables.get(name);
        } else if (this.prevContext != null) {
            return this.prevContext.getVariable(name);
        } else {
            return null;
        }
    }

}
