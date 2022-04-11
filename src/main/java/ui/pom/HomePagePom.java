package ui.pom;

import org.openqa.selenium.WebDriver;

public class HomePagePom extends BasePageObject {
    public HomePagePom(WebDriver driver) {
        super(driver);
    }

    public NavigationBarPom navigationBarPom;
}
