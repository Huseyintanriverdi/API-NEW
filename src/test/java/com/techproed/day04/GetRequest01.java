package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {
    //https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde donecek cevap(response) icin
    //HTTP status kodunun 200
    //Content Type'in Json
    //Ve Status Line'in HTTP/1.1 200 OK
    //Oldugunu test edin
    @Test
            public void test01() {
        //1- api testi yaparken ilk olarak url(endpoint) belirlenmeli
        String url = "https://restful-booker.herokuapp.com/booking/3";
        //2- beklenen sonuc olusturulur

        //3- request gonder
      Response response = given().accept("application/json").when().get(url);

      //4- actual resulr olustur


        response.prettyPrint();
        //5-dogrulama yap
        System.out.println("status code : "+response.getStatusCode());
        System.out.println("content type : "+response.getContentType());
        System.out.println("status line : "+response.getStatusLine());
        System.out.println(response.getHeaders());

//        Assert.assertEquals(200,response.getStatusCode());
//        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
//        Assert.assertEquals("application/json; charset=utf-8",response.getContentType());
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");
    }
}
