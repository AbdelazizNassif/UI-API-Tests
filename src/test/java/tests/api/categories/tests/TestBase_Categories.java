package tests.api.categories.tests;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import tests.api.APIBaseTest;
import tests.api.categories.bodies.CategoryRequestBody;
import tests.api.categories.requests.CategoriesRequests;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class TestBase_Categories extends APIBaseTest {

    CategoryRequestBody categoryPostRequestBody = null ;
    CategoryRequestBody categoryUpdateBody = null;
    CategoriesRequests categoriesRequests = null;
    RequestSpecification requestSpecification = null ;

    private void loadCategoriesEndToEndTestData()
    {
        Random rand = new Random();
        String id = "dummyId " +  ( rand.nextInt(1000) * rand.nextInt(1000) ) ;
        String name = "dummyName"  + ( rand.nextInt(1000) * rand.nextInt(1000) ) ;
        categoryPostRequestBody= new CategoryRequestBody( id, name) ;
        String nameAfterUpdate = name + " updated" ;
        categoryUpdateBody = new CategoryRequestBody( id, nameAfterUpdate) ;
        // set up common test data
        categoriesRequests =  new CategoriesRequests();
        requestSpecification = given()
                .baseUri(apiBaseUrl)
                .basePath(categoriesRequests.CATEGORY_BASE_PATH);
    }

    @BeforeClass
    public void setupApiConfigAndTestData ()
    {
        loadCategoriesEndToEndTestData() ;
    }
}
