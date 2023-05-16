package org.bbloggsbott.blocks;

import lombok.Getter;
import org.bbloggsbott.environment.Context;
import org.bbloggsbott.exceptions.NotImplementedException;
import org.json.JSONObject;

public class Block {

    @Getter
    private Context context;

    public Block(Context context){
        this.context = new Context();
        this.context.setVariables(context.getVariables());
    }

    public void loadJson(JSONObject jsonObject) throws NotImplementedException{
        throw new NotImplementedException("loadJson is not implemented.");
    }

    public Object execute() throws NotImplementedException{
        throw new NotImplementedException("execution is not implemented.");
    }

}
