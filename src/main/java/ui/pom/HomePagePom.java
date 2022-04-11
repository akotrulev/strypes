package ui.pom;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class HomePagePom extends BasePageObject {
    public HomePagePom(WebDriver driver) {
        super(driver);
        navigationBarPom = new NavigationBarPom(driver);
        footerPom = new FooterPom(driver);
        goToBasePage();

        //Add cookies to remove welcome and gdpr consent pop-ups
        ArrayList<Cookie> cookieList = new ArrayList<>();
        cookieList.add(new Cookie("gdprc_permissionbar_1", "0"));
        cookieList.add(new Cookie("hs-messages-hide-welcome-message", "true"));
        addCookieToBrowser(cookieList);
    }

    public NavigationBarPom navigationBarPom;
    public FooterPom footerPom;
}
