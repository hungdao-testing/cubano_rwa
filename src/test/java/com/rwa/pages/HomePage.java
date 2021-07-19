package com.rwa.pages;


import com.google.common.util.concurrent.Uninterruptibles;
import com.rwa.component.HeaderBarPage;
import com.rwa.component.SideBarPage;
import com.rwa.specs.BasePageObject;
import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.template.AppConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;


public class HomePage extends BasePageObject {

    @FindBy(css = "[data-test='user-onboarding-dialog']")
    private WebElement onBoardingDialog;

    private SideBarPage sideBarPage;
    private HeaderBarPage headerBarPage;

    public HomePage(BrowserBasedTest test) {
        super(test);
        this.sideBarPage = new SideBarPage(test);
        this.headerBarPage = new HeaderBarPage(test);
    }

    public boolean isAt(){
        this.waitUntilPageIsLoaded(AppConfig.getInstance().getDefaultTimeout());
        return this.sideBarPage.isAt() && this.headerBarPage.isAt();
    }

    public void onBoardingUser(){

    }



}
