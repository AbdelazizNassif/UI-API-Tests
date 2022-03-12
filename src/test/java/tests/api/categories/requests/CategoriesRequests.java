package tests.api.categories.requests;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import tests.api.categories.bodies.CategoryRequestBody;

import static io.restassured.RestAssured.given;

public class CategoriesRequests {
    public final String CATEGORY_BASE_PATH = "categories/";

    public ValidatableResponse postRequest_createCategory(RequestSpecification spec, CategoryRequestBody categoryPostRequestBody) {

        var response = given().spec(spec)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(categoryPostRequestBody)
                .when().post().then();
        return response;
    }
    public ValidatableResponse patchRequest_updateCategory (RequestSpecification spec,CategoryRequestBody categoryPatchRequestBody)
    {
//        String updateCategoryEndPoint = BASE_URI + CATEGORY_BASE_PATH + ;

        var response = given().spec(spec)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(categoryPatchRequestBody)
                .when().patch(categoryPatchRequestBody.getId()).then();
        return response ;
    }

    public ValidatableResponse getRequest_readCategoryByID (RequestSpecification spec, String categoryID)
    {
//        String readCategoryEndPoint = BASE_URI + CATEGORY_BASE_PATH + categoryID ;
        var response = given().spec(spec)
                .header("Accept", "application/json")
                .when().get(categoryID).then();
        return response;
    }

    public ValidatableResponse deleteRequest_deleteCategory (RequestSpecification spec,String categoryID)
    {
//        String deleteCategoryEndPoint = BASE_URI + CATEGORY_BASE_PATH + categoryID ;

        var response = given().spec(spec)
                .header("Accept", "application/json")
                .when().delete(categoryID).then();
        return response;
    }

    public ValidatableResponse getRequest_getAllCategories(RequestSpecification spec) {
//        String allCategoriesEndPoint = BASE_URI + CATEGORY_BASE_PATH;

        var response = given().spec(spec)
                .header("Accept", "application/json").log().all()
                .when().get().then();
        return  response;
    }

    public ValidatableResponse getRequest_getCategoriesByLimit(RequestSpecification spec,int limit) {
//        String allCategoriesEndPoint = BASE_URI + CATEGORY_BASE_PATH;

        var response = given().spec(spec)
                .header("Accept", "application/json")
                .queryParam("$limit", limit)
                .when().get().then();
        return  response;
    }
}
