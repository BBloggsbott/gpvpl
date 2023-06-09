package org.bbloggsbott;

import org.bbloggsbott.gpvpl.block.Block;
import org.bbloggsbott.gpvpl.environment.Context;
import org.bbloggsbott.gpvpl.exception.InvalidTypeException;
import org.bbloggsbott.gpvpl.executor.Executor;
import org.bbloggsbott.gpvpl.utils.BlockBuilder;
import org.json.JSONArray;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvalidTypeException, InvocationTargetException, IOException {
        String jsonFileName = "examples/integer_add.json";
        Path path = Paths.get(jsonFileName);
        String jsonString = String.join("\n", Files.readAllLines(path));
        JSONArray jsonArray = new JSONArray(jsonString);
        Context baseContext = new Context();
        BlockBuilder blockBuilder = new BlockBuilder(baseContext);
        List<Block> blocks = blockBuilder.buildBlocks(jsonArray);

        Executor executor = new Executor(baseContext, blocks);
        executor.execute();

    }
}