package com.rwa.specs.bankaccount.feature;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rwa.pages.SignUpPage;
import com.rwa.services.BankAccountService;
import org.concordion.api.AfterExample;
import org.concordion.api.BeforeExample;
import org.concordion.api.FullOGNL;
import org.concordion.api.MultiValueResult;
import org.concordion.cubano.driver.http.HttpEasyReader;
import org.concordion.cubano.template.framework.CubanoTemplateFixture;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.io.IOException;


@FullOGNL
public class SignUpFixture extends CubanoTemplateFixture {
    private SignUpPage signUpPage;
    private BankAccountService bankAccountService;

    @BeforeExample
    public void beforeExample() {
        this.signUpPage = new SignUpPage(this);
        this.bankAccountService = new BankAccountService();
    }

    @AfterExample
    public void tearDownExample() {
        JavascriptExecutor js = (JavascriptExecutor) this.getBrowser().getDriver();
        js.executeScript("window.localStorage.clear()");
    }


    public MultiValueResult registerAccount(String firstName, String lastName, String username, String password, String confirmPassword) throws IOException {
        MultiValueResult multiValueResult = new MultiValueResult();
        this.signUpPage
                .open(this)
                .inputName(firstName, lastName)
                .inputUsername(username)
                .inputPwd(password, confirmPassword);

        if (this.signUpPage.isInputFieldsError()) {
            return multiValueResult.with("signUpResult", false)
                    .with("errorMessage", this.signUpPage.getErrorMessageEls().get(0).getText());
        }

        this.signUpPage.submit();
        return multiValueResult
                .with("signUpResult", isAccountCreationServiceProcessSuccessfully(username, password))
                .with("errorMessage", "");
    }

    public boolean isRegistrationDataValid() {
        return !this.signUpPage.getErrorMessageEls().stream().anyMatch(WebElement::isDisplayed);
    }

    public boolean isAccountCreationServiceProcessSuccessfully(String username, String password) throws IOException {
        HttpEasyReader resp = this.bankAccountService.loginByApi(username, password);
        int code = resp.getResponseCode();
        String returnedUsername = resp.getJsonReader().jsonPath("user.username").getAsString();
        return code == 200 && returnedUsername.equalsIgnoreCase(username);
    }

}
