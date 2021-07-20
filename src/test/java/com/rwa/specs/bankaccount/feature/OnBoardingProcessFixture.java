package com.rwa.specs.bankaccount.feature;

import com.rwa.pages.HomePage;
import com.rwa.pages.OnBoardingProcessComponent;
import com.rwa.services.BankAccountService;
import com.rwa.workflow.WorkFlow;
import org.concordion.api.AfterExample;
import org.concordion.api.BeforeExample;
import org.concordion.api.MultiValueResult;
import org.concordion.cubano.template.framework.CubanoTemplateFixture;
import org.junit.After;


public class OnBoardingProcessFixture extends CubanoTemplateFixture {

    private WorkFlow workFlow;
    private HomePage homePage;
    private BankAccountService bankAccountService;

    @BeforeExample
    public void setUp(){
        this.workFlow = new WorkFlow(this);
        this.bankAccountService = new BankAccountService();
    }

    public void setUpOnBoardingData(String fullName, String username, String password){
        this.bankAccountService.createUserAccount(fullName, username, password);
    }

    public HomePage triggerOnBoardingProcessForUser(String username, String password){
        this.homePage = this.workFlow.loginWorkFlow(username, password);
        return this.homePage;
    }

    public MultiValueResult processOnBoardingFlow(String bankName, String routingNumber, String accountNumber){
        this.getBrowser().getDriver().navigate().refresh();
        return this.homePage
                .getOnBoardingProcessComponent()
                .waitForOnBoardingDialogLoaded()
                .processOnBoardingForNewUser(bankName, routingNumber, accountNumber);
    }



}
