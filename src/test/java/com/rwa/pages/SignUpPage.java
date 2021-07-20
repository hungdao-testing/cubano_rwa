package com.rwa.pages;

import com.rwa.specs.BasePageObject;
import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.driver.web.ChainExpectedConditions;
import org.concordion.cubano.template.AppConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SignUpPage extends BasePageObject {
    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(css = "button[data-test='signup-submit']")
    private WebElement submitBtn;

    @FindBy(css = "p.Mui-error")
    private List<WebElement> errorMessageEls;

    public SignUpPage(BrowserBasedTest test) {
        super(test);
    }

    public  SignUpPage open(BrowserBasedTest browserBasedTest){
        browserBasedTest.getBrowser().getDriver().navigate().to(AppConfig.getInstance().getWebUrl() + "/signup");
        return this;
    }

    public SignUpPage isAt(){
        this.waitUntilPageIsLoaded(AppConfig.getInstance().getDefaultTimeout());
        ChainExpectedConditions
                .with(ExpectedConditions.visibilityOf(firstNameField))
                .and(ExpectedConditions.visibilityOf(lastNameField))
                .and(ExpectedConditions.visibilityOf(usernameField))
                .and(ExpectedConditions.visibilityOf(passwordField))
                .and(ExpectedConditions.visibilityOf(confirmPasswordField));
        return this;
    }

    public SignUpPage inputName(String firstName, String lastName){
        firstNameField.sendKeys(setOutputIfInputValueIsEmpty(firstName));
        lastNameField.sendKeys(setOutputIfInputValueIsEmpty(lastName));
        return this;
    }

    public SignUpPage inputPwd(String password, String confirmPassword){
        passwordField.sendKeys(setOutputIfInputValueIsEmpty(password));
        confirmPasswordField.sendKeys(setOutputIfInputValueIsEmpty(confirmPassword));
        return this;
    }

    public SignUpPage inputUsername(String username){
        usernameField.sendKeys(setOutputIfInputValueIsEmpty(username));
        return this;
    }

    public void submit(){
        this.waitForElementToClickable(submitBtn, AppConfig.getInstance().getDefaultTimeout());
        submitBtn.click();
    }

    public List<WebElement> getErrorMessageEls() {
        return errorMessageEls;
    }

    public boolean isInputFieldsError(){
        return this.errorMessageEls.size() > 0;
    }
}
