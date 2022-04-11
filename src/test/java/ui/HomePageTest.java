package ui;

import org.testng.annotations.Test;
import ui.pom.HomePagePom;

public class HomePageTest extends BaseUiTest {

    @Test
    public void userIsAbleToNavigateToCareersPage() {

        HomePagePom homePagePom = new HomePagePom(startDriver());
        homePagePom.navigationBarPom.clickMediaButton();
    }
}
