package ui;

import org.testng.annotations.Test;
import ui.pom.career.CareersPom;
import ui.pom.HomePagePom;
import utility.CustomAssert;

public class HomePageTest extends BaseUiTest {

    @Test
    public void userIsAbleToNavigateToCareersPage() {
        HomePagePom homePagePom = new HomePagePom(startDriver());
        CareersPom careersPom = homePagePom.navigationBarPom.clickCareersButton();
        CustomAssert.isTrue(careersPom.getVacanciesCount()>=0);
    }
}
