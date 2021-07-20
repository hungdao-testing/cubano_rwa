package com.rwa.component;

import com.rwa.specs.BasePageObject;
import org.concordion.cubano.driver.BrowserBasedTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBarPage extends BasePageObject{
    @FindBy(css = "[data-test='sidenav-user-full-name']")
    private WebElement userName;

    @FindBy(css = "[data-test='sidenav-user-balance']")
    private WebElement balance;

    public SideBarPage(BrowserBasedTest test) {
        super(test);
    }

    public boolean isAt(){
        waitUntilElementVisible(userName);
        waitUntilElementVisible(balance);
        return true;
    }
}
