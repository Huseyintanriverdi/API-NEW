package com.techproed.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Before;

public class JsonPlaceHolderTestBase {
    protected RequestSpecification spec01;
    @Before
    public void setup(){
        spec01 =new RequestSpecBuilder().
                setBaseUri("https://jsonplaceholder.typicode.com").
                build();
    }

}
