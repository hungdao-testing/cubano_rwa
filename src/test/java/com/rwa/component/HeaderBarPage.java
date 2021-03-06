package com.rwa.component;

import com.rwa.specs.BasePageObject;
import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.driver.web.ChainExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderBarPage extends BasePageObject {

    @FindBy(css = "[data-test='sidenav-toggle']")
    private WebElement sideNavToggle;

    @FindBy(css = "[data-test='app-name-logo']")
    private WebElement appNameLogo;

    @FindBy(css = "[data-test='nav-top-new-transaction']")
    private WebElement newTransactionButton;

    @FindBy(css = "[data-test='nav-top-notifications-link']")
    private WebElement bellNotificationIcon;

    public HeaderBarPage(BrowserBasedTest test) {
        super(test);
    }

    public boolean isAt(){
        ChainExpectedConditions
                .with(ExpectedConditions.visibilityOf(appNameLogo))
                .and(ExpectedConditions.visibilityOf(bellNotificationIcon));
        return true;
    }
}
