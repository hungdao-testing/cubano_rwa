package com.rwa.specs.bankaccount;

import com.rwa.services.BankAccountService;
import org.concordion.cubano.template.framework.CubanoTemplateIndex;

import java.io.IOException;

public class BankAccountFixture extends CubanoTemplateIndex {

    public boolean getResultOfCreatingUserAccount(String name, String username, String password) throws IOException {
        BankAccountService bankAccountService = new BankAccountService();
        return bankAccountService.createUserAccount(name, username, password).getResponseCode() == 201;
    }
}
