package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Odev_Mentoring01 {

    @Test
    public void test(){
        // https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request gonderdigimizde donen Response'un,
        //        status code'unun 200,
        //        ve content type'inin application/json; charset=utf-8,
        //        ve Server isimli Header'in degerinin Cowboy,
        //        ve status Line'in HTTP/1.1 200 OK
        //        ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
        String url="https://restful-booker.herokuapp.com/booking/10";

    Response response= given().accept("application/json").get(url);
        response.prettyPrint();
        response.then().assertThat().statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK").
                header("Server","Cowboy");
        Assert.assertTrue(response.time()>5000);
    }

}
