package org.task3_1.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class FileReadUtils {

      public static Object getField(String fileName, String field) {
        var parser = new JSONParser();
        try(FileReader file = new FileReader(fileName)) {
            return ((JSONObject) parser.parse(file)).get(field);
        }
        catch (Exception e) {
            LogUtils.logError("Error parsing JSON file!", e);
            return new Object();
        }
    }
}
