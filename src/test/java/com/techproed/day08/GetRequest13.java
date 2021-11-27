package com.techproed.day08;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class GetRequest13 extends DummyTestBase {
    /*
    http://dummy.restapiexample.com/api/v1/employees
    Status kodun 200 olduğunu,
            5. Çalışan isminin "Airi Satou" olduğunu ,
    çalışan sayısının 24 olduğunu,
    Sondan 2. çalışanın maaşının 106450 olduğunu
40,21 ve 19 yaslarında çalışanlar olup olmadığını
11. Çalışan bilgilerinin
    {
 “id”:”11”
        "employee_name": "Jena Gaines",
            "employee_salary": "90560",
            "employee_age": "30",
            "profile_image": "" }
            */
    @Test
    public void test(){
        spec03.pathParam("parametre1","employees");
        DummyTestData expectedObje=new DummyTestData();
        HashMap<String,Object> expectedDataMap=expectedObje.setupTestData();
        Response response=given().accept("application/json").spec(spec03).when().get("/{parametre1}");
        //response.prettyPrint();

        // De Serialization
        HashMap<String,Object> actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);
        //Status kodun 200 olduğunu,
        Assert.assertEquals(expectedDataMap.get("statusCode"),response.getStatusCode());
        //  5. Çalışan isminin "Airi Satou" olduğunu
        Assert.assertEquals(expectedDataMap.get("besinciCalisan"),((Map)((List)actualDataMap.get("data")).get(4)).get("employee_name"));
        //çalışan sayısının 24 olduğunu,
        Assert.assertEquals(expectedDataMap.get("calisanSayisi"),((List<?>) actualDataMap.get("data")).size());
        //Sondan 2. çalışanın maaşının 106450 olduğunu
        //once actual datanin bize donen listin size ini almaliyiz
        int dataSize=((List<?>) actualDataMap.get("data")).size();
        Assert.assertEquals(expectedDataMap.get("sondanIkinciCalisan"),((Map)((List<?>) actualDataMap.get("data")).get(dataSize-2)).get("employee_salary"));
        //40,21 ve 19 yaslarında çalışanlar olup olmadığını
        List<Integer> actualYasListesi=new ArrayList<>();
        for (int i=0;i<dataSize;i++){
           actualYasListesi.add((Integer) ((Map)((List<?>) actualDataMap.get("data")).get(i)).get("employee_age"));
        }
        Assert.assertTrue(actualYasListesi.containsAll((List) expectedDataMap.get("arananYaslari")));
  /*      11. Çalışan bilgilerinin
        {
 “id”:”11”
            "employee_name": "Jena Gaines",
                "employee_salary": "90560",
                "employee_age": "30",
                "profile_image": "" }
            */
        Assert.assertEquals(((Map)expectedDataMap.get("onbirinciCalisan")).get("employee_name"),((Map)((List<?>) actualDataMap.get("data")).get(10)).get("employee_name"));

        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("onbirinciCalisan")).get("employee_salary"),((Map) ((List<?>) actualDataMap.get("data")).get(10)).get("employee_salary"));

        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("onbirinciCalisan")).get("employee_age"),((Map) ((List<?>) actualDataMap.get("data")).get(10)).get("employee_age"));

        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("onbirinciCalisan")).get("profile_image"),((Map) ((List<?>) actualDataMap.get("data")).get(10)).get("profile_image"));
    }
}
