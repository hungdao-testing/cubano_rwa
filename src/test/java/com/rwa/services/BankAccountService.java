package com.rwa.services;


import com.google.gson.Gson;
import org.concordion.cubano.driver.http.HttpEasyReader;
import org.concordion.cubano.driver.http.JsonReader;
import com.google.common.net.MediaType;

import java.io.IOException;

public class BankAccountService extends BaseService{

    public HttpEasyReader loginByApi(String username, String password){
        String LOGIN = "/login";
        String payload =
                String.format("{\n    \"password\": \"%s\",\n    \"type\": \"LOGIN\",\n    \"username\": \"%s\"\n}", password, username);
        try{
            HttpEasyReader response = easy
                    .path(LOGIN)
                    .data(payload, MediaType.JSON_UTF_8)
                    .withLogWriter(testLoggerLogWriter)
                    .logRequestDetails()
                    .post();

            addNotification("Login Request", testLoggerLogWriter.getRequest());
            addNotification("Raw Login Response", response.getJsonReader().asPrettyString());
            addNotification("Login Response", testLoggerLogWriter.getResponse());
            return response;

        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JsonReader getUsers(){
        String GET_USERS = "/users";
        try {
            JsonReader jsonReader = easy
                    .path(GET_USERS)
                    .withLogWriter(testLoggerLogWriter)
                    .logRequestDetails()
                    .get()
                    .getJsonReader();

            addNotification("TestLoggerLogWriter Request", testLoggerLogWriter.getRequest());
            addNotification("Raw JSON Response", jsonReader.asPrettyString());
            addNotification("TestLoggerLogWriter Response", testLoggerLogWriter.getResponse());
            return jsonReader;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
