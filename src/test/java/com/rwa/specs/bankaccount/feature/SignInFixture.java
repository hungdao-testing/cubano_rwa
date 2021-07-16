package com.rwa.specs.bankaccount.feature;

import com.rwa.data.fixture.User;
import com.rwa.data.management.DataManagement;
import com.rwa.pages.HomePage;
import com.rwa.pages.SignInPage;
import org.concordion.api.*;
import org.concordion.cubano.template.framework.CubanoTemplateFixture;
import org.concordion.cubano.template.framework.CubanoTemplateIndex;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;


@FullOGNL
public class SignInFixture extends CubanoTemplateFixture {
    private SignInPage signInPage;
    private HomePage homePage;

    @Before
    public void setUp(){
        logger.info(" === Before : ====");
    }

    @After
    public void tearDown () {
        logger.info(" ==== After: Start clearing local storage ==== ");
        JavascriptExecutor js = (JavascriptExecutor) this.getBrowser().getDriver();
        js.executeScript("window.localStorage.clear()");
    }

    @BeforeExample
    public void setUpExample(){
        logger.info(" ========== Before Example: Start setUp Page Object ======== ");
        this.signInPage = new SignInPage(this);
        this.homePage = new HomePage(this);
    }

    @AfterExample
    public void tearDownExample(){
        logger.info(" ==== After Example ==== ");
    }

    @ConcordionScoped(Scope.SPECIFICATION)
    private final ScopedObjectHolder<DataManagement> specScopeData = new ScopedObjectHolder<DataManagement>() {
        @Override
        protected DataManagement create(){
            return new DataManagement();
        }

        @Override
        protected void destroy(DataManagement dataManagement){
            dataManagement.delete();
        }
    };

    public MultiValueResult setUpSignInData(){
        logger.info(" ==== Start setUp Sign In Data ==== ");
        List<User> users = specScopeData.get().getUsers();
        User waitingBankAccountUser = users
                                        .stream()
                                        .filter(u -> u.getBalance() == 0).findFirst().get();
        User activatedBankAccountUser = users
                                        .stream()
                                        .filter(u -> u.getBalance() > 0).findFirst().get();
        return new MultiValueResult()
                .with("waitingBankingAccount", waitingBankAccountUser)
                .with("activatedBankingAccount", activatedBankAccountUser);
    }

    public boolean signIn(String username, String password) {
        this.signInPage
                .goTo(this)
                .inputUsername(username)
                .inputPassword(password);
        if(!this.signInPage.isOneOfInputFieldsError()){
            this.signInPage.submit();
            return this.homePage.isAt();
        }
        return false;
    }





}
