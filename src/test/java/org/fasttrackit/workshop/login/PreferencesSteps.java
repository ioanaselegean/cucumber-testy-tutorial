package org.fasttrackit.workshop.login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.workshop.Preferences.PreferencesView;

/**
 * Created by ioana.selegean on 7/4/2015.
 */
public class PreferencesSteps extends TestBase {
    private PreferencesView preferencesView = new PreferencesView();
    public static String VALID_NEWPASS = "eupass";

    @When("^I click Preferences button$")
    public void I_click_Preferences_button() {
       preferencesView.open();
    }

    @And("^I input current password$")
    public void I_input_current_password()  {
        preferencesView.typeCurrentPassword(LoginSteps.VALID_PASS);
    }

    @And("^I input new password$")
    public void I_input_new_password() {
        preferencesView.typeNewPassword(VALID_NEWPASS);
    }

    @And("^I confirm new password$")
    public void I_confirm_new_password() {
        preferencesView.typeConfirmNewPassword(VALID_NEWPASS);
    }

    @And("^I click save button$")
    public void I_click_save_button() {
        preferencesView.save();
    }

    @And("^I close Preferences window$")
    public void I_close_Preferences_window() {
       preferencesView.close();
    }

    @Then("^I expect change password message \"([^\"]*)\"$")
    public void I_expect_change_password_message(String msg) throws Throwable {
        preferencesView.checkMessage(msg);
        LoginSteps.VALID_PASS = VALID_NEWPASS;
    }

    @And("^I logout$")
    public void I_logout() {
        preferencesView.logOut();
    }
}
