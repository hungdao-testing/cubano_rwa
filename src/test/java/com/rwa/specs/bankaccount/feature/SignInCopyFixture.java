package com.rwa.specs.bankaccount.feature;

import org.concordion.api.*;
import org.concordion.cubano.driver.http.JsonReader;
import org.concordion.cubano.template.framework.CubanoTemplateIndex;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class SignInCopyFixture extends CubanoTemplateIndex {

    public void printJsonToConsole(String data) throws IOException {
        JsonReader jsonReader = new JsonReader(data);
        System.out.println(jsonReader.asJson().getAsJsonObject().get("arg"));

    }

    @ConcordionScoped(Scope.SPECIFICATION)
    private ScopedObjectHolder<SignInData> specScopedData = new ScopedObjectHolder<SignInData>() {
        @Override
        protected SignInData create() {
            return new SignInData();
        }

        @Override
        protected void destroy(SignInData signInData) {
            super.destroy(signInData);
        }
    };

    public void setScopeUserName(String username){
        specScopedData.get().setUsername(username);
    }

    public String getScopedUsername(){
        return specScopedData.get().getUsername();
    }

    public void setScopePassword(String password){
        specScopedData.get().setPassword(password);
    }

    public String getScopePassword(){
        return specScopedData.get().getPassword();
    }

    public void setScopeSignInData(Object data){

    }

    class SignInData{
        String username;
        String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
