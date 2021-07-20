package com.rwa.pages;

import com.rwa.specs.BasePageObject;
import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.driver.web.ChainExpectedConditions;
import org.concordion.cubano.template.AppConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
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
    private List<WebElement> inlineErrorMessageEls;

    @FindBy(css = "[data-test='signin-error']")
    private WebElement alertErrorMessage;

    public SignInPage(BrowserBasedTest test) {
        super(test);
    }

    public SignInPage goTo(BrowserBasedTest browserBasedTest){
        browserBasedTest.getBrowser().getDriver().get(AppConfig.getInstance().getWebUrl() + "/signin");
        return this;
    }

    public SignInPage isAt(){
        waitUntilElementVisible(usernameField);
        return this;
    }

    public SignInPage inputUsername(String userName){
        this.usernameField.sendKeys(userName);
        return this;
    }

    public SignInPage inputPassword(String password){
        this.passwordField.sendKeys(password);
        return this;
    }

    public void submit(){
        this.waitForElementToClickable(this.submitBtn, AppConfig.getInstance().getDefaultTimeout());
        Actions action = new Actions(this.getBrowser().getDriver());
        action.moveToElement(submitBtn).click().perform();
        this.waitUntilPageIsLoaded(AppConfig.getInstance().getDefaultTimeout());
    }


    public boolean isOneOfInputFieldViolateDataRule(){
        return this.inlineErrorMessageEls.stream().anyMatch(l -> l.isDisplayed());
    }

    public boolean isAlertErrorDisplayed(){
        this.waitUntil(ExpectedConditions.visibilityOf(alertErrorMessage), AppConfig.getInstance().getDefaultTimeout());
        return true;
    }

    public List<WebElement> getInlineErrorMessageEls() {
        return inlineErrorMessageEls;
    }

    public WebElement getAlertErrorMessage() {
        return alertErrorMessage;
    }
}
