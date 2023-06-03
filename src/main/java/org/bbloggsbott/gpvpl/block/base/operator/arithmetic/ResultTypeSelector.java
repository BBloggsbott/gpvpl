package org.bbloggsbott.gpvpl.block.base.operator.arithmetic;

import org.bbloggsbott.gpvpl.block.base.datatype.DataTypeConstants;

import java.util.HashMap;

public class ResultTypeSelector {

    /*
    * Stores rules in the following format
    * <dataype_1>:
    *   <datatype_2>:
    *       <return_type>
    *   <datatype_3>:
    *       <return_type>
    * <dataype_1>:
    *   <datatype_2>:
    *       <return_type>
    * Rules need to be set in a way that the return type can process the two types
    */
    private static HashMap<String, HashMap<String, String>> rules = new HashMap<>();
    private static HashMap<String, String> intRules = new HashMap<>();
    private static HashMap<String, String> strRules = new HashMap<>();
    private static HashMap<String, String> boolRules = new HashMap<>();
    private static HashMap<String, String> floatRules = new HashMap<>();

    // Define Int Rules
    static {
        intRules.put(DataTypeConstants.INT, DataTypeConstants.INT);
        intRules.put(DataTypeConstants.FLOAT, DataTypeConstants.FLOAT);
        rules.put(DataTypeConstants.INT, intRules);
    }

    // Define Str Rules
    static {
        strRules.put(DataTypeConstants.INT, DataTypeConstants.STR);
        strRules.put(DataTypeConstants.STR, DataTypeConstants.STR);
        strRules.put(DataTypeConstants.BOOL, DataTypeConstants.STR);
        strRules.put(DataTypeConstants.FLOAT, DataTypeConstants.FLOAT);
        rules.put(DataTypeConstants.STR, strRules);
    }

    static {
        rules.put(DataTypeConstants.BOOL, boolRules);
    }

    static {
        floatRules.put(DataTypeConstants.INT, DataTypeConstants.FLOAT);
        floatRules.put(DataTypeConstants.FLOAT, DataTypeConstants.FLOAT);
        rules.put(DataTypeConstants.FLOAT, floatRules);
    }

    public static String getResultType(String type1, String type2){
        return rules.get(type1).get(type2);
    }

}
