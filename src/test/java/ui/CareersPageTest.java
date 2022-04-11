package ui;

import org.testng.annotations.Test;
import ui.pom.CareersPom;
import ui.pom.HomePagePom;
import utility.CustomAssert;

public class CareersPageTest extends BaseUiTest {

    @Test
    public void userIsAbleToNavigateToViewAVacancy() {
        HomePagePom homePagePom = new HomePagePom(startDriver());
        CareersPom careersPom = homePagePom.navigationBarPom.clickCareersButton();
        careersPom.getVacanciesList()
    }
}
