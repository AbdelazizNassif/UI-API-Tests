package utils.filesReaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReader {

    protected static String baseUrl = null;
    protected static String stdUsername = null;
    protected static String stdPassword = null;
    protected static String apiBaseUrl = null;

    protected static void loadUIStaticConfigs(String fileName)
    {
        try (InputStream inputConfigFile = new FileInputStream("./src/test/java/utils/" + fileName)) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(inputConfigFile);
            baseUrl = prop.getProperty("BASE_URL");
            stdUsername = prop.getProperty("STD_USER_NAME");
            stdPassword = prop.getProperty("STD_PASSWORD");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    public static String loadPropertyValueByKey(String fileName, String key)
    {
        String value = null;
        try (InputStream inputConfigFile = new FileInputStream("./src/test/java/utils/" + fileName)) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(inputConfigFile);
            value = prop.getProperty(key);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return value ;
    }
    protected static void loadAPIStaticConfigs()
    {
        try (InputStream inputConfigFile = new FileInputStream("./src/test/java/utils/api_config.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(inputConfigFile);
            apiBaseUrl = prop.getProperty("BASE_URL_API");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
