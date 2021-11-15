package com.techproed.day06;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Odev_Mentoring extends JsonPlaceHolderTestBase{
//		1) Create a class and name it as you wish :)
//		2) When
//		     I send a GET Request to https://jsonplaceholder.typicode.com/todos
//		   Then








    @Test
    public void test01(){
        spec01.pathParam("parametre3","todos");
        Response response =given().accept("application/json")
                .spec(spec01)
                .when()
                .get("/{parametre3}");
        JsonPath jsonPath =response.jsonPath();
response.prettyPrint();
//			 HTTP Status code should be "200"
// 			 And Content type should be in "JSON" format
      response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        //			 And there should be 200 "title"
      Assert.assertEquals(200,jsonPath.getList("title").size());
        //			 And "dignissimos quo nobis earum saepe" should be one of the "title"s
Assert.assertTrue(jsonPath.getList("title").contains("dignissimos quo nobis earum saepe"));
//			 And 111, 121, and 131 should be among the "id"s
        Assert.assertTrue(jsonPath.getList("id").contains(111)||
                                   jsonPath.getList("id").contains(121)||
                                   jsonPath.getList("id").contains(131));
        //			 And 4th title is "et porro tempora"
        Assert.assertEquals("et porro tempora",jsonPath.getString("title[3]"));
        //			 And last title is "ipsam aperiam voluptates qui"
        Assert.assertEquals("ipsam aperiam voluptates qui",jsonPath.getString("title[-1]"));

    }
}
