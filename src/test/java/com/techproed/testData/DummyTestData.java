package com.techproed.testData;

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
}