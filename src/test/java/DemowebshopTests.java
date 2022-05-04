import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class DemowebshopTests {
    @Test
    void addProductToCart() {
        given()
                .contentType("application/json; charset=utf-8")
                .body("{\n" +
                        "  \"addtocart_63.EnteredQuantity\": \"1\"\n" +
                        "}")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/63/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(false))
                .body("message", is('[This product requires the following' +
                        'product is added to the cart: TCP Instructor Led Training]'));
    }

    @Test
    void addToWishList() {
        given()
                .contentType("application/json; charset=utf-8")
                .body("product_attribute_28_7_10=25&product_attribute_28_1_11=29&addtocart_28.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/28/2)
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is('The product has been added to your <a href=\\"/wishlist\\">wishlist</a>'));
    }

    @Test
    void voteTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("pollAnswerId=2")
                .when()
                .post("http://demowebshop.tricentis.com/poll/vote")
                .then()
                .log().all()
                .statusCode(200)
                .body("error", is("Only registered users can vote."));
    }
}
