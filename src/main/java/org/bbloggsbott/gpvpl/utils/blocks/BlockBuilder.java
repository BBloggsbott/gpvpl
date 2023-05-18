package org.bbloggsbott.gpvpl.utils.blocks;

import lombok.Getter;
import org.bbloggsbott.gpvpl.blocks.Block;
import org.bbloggsbott.gpvpl.blocks.base.datatypes.Int;
import org.bbloggsbott.gpvpl.blocks.base.operands.Plus;
import org.bbloggsbott.gpvpl.environment.Context;
import org.bbloggsbott.gpvpl.exceptions.InvalidTypeException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BlockBuilder {

    private final String INT = "Int";
    private final String PLUS = "Plus";

    @Getter
    private Context context;

    public BlockBuilder(Context context){
        this.context = context;
    }

    private Int buildInt(JSONObject jsonObject){
        return new Int(jsonObject.getInt("value"));
    }

    private Plus buildPlus(JSONObject jsonObject) throws InvalidTypeException {
        Block left = buildBlock(jsonObject.getJSONObject("left"));
        Block right = buildBlock(jsonObject.getJSONObject("right"));
        return new Plus(left, right);
    }


    private Block buildBlock(JSONObject jsonObject) throws InvalidTypeException {
        Block block;
        switch (jsonObject.getString("type")){
            case PLUS:
                block =  buildPlus(jsonObject);
                break;
            case INT:
                block = buildInt(jsonObject);
                break;
            default:
                block = null;
                break;
        }
        return block;
    }

    public List<Block> buildBlocks(JSONArray jsonArray) throws InvalidTypeException {
        ArrayList<Block> blocks = new ArrayList<>();
        for(Object jsonObject: jsonArray){
            blocks.add(buildBlock((JSONObject) jsonObject));
        }
        return blocks;
    }
}
