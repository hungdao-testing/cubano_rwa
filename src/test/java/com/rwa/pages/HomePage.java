package com.rwa.pages;


import com.rwa.component.HeaderBarPage;
import com.rwa.component.SideBarPage;
import com.rwa.specs.BasePageObject;
import org.concordion.cubano.driver.BrowserBasedTest;
import org.concordion.cubano.template.AppConfig;
import org.junit.Assert;


public class HomePage extends BasePageObject {

    private SideBarPage sideBarPage;
    private HeaderBarPage headerBarPage;
    private OnBoardingProcessComponent onBoardingProcessComponent;

    public HomePage(BrowserBasedTest test) {
        super(test);
        this.sideBarPage = new SideBarPage(test);
        this.headerBarPage = new HeaderBarPage(test);
        this.onBoardingProcessComponent = new OnBoardingProcessComponent(test);
    }

    public void isAt(){
        this.waitUntilPageIsLoaded(AppConfig.getInstance().getDefaultTimeout());
        Assert.assertTrue("The home page is not loaded", this.sideBarPage.isAt() && this.headerBarPage.isAt());

    }

    public SideBarPage getSideBarPage() {
        return sideBarPage;
    }

    public HeaderBarPage getHeaderBarPage() {
        return headerBarPage;
    }

    public OnBoardingProcessComponent getOnBoardingProcessComponent() {
        return onBoardingProcessComponent;
    }
}
