package org.fasttrackit.workshop.Preferences;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.link.WebLink;
import com.sdl.selenium.web.table.Table;
import com.sdl.selenium.web.table.TableCell;
import com.sdl.selenium.web.table.TableRow;
import com.sdl.selenium.web.utils.Utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ioana.selegean on 7/4/2015.
 */
public class PreferencesView {
private WebLocator preferencesWindow = new WebLocator().setId("preferences-win");
    private Button preferencesButtonEl = new Button().setText("Preferences");
    private Button saveButtonEl = new Button().setText("Save").setContainer(preferencesWindow);
    private Button closeButtonEl = new Button().setText("Close").setContainer(preferencesWindow);
    private WebLink logoutButtonEl = new WebLink().setText("Logout").setContainer(preferencesWindow);
    //private TextField currentPassEl = new TextField().setElPath("//label[text()='Current Password']//following-sibling::*//input");
    private TextField currentPassEl = new TextField(preferencesWindow).setLabel("Current Password");
    private TextField newPassEl = new TextField(preferencesWindow).setLabel("New Password");
    private TextField confirmNewPassEl = new TextField(preferencesWindow).setLabel("Repeat Password");
    private WebLocator msgEl = new WebLocator(preferencesWindow).setClasses("status-msg");

    public static void main(String args[])
    {
        PreferencesView pv = new PreferencesView();
        //System.out.println(pv.preferencesWindow.getPath());
        //System.out.println(pv.saveButtonEl.getPath());
        //System.out.println(pv.closeButtonEl.getPath());
        //System.out.println(pv.msgEl.getPath());

        Table table = new Table();
        TableRow row = table.getRow(
                new TableCell(2, "Peter"),
                new TableCell(3, "Parker")
        );
        Button editButton = new Button(row, "Second");
        //Button remove = new Button(row, "Remove", SearchType.CHILD_NODE);
        System.out.println(editButton.getPath());
    }

    public void open() {
        preferencesButtonEl.click();
        //fading preferences window
        Utils.sleep(500);
    }

    public void typeCurrentPassword(String validOldPass) {
        currentPassEl.setValue(validOldPass);
    }

    public void typeNewPassword(String validNewpass) {
        newPassEl.setValue(validNewpass);
    }

    public void typeConfirmNewPassword(String validNewpass) {
        confirmNewPassEl.setValue(validNewpass);
    }

    public void save() {
        saveButtonEl.assertClick();
    }

    public void close() {
        closeButtonEl.assertClick();
    }

    public void checkMessage(String msg) {
        assertThat("", msgEl.getHtmlText(), is(msg));
    }

    public void logOut() {
        logoutButtonEl.click();
    }
}
