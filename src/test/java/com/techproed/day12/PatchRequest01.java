package com.techproed.day12;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import org.junit.Test;

public class PatchRequest01 extends JsonPlaceHolderTestBase {
    //https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönderdiğimde
    // {
    // "title": "API calismaliyim"
    // }
    // Dönen response un status kodunun 200 ve
    // body kısmının aşağıdaki gibi olduğunu test edin
    // {
    // "userId": 10,
    // "title": "API calismaliyim",
    // "completed": true,
    // "id": 198
    // }
    @Test
    public void test(){
        //url
        spec01.pathParams("parametre1","todos","parametre2",198);
        // expected request data olustur

    }
}
