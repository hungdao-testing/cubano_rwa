package com.rwa.pages;

import com.rwa.specs.BasePageObject;
import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.driver.web.ChainExpectedConditions;
import org.concordion.cubano.template.AppConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OnBoardingProcessComponent extends BasePageObject {

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

    public OnBoardingProcessComponent(BrowserBasedTest test) {
        super(test);
    }

    public OnBoardingProcessComponent waitForOnBoardingDialogLoaded(){
        waitUntilElementVisible(onBoardingDialog);
        return this;
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

        if(isOneOfInputFieldsError()) return;

        this.waitForElementToClickable(saveBtn, AppConfig.getInstance().getDefaultTimeout());
        saveBtn.click();

        this.waitUntil(ExpectedConditions.textToBePresentInElement(
                onBoardingTitle, "Finished"), AppConfig.getInstance().getDefaultTimeout());
        this.waitForElementToClickable(nextButton, AppConfig.getInstance().getDefaultTimeout());
        nextButton.click();
        ExpectedConditions.invisibilityOf(onBoardingDialog);
    }
}