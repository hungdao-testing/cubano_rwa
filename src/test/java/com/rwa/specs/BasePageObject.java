package com.rwa.specs;

import org.concordion.api.FullOGNL;
import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.template.AppConfig;
import org.concordion.cubano.template.driver.ui.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

@FullOGNL
public class BasePageObject extends PageObject<BasePageObject> {

    public BasePageObject(BrowserBasedTest test) {
        super(test);
    }

    @Override
    public ExpectedCondition<?> pageIsLoaded(Object... params) {
        return null;
    }

    protected String setOutputIfInputValueIsEmpty(String input){
        return input == null ? "" : input;
    }

    protected void inputField(WebElement webElement, String value){
        this.waitForElementToClickable(webElement, AppConfig.getInstance().getDefaultTimeout());
        webElement.sendKeys(setOutputIfInputValueIsEmpty(value));
    }
}
