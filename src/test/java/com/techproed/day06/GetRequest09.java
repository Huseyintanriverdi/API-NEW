package com.techproed.day06;

import com.techproed.testBase.DummyTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest09 extends DummyTestBase {
    @Test
    public void test01(){
        //http://dummy.restapiexample.com/api/v1/employees
        //url ine bir istek gönderildiğinde,

        //gelen body de,





        spec03.pathParam("parametre1","employees");
        Response response=given().accept("application/json")
                .spec(spec03)
                .when()
                .get("/{parametre1}");
        JsonPath jsonPath=response.jsonPath();
        //status kodun 200,
        //Assert.assertEquals(200,response.getStatusCode());
        //Toplam 24 tane çalışan olduğunu,
      //  System.out.println(jsonPath.getList("data.id").size());
           Assert.assertEquals(24,jsonPath.getList("data.id").size());
        //5. çalışanın isminin "Airi Satou" olduğunu ,
        Assert.assertEquals("Airi Satou",jsonPath.getString("data[4].employee_name"));
        //6. çalışanın maaşının "372000" olduğunu ,
        Assert.assertEquals(372000,jsonPath.getInt("data[5].employee_salary"));
        //"Rhona Davidson" ın employee lerden biri olduğunu
        Assert.assertTrue(jsonPath.getList("data.employee_name").contains("Rhona Davidson"));
        //"21", "23", "61" yaşlarında employeeler olduğunu test edin
        List<Integer> list=new ArrayList<Integer>();
        list.add(21);
        list.add(23);
        list.add(61);

        Assert.assertTrue(jsonPath.getList("data.employee_age").containsAll(list));

    }
}
