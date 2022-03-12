package tests.api;

import org.testng.annotations.BeforeClass;

import static utils.filesReaders.PropertiesFileReader.loadPropertyValueByKey;

public class APIBaseTest {

    public String apiBaseUrl = null ;
    @BeforeClass
    public void setup ()
    {
        apiBaseUrl = loadPropertyValueByKey( "api_config.properties", "BASE_URL_API")  ;
    }
}
