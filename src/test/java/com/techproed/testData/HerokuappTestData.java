package com.techproed.testData;

import org.json.JSONObject;

import java.util.HashMap;

public class HerokuappTestData {
     /*
    https://restful-booker.herokuapp.com/booking/1 url ine bir istek gönderildiğinde
 dönen response body nin
{
 "firstname": "Eric",
 "lastname": "Smith",
 "totalprice": 555,
 "depositpaid": false,
 "bookingdates": {
 "checkin": "2016-09-09",
 "checkout": "2017-09-21"
 }
 } gibi olduğunu test edin
     */
public HashMap<String, Object> setupTestData(){
    HashMap<String,Object> bookingdates=new HashMap<>();
    bookingdates.put("checkin","2016-04-13");
    bookingdates.put("checkout","2020-02-19");

    HashMap<String,Object> expectedData=new HashMap<>();
    expectedData.put("firstname","Mark");
    expectedData.put("lastname","Ericsson");
    expectedData.put("totalprice",292);
    expectedData.put("depositpaid",false);
    expectedData.put("bookingdates",bookingdates);
    return expectedData;
}
public JSONObject setupTestAndRequest(){
    JSONObject bookingDates=new JSONObject();
    bookingDates.put("checkin","2021-01-05");
    bookingDates.put("checkout","2021-01-10");
    JSONObject expectedRequest=new JSONObject();
    expectedRequest.put("firstname","kurs");
    expectedRequest.put("lastname","bitti");
    expectedRequest.put("totalprice",123);
    expectedRequest.put("depositpaid",false);
    expectedRequest.put("bookingdates",bookingDates);
    return expectedRequest;



}


}
