package com.rwa.specs.bankaccount;

import com.rwa.data.fixture.User;
import com.rwa.data.management.DataManagement;
import org.concordion.api.BeforeSpecification;
import org.concordion.cubano.template.framework.CubanoTemplateIndex;

import java.util.List;

public class BankAccountFixture extends CubanoTemplateIndex {

    public static List<User> users;

    @BeforeSpecification
    public void setUpSpec(){
        logger.info("=== Prepare data for Bank Account feature ===");
        users = DataManagement.getUsers();
    }
}
