package com.rwa.pages;

import com.rwa.specs.BasePageObject;
import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.template.AppConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OnBoardingProcess extends BasePageObject {

    @FindBy(css = "[data-test='user-onboarding-dialog']")
    private WebElement onBoardingDialog;

    @FindBy(css = "[data-test='user-onboarding-dialog-title']")
    private WebElement onBoardingTitle;

    @FindBy(css = "[data-test='user-onboarding-next']")
    private WebElement nextButton;

    @FindBy(id = "bankaccount-bankName-input")
    private WebElement bankNameField;

    @FindBy(id = "bankaccount-routingNumber-input")
    private WebElement routingNumberField;

    @FindBy(id = "bankaccount-accountNumber-input")
    private WebElement accountNumber;

    @FindBy(css = "[data-test='bankaccount-submit']")
    private WebElement saveBtn;

    @FindBy(css = "p.Mui-error")
    private List<WebElement> errorMessages;

    public OnBoardingProcess(BrowserBasedTest test) {
        super(test);
    }

    public boolean isAt(){
        ExpectedConditions.textToBePresentInElement(onBoardingTitle, "Get Started with Real World App");
        return true;
    }

    public boolean isOneOfInputFieldsError(){
        return errorMessages.stream().anyMatch(WebElement::isDisplayed);
    }

    public void processOnBoardingForNewUser(String bankName, String routingNumber, String accountNum){
        this.waitForElementToClickable(nextButton, AppConfig.getInstance().getDefaultTimeout());
        nextButton.click();

        this.waitForElementToClickable(bankNameField, AppConfig.getInstance().getDefaultTimeout());
        bankNameField.sendKeys(bankName);
        routingNumberField.sendKeys(routingNumber);
        accountNumber.sendKeys(accountNum);

        this.waitForElementToClickable(saveBtn, AppConfig.getInstance().getDefaultTimeout());
        saveBtn.click();
    }
}
