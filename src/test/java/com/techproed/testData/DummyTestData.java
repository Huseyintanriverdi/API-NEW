package com.techproed.testData;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DummyTestData {
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
    public HashMap<String, Object> setupTestData(){
        List<Integer> yaslar=new ArrayList<>();
        yaslar.add(40);
        yaslar.add(21);
        yaslar.add(19);
        HashMap<String,Object> onbirinci=new HashMap<>();
        onbirinci.put("id",11);
        onbirinci.put("employee_name","Jena Gaines");
        onbirinci.put("employee_salary",90560);
        onbirinci.put("employee_age",30);
        onbirinci.put("profile_image","");
        HashMap<String,Object> expectedData=new HashMap<>();
        expectedData.put("statusCode",200);
        expectedData.put("besinciCalisan","Airi Satou");
        expectedData.put("calisanSayisi",24);
        expectedData.put("sondanIkinciCalisan",106450);
        expectedData.put("arananYaslari",yaslar);
        expectedData.put("onbirinciCalisan",onbirinci);
        return expectedData;
    }

    //http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
    //Status kodun 200 olduğunu,
    //En yüksek maaşın 725000 olduğunu,
    //En küçük yaşın 19 olduğunu,
    //İkinci en yüksek maaşın 675000
    //olduğunu test edin.
    public HashMap<String, Integer> setupTestData02(){
        HashMap<String,Integer> expectedData=new HashMap<>();
        expectedData.put("statusCode",200);
        expectedData.put("enYuksekMaas",725000);
        expectedData.put("enKucukYas",19);
        expectedData.put("ikinciYuksekMaas",675000);
        return expectedData;
    }
    public HashMap<String, String> setupRequestBody(){
        HashMap<String,String> requestBody=new HashMap<>();
        requestBody.put("name","ferhancigim");
        requestBody.put("salary","123456");
        requestBody.put("age","32");
        return requestBody;
    }
        public HashMap<String, Object> setupExpectedData(){
        HashMap<String,Object> data=new HashMap<>();
        data.put("name","ferhancigim");
        data.put("salary","123456");
        data.put("age","32");
        HashMap<String,Object> expectedData=new HashMap<>();
        expectedData.put("statusCode",200);
        expectedData.put("status","success");
        expectedData.put("data",data);
        expectedData.put("message","Successfully! Record has been added.");
        return expectedData;
        }
        public JSONObject setUpDeleteExpectedData(){
            JSONObject expectedData=new JSONObject();
            expectedData.put("status","success");
            expectedData.put("data","2");
            expectedData.put("message","Successfully! Record has been deleted");
            return expectedData;

        }
}
