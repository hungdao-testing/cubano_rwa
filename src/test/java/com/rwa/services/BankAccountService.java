package com.rwa.services;

import com.google.common.util.concurrent.Uninterruptibles;
import org.concordion.cubano.driver.http.HttpEasyReader;
import org.concordion.cubano.driver.http.JsonReader;
import com.google.common.net.MediaType;
import org.concordion.cubano.template.driver.services.ServiceBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BankAccountService extends BaseService {

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
            addNotification("TestLoggerLogWriter Request", testLoggerLogWriter.getRequest());
            addNotification("Raw JSON Response", response.getJsonReader().asPrettyString());
            addNotification("TestLoggerLogWriter Response", testLoggerLogWriter.getResponse());
            return response;

        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HttpEasyReader createUserAccount(String name, String username, String password){
        String CREATE_USER = "/users";
        String firstName = name.split(" ")[0];
        String lastName = name.split(" ")[1];

        String payload =
                String.format("{\n    \"firstName\": \"%s\",\n   " +
                        " \"lastName\": \"%s\",\n    " +
                        "\"username\": \"%s\",\n    " +
                        "\"password\": \"%s\"\n}", firstName, lastName, username, password);
        try{
            HttpEasyReader response = easy
                    .path(CREATE_USER)
                    .data(payload, MediaType.JSON_UTF_8)
                    .withLogWriter(testLoggerLogWriter)
                    .logRequestDetails()
                    .post();

            System.out.println(response.getJsonReader().asPrettyString());
            addNotification("TestLoggerLogWriter Request", testLoggerLogWriter.getRequest());
            addNotification("Raw JSON Response", response.getJsonReader().asPrettyString());
            addNotification("TestLoggerLogWriter Response", testLoggerLogWriter.getResponse());
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
