package mainMenuView;

import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.link.WebLink;

/**
 * Created by ioana.selegean on 7/4/2015.
 */
public class MainMenuView {
    private static Button preferencesButton = new Button().setText("Preferences");
    public static WebLink logout = new WebLink().setText("Logout");

    public static void logout(){
        logout.assertClick();
    }
}
