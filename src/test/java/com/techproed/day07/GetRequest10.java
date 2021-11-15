package com.techproed.day07;

import com.sun.xml.bind.v2.runtime.reflect.Lister;
import com.techproed.testBase.DummyTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest10 extends DummyTestBase {
    @Test
    public void test(){
       //http://dummy.restapiexample.com/api/v1/employees
        //url ine bir istek gönderildiğinde
        //Dönen response un



        // 3)Maası 350000 den büyük olan tüm employee name’leri ekrana yazdırın ve
        //  bunların içerisinde “Charde Marshall” olduğunu test edin
        spec03.pathParam("parametre1","employees");
        Response response=given().accept("application/json")
                .spec(spec03)
                .when()
                .get("/{parametre1}");
        JsonPath jsonPath=response.jsonPath();
        // Status kodunun 200,
      //  Assert.assertEquals(200,response.getStatusCode());
        // 1)10’dan büyük tüm id’leri ekrana yazdırın ve
        //10’dan büyük 14 id olduğunu,
      List<Integer> idList =jsonPath.getList( "data.findAll{it.id>10}.id");
        System.out.println(idList);
        Assert.assertEquals(14,idList.size());
        // 2)30’dan küçük tüm yaşları ekrana yazdırın ve
        //  bu yaşların içerisinde en büyük yaşın 23 olduğunu
        List <Integer> ageList=  jsonPath.getList( "data.findAll{it.employee_age<30}.employee_age");
        System.out.println(ageList);
        Collections.sort(ageList);
        Assert.assertEquals(23,(int)ageList.get(ageList.size()-1));
        // 3)Maası 350000 den büyük olan tüm employee name’leri ekrana yazdırın ve
        //  bunların içerisinde “Charde Marshall” olduğunu test edin
   List<Integer> nameList= jsonPath.getList("data.findAll{it.employee_salary>350000}.employee_name");
        System.out.println(nameList);
        Assert.assertTrue(nameList.contains("Charde Marshall"));
    }

}
