package com.rwa.pages;

import com.rwa.specs.BaseFixture;
import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.template.AppConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignUpPage extends BaseFixture {
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


    public static SignUpPage goTo(BrowserBasedTest browserBasedTest){
        browserBasedTest.getBrowser().getDriver().navigate().to(AppConfig.getInstance().getWebUrl() + "/signup");
        return new SignUpPage(browserBasedTest);
    }
    public  SignUpPage open(BrowserBasedTest browserBasedTest){
        browserBasedTest.getBrowser().getDriver().navigate().to(AppConfig.getInstance().getWebUrl() + "/signup");
        return this;
    }

    public SignUpPage inputName(String firstName, String lastName){
        firstNameField.sendKeys(setOutputForEmptyInput(firstName));
        lastNameField.sendKeys(setOutputForEmptyInput(lastName));
        return this;
    }

    public SignUpPage inputPwd(String password, String confirmPassword){
        passwordField.sendKeys(setOutputForEmptyInput(password));
        confirmPasswordField.sendKeys(setOutputForEmptyInput(confirmPassword));
        return this;
    }

    public SignUpPage inputUsername(String username){
        usernameField.sendKeys(setOutputForEmptyInput(username));
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
