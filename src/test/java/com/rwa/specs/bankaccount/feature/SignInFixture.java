package com.rwa.specs.bankaccount.feature;

import com.rwa.data.fixture.User;
import com.rwa.data.management.DataManagement;
import com.rwa.pages.HomePage;
import com.rwa.pages.SignInPage;
import com.rwa.services.BankAccountService;
import org.concordion.api.*;
import org.concordion.cubano.template.framework.CubanoTemplateFixture;


@FullOGNL
public class SignInFixture extends CubanoTemplateFixture {

    protected SignInPage signInPage;
    protected HomePage homePage;
    protected BankAccountService bankAccountService;

    @BeforeExample
    public void setUpExample(){
        this.signInPage = new SignInPage(this);
        this.homePage = new HomePage(this);
        this.bankAccountService = new BankAccountService();
    }

    public User getSignInData(){
        return DataManagement.getUsers().stream().filter(user -> user.getBalance() > 0).findFirst().get();
    }

    public String loginToSystemSuccessfully(String username, String password, String condition){
        this.signInPage
                .goTo(this)
                .isAt()
                .inputUsername(username)
                .inputPassword(password);
        this.signInPage.submit();
        this.homePage.assertHomePageIsLoaded();
        return condition;
    }
    public String loginToSystemWithIncorrectDataFormat(String username, String password, String condition){
        this.signInPage
                .goTo(this)
                .isAt()
                .inputUsername(username)
                .inputPassword(password);
        if (this.signInPage.isOneOfInputFieldViolateDataRule()) return getErrorMessage();
        else return condition;
    }

    public String loginToSystemWithIncorrectCredentials(String username, String password){
        this.signInPage
                .goTo(this)
                .isAt()
                .inputUsername(username)
                .inputPassword(password);
        this.signInPage.submit();
        return getErrorMessage();
    }
    
    private String getErrorMessage(){
        if(this.signInPage.isOneOfInputFieldViolateDataRule()){
            return this.signInPage.getInlineErrorMessageEls().get(0).getText();
        }

        if(this.signInPage.isAlertErrorDisplayed()){
            return this.signInPage.getAlertErrorMessage().getText();
        }
        return "";
    }
}
