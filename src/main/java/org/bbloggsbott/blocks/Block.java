package org.bbloggsbott.blocks;

import org.bbloggsbott.environment.Context;
import org.json.JSONObject;

public class Block {

    private Context context;

    public Block(Context context){
        this.context = new Context();
        this.context.setVariables(context.getVariables());
    }

    public void loadJson(JSONObject jsonObject){

    }

}
