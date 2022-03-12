package tests.api.categories.tests;

import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.api.categories.bodies.CategoryRequestBody;
import tests.api.categories.requests.CategoriesRequests;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class CategoriesEndToEndTests extends TestBase_Categories{


    @Test(priority = 1)
    public void createCategory ()
    {
        var response = categoriesRequests
                .postRequest_createCategory(requestSpecification, categoryPostRequestBody);
        // assertions on the response status code and body
        response
                .assertThat()
                .statusCode(201)
                .header("Content-Type", Matchers.equalTo("application/json; charset=utf-8"))
                .body("id" , Matchers.equalTo(categoryPostRequestBody.getId()))
                .body("name" , Matchers.equalTo(categoryPostRequestBody.getName()))
                .body("updatedAt" , Matchers.notNullValue())
                .body("createdAt" , Matchers.notNullValue())
                ;
        response.log().body();

    }
    @Test(dependsOnMethods = "createCategory")
    public void updateCategory ()
    {
        var response = categoriesRequests.patchRequest_updateCategory(requestSpecification,categoryUpdateBody);
        // assertions on the response status code and body
        response
                .assertThat()
                .statusCode(200)
                .header("Content-Type", Matchers.equalTo("application/json; charset=utf-8"))
                .body("id" , Matchers.equalTo(categoryUpdateBody.getId()))
                .body("name" , Matchers.equalTo(categoryUpdateBody.getName()))
                .body("updatedAt" , Matchers.notNullValue())
                .body("createdAt" , Matchers.notNullValue());
    }

    @Test(dependsOnMethods = {"createCategory" ,"updateCategory"})
    public void readCategory ()
    {
        var response = categoriesRequests.getRequest_readCategoryByID(requestSpecification,categoryPostRequestBody.getId());
        response
                .assertThat()
                .statusCode(200)
                .header("Content-Type", Matchers.equalTo("application/json; charset=utf-8"))
                .body("id" , Matchers.equalTo(categoryUpdateBody.getId()))
                .body("name" , Matchers.equalTo(categoryUpdateBody.getName()))
                .body("updatedAt" , Matchers.notNullValue())
                .body("createdAt" , Matchers.notNullValue())
                .body("subCategories.size()" , Matchers.equalTo(0))
                .body("categoryPath.size()" , Matchers.equalTo(0));
    }

    @Test(dependsOnMethods = {"createCategory" ,"updateCategory","readCategory"})
    public void deleteCategory ()
    {
        var response = categoriesRequests.deleteRequest_deleteCategory(requestSpecification,categoryPostRequestBody.getId());

        response
                .assertThat()
                .statusCode(200)
                .header("Content-Type", Matchers.equalTo("application/json; charset=utf-8"))
                .body("id" , Matchers.equalTo(categoryUpdateBody.getId()))
                .body("name" , Matchers.equalTo(categoryUpdateBody.getName()))
                .body("updatedAt" , Matchers.notNullValue())
                .body("createdAt" , Matchers.notNullValue());
    }
}
