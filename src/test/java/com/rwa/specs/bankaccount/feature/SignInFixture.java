package com.rwa.specs.bankaccount.feature;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rwa.data.fixture.User;
import com.rwa.data.management.DataManagement;
import com.rwa.pages.HomePage;
import com.rwa.pages.SignInPage;
import com.rwa.services.BankAccountService;
import org.concordion.api.*;
import org.concordion.cubano.template.framework.CubanoTemplateFixture;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;


@FullOGNL
public class SignInFixture extends CubanoTemplateFixture {

    protected SignInPage signInPage;
    protected HomePage homePage;

    @BeforeExample
    public void setUpExample(){
        this.signInPage = new SignInPage(this);
        this.homePage = new HomePage(this);
    }

    public User getSignInData(){
        return DataManagement.getUsers().stream().filter(user -> user.getBalance() > 0).findFirst().get();
    }

    public String assertLoginProcessWithValidCredentials(String username, String password, String condition){
        this.signInPage
                .goTo(this)
                .isAt()
                .inputUsername(username)
                .inputPassword(password);
        this.signInPage.submit();
        this.homePage.isAt();
        return condition;
    }

    public String assertLoginUnsuccessfullyWithInvalidData(String username, String password, String condition){
        this.signInPage
                .goTo(this)
                .isAt()
                .inputUsername(username)
                .inputPassword(password);
        if (this.signInPage.isInlineErrorDisplayed()) {
            return this.signInPage.getInlineErrorMessageEls();
        };
        this.signInPage.submit();
        if (this.signInPage.isAlertMessageDisplayed()) {
            return this.signInPage.getAlertErrorMessages();
        }
        return condition;
    }
}
