package ui.pom;

import org.openqa.selenium.WebDriver;
import utility.ui.constant.SystemPropertyNames;

public class HomePagePom extends BasePageObject {
    public HomePagePom(WebDriver driver) {
        super(driver);
        navigationBarPom = new NavigationBarPom(driver);
        footerPom = new FooterPom(driver);
        navigateToUrl(System.getProperty(SystemPropertyNames.BASE_UI_URL));
    }

    public NavigationBarPom navigationBarPom;
    public FooterPom footerPom;
}
