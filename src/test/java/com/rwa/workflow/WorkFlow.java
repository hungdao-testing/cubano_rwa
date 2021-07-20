package com.rwa.workflow;

import com.rwa.pages.HomePage;
import com.rwa.pages.SignInPage;
import com.rwa.specs.BasePageObject;
import org.concordion.cubano.driver.BrowserBasedTest;

public class WorkFlow extends BasePageObject {

    private SignInPage signInPage;

    public WorkFlow(BrowserBasedTest test) {
        super(test);
        this.signInPage = new SignInPage(test);
    }

    public HomePage loginWorkFlow(String username, String password){
        signInPage
                .goTo(this.getTest())
                .inputUsername(username)
                .inputPassword(password)
                .submit();
        return new HomePage(this.getTest());
    }
}
