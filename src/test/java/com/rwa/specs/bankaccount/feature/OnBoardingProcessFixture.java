package com.rwa.specs.bankaccount.feature;

import com.rwa.data.fixture.User;
import com.rwa.specs.bankaccount.BankAccountFixture;
import com.rwa.workflow.WorkFlow;
import org.concordion.api.BeforeExample;
import org.concordion.cubano.template.framework.CubanoTemplateFixture;


public class OnBoardingProcessFixture extends CubanoTemplateFixture {

    private WorkFlow workFlow;

    @BeforeExample
    public void setUp(){
        this.workFlow = new WorkFlow(this);
    }

    public User setUpOnBoardingData(){
        return BankAccountFixture.users.stream().filter(u -> u.getBalance() == 0).findAny().get();
    }

    public boolean processOnBoardingFlow(String username, String password, String bankName, String routingNumber, String accountNumber){
        this.workFlow
                .loginWorkFlow(username, password)
                .getOnBoardingProcessComponent()
                .waitForOnBoardingDialogLoaded()
                .processOnBoardingForNewUser(bankName, routingNumber, accountNumber);
        return true;
    }


}
