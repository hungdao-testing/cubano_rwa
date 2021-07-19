package com.rwa.component;

import com.rwa.specs.BasePageObject;
import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.driver.web.ChainExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SideBarPage extends BasePageObject{
    @FindBy(css = "[data-test='sidenav-user-full-name']")
    private WebElement userName;

    @FindBy(css = "[data-test='sidenav-user-balance']")
    private WebElement balance;

    public SideBarPage(BrowserBasedTest test) {
        super(test);
    }

    public boolean isAt(){
        ChainExpectedConditions
                .with(ExpectedConditions.visibilityOf(userName))
                .and(ExpectedConditions.visibilityOf(balance));
        return true;
    }
}
