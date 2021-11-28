package com.techproed.day09;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class GetRequest14 extends DummyTestBase {
    //http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
    //Status kodun 200 olduğunu,
    //En yüksek maaşın 725000 olduğunu,
    //En küçük yaşın 19 olduğunu,
    //İkinci en yüksek maaşın 675000
    //olduğunu test edin.

    @Test
    public void test() {
        spec03.pathParam("parametre1", "employees");
        DummyTestData expectedObje = new DummyTestData();
        HashMap<String, Integer> expectedDataMap = expectedObje.setupTestData02();
        System.out.println(expectedDataMap);
        Response response = given().accept("application/json").spec(spec03).when().get("/{parametre1}");

        //DE serialization
        HashMap<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);
        //Status kodun 200 olduğunu,
        Assert.assertEquals(expectedDataMap.get("statusCode"), (Integer) response.getStatusCode());
        //En yüksek maaşın 725000 olduğunu,
        int dataSize = ((List) actualDataMap.get("data")).size();
        List<Integer> maasListesi = new ArrayList<>();
        for (int i = 0; i < dataSize; i++) {
          maasListesi.add ((Integer) ((Map) ((List) actualDataMap.get("data")).get(i)).get("employee_salary"));

        }
        Collections.sort(maasListesi);
        Assert.assertEquals(expectedDataMap.get("enYuksekMaas"),maasListesi.get(maasListesi.size()-1));
        //İkinci en yüksek maaşın 675000
        Assert.assertEquals(expectedDataMap.get("ikinciYuksekMaas"),maasListesi.get(maasListesi.size()-2));
        //En küçük yaşın 19 olduğunu,

        List<Integer> yasListesi=new ArrayList<>();
        for (int i=0;i<dataSize;i++){
            yasListesi.add((Integer)((Map)((List<?>) actualDataMap.get("data")).get(i)).get("employee_age"));

        }
        Collections.sort(yasListesi);
        Assert.assertEquals(expectedDataMap.get("enKucukYas"),yasListesi.get(0));
        //2-Json Path ile
        JsonPath json=response.jsonPath();
        //En yüksek maaşın 725000 olduğunu,
        List<Integer> maasListesiJson=json.getList("data.employee_salary");
        Collections.sort(maasListesiJson);
        Assert.assertEquals(expectedDataMap.get("enYuksekMaas"),maasListesiJson.get(maasListesiJson.size()-1));
        Assert.assertEquals(expectedDataMap.get("ikinciYuksekMaas"),maasListesiJson.get(maasListesiJson.size()-2));
        //En küçük yaşın 19 olduğunu,
        List<Integer> yasListesiJson=json.getList("data.employee_age");
        Collections.sort(yasListesiJson);
        Assert.assertEquals(expectedDataMap.get("enKucukYas"),yasListesiJson.get(0));
    }
}
