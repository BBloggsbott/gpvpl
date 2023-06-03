package org.bbloggsbott.gpvpl.utils;

import lombok.Getter;
import org.bbloggsbott.gpvpl.block.Block;
import org.bbloggsbott.gpvpl.block.base.datatype.Bool;
import org.bbloggsbott.gpvpl.block.base.datatype.Floating;
import org.bbloggsbott.gpvpl.block.base.datatype.Int;
import org.bbloggsbott.gpvpl.block.base.datatype.Str;
import org.bbloggsbott.gpvpl.block.base.operator.Assignment;
import org.bbloggsbott.gpvpl.block.base.operator.arithmetic.Plus;
import org.bbloggsbott.gpvpl.block.base.variable.DefinedVariable;
import org.bbloggsbott.gpvpl.environment.Context;
import org.bbloggsbott.gpvpl.exception.InvalidTypeException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BlockBuilder {

    private final String VALUE = "value";
    private final String INT = "Int";
    private final String FLOAT = "Float";
    private final String BOOL = "Bool";
    private final String STR = "Str";
    private final String PLUS = "Plus";
    private final String ASSIGNMENT = "Assignment";
    private final String DEFINED_VARIABLE = "DefinedVariable";

    @Getter
    private Context context;

    public BlockBuilder(Context context){
        this.context = context;
    }

    private Int buildInt(JSONObject jsonObject){
        return new Int(jsonObject.getInt(VALUE));
    }

    private Str buildStr(JSONObject jsonObject){
        return new Str(jsonObject.getString(VALUE));
    }

    private Bool buildBool(JSONObject jsonObject){
        return new Bool(jsonObject.getBoolean(VALUE));
    }

    private Floating buildFloat(JSONObject jsonObject){
        return new Floating(jsonObject.getFloat(VALUE));
    }

    private Plus buildPlus(JSONObject jsonObject, Context context) throws InvalidTypeException {
        Block left = buildBlock(jsonObject.getJSONObject("left"), context);
        Block right = buildBlock(jsonObject.getJSONObject("right"), context);
        return new Plus(left, right);
    }

    private Assignment buildAssignment(JSONObject jsonObject, Context context) throws InvalidTypeException {
        String name = jsonObject.getString("name");
        Block value = buildBlock(jsonObject.getJSONObject(VALUE), context);
        return new Assignment(name, value, context);
    }


    private DefinedVariable buildDefinedVariable(JSONObject jsonObject, Context context){
        String name = jsonObject.getString("name");
        return new DefinedVariable(name, context);
    }


    private Block buildBlock(JSONObject jsonObject, Context context) throws InvalidTypeException {
        Block block;
        switch (jsonObject.getString("type")){
            case INT:
                block = buildInt(jsonObject);
                break;
            case STR:
                block = buildStr(jsonObject);
                break;
            case BOOL:
                block = buildBool(jsonObject);
                break;
            case FLOAT:
                block = buildFloat(jsonObject);
                break;
            case PLUS:
                block =  buildPlus(jsonObject, context);
                break;
            case ASSIGNMENT:
                block = buildAssignment(jsonObject, context);
                break;
            case DEFINED_VARIABLE:
                block = buildDefinedVariable(jsonObject, context);
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
            blocks.add(buildBlock((JSONObject) jsonObject, context));
        }
        return blocks;
    }
}
