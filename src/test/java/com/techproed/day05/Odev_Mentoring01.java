package com.techproed.day05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class Odev_Mentoring01 {
    @Test
            public void test01(){

        //        https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
        //        donen Response'in
        //        status code'unun 200,
        //        ve content type'inin Aplication.JSON,
        //        ve response body'sinde bulunan userId'nin 5,
        //        ve response body'sinde bulunan title'in "optio dolor molestias sit" oldugunu test edin.

        String url="https://jsonplaceholder.typicode.com/posts/44";
        Response response=given().accept("application/json").when().get(url);
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("userId",equalTo(5),
                      "title",equalTo("optio dolor molestias sit")  );

    }

}
