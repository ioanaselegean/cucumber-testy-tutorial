package org.fasttrackit.workshop.pagefactory.login;

import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(how = How.ID, using = "loginButton")
    private WebElement loginButtonEl;

    @FindBy(how = How.ID, using = "email")
    private WebElement emailEl;

    @FindBy(how = How.ID, using = "password")
    private WebElement passEl;
/*
    @FindBy(how = How.ID, using = "Logout")
    private WebElement logoutButtonEl;
*/
    @FindBy(how = How.CLASS_NAME, using = "error-msg")
    private WebElement errorEl;

    public void clickOnLoginButton() {
        loginButtonEl.click();
    }

    public void enterCredentials(String emailVal, String passVal) {
        emailEl.sendKeys(emailVal);
        passEl.sendKeys(passVal);
    }
/*
    public void checkUserLogIn() {
        boolean successfulLogin = false;
        try {
            successfulLogin = logoutButtonEl.isDisplayed();
        } catch (Exception e) {

        }
        assertThat("Could not find logout button", successfulLogin, is(true));
    }
    */

    public void CheckErrorMessage(String msg) {
        assertThat(errorEl.getText(), is(msg));
        Utils.sleep(4000);
    }
}
