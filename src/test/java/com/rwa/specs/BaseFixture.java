package com.rwa.specs;

import org.concordion.api.FullOGNL;
import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.template.driver.ui.PageObject;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

@FullOGNL
public class BaseFixture extends PageObject<BaseFixture> {
    protected  WebDriverWait explicitWait;

    public BaseFixture(BrowserBasedTest test) {
        super(test);
    }

    @Override
    public ExpectedCondition<?> pageIsLoaded(Object... params) {
        return null;
    }

    protected String setOutputForEmptyInput(String input){
        return input == null ? "" : input;
    }
}
