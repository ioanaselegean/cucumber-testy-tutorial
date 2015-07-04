package org.fasttrackit.workshop.login;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginView {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginView.class);

    private Button loginButtonEl = new Button().setId("loginButton");

    private TextField emailEl = new TextField().setId("email");

    private TextField passEl = new TextField().setId("password");

    private WebLocator errorEl = new WebLocator().setClasses("error-msg");

    public void clickOnLoginButton() {
        loginButtonEl.click();
    }

    public void enterCredentials(String emailVal, String passVal) {
        emailEl.sendKeys(emailVal);
        passEl.sendKeys(passVal);
    }

    public void CheckErrorMessage(String msg) {
        assertThat("", errorEl.getHtmlText(), is(msg));
        Utils.sleep(1000);
    }
}
