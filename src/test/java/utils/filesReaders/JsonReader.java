package utils.filesReaders;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class JsonReader {
    public static String getJsonValue(String fileName, String key) {
        String value = null;
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("./src/test/java/utils/testData/" + fileName));
            JSONObject jsonObject = (JSONObject) obj;
            value = (String) jsonObject.get(key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }
}
