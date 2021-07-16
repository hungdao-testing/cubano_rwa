package com.rwa.pages;

import com.rwa.specs.BasePageObject;
import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.template.AppConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SignInPage extends BasePageObject {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "[data-test='signin-remember-me']")
    private WebElement rememberCheckbox;

    @FindBy(css = "[data-test='signin-submit']")
    private WebElement submitBtn;

    @FindBy(css = "p.Mui-error")
    private List<WebElement> errorMessageEls;

    public SignInPage(BrowserBasedTest test) {
        super(test);
    }


    public SignInPage goTo(BrowserBasedTest browserBasedTest){
        browserBasedTest.getBrowser().getDriver().get(AppConfig.getInstance().getWebUrl() + "/signin");
        return this;
    }

    public SignInPage inputUsername(String userName){
        this.inputField(usernameField, userName);
        return this;
    }

    public SignInPage inputPassword(String password){
        this.inputField(passwordField, password);
        return this;
    }

    public void submit(){
        this.waitForElementToClickable(this.submitBtn, AppConfig.getInstance().getDefaultTimeout());
        submitBtn.click();
    }

    public List<WebElement> getErrorMessageEls() {
        return errorMessageEls;
    }

    public boolean isOneOfInputFieldsError(){
        return this.errorMessageEls.size() > 0;
    }

}
