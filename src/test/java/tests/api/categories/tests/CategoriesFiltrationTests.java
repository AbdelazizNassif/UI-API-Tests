package tests.api.categories.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;


public class CategoriesFiltrationTests extends TestBase_Categories{


    @Test(priority = 1)
    public void getAllCategories() {
        var response = categoriesRequests.getRequest_getAllCategories(requestSpecification);

        response
                .assertThat()
                .statusCode(200)
                .header("Content-Type", Matchers.equalTo("application/json; charset=utf-8"))
                .body("total", Matchers.greaterThanOrEqualTo(0))
                .body("limit", Matchers.equalTo(10))
                .body("skip", Matchers.equalTo(0))
                .body("data.size()", Matchers.greaterThanOrEqualTo(0))
                ;
    }

    @Test(priority = 2)
    public void getLimitedCategories() {
        var response = categoriesRequests.getRequest_getCategoriesByLimit(requestSpecification,20);

        response
                .assertThat()
                .statusCode(200)
                .header("Content-Type", Matchers.equalTo("application/json; charset=utf-8"))
                .body("total", Matchers.greaterThanOrEqualTo(0))
                .body("limit", Matchers.equalTo(20))
                .body("data.size()", Matchers.greaterThanOrEqualTo(0))
                .body("data.id", Matchers.everyItem(Matchers.notNullValue()))
                .body("data.id.size()", Matchers.equalTo(20))
                .body("data.name", Matchers.everyItem(Matchers.notNullValue()))
                .body("data.name.size()", Matchers.equalTo(20))
                .body("data.createdAt", Matchers.everyItem(Matchers.notNullValue()))
                .body("data.createdAt.size()", Matchers.equalTo(20))
                .body("data.updatedAt", Matchers.everyItem(Matchers.notNullValue()))
                .body("data.updatedAt.size()", Matchers.equalTo(20));
    }

}
