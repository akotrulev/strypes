package ui;

import org.testng.annotations.Test;
import ui.pom.career.CareersPom;
import ui.pom.HomePagePom;
import ui.pom.career.VacancyInformationPom;
import ui.pom.career.VacancyPom;
import utility.CustomAssert;

public class CareersPageTest extends BaseUiTest {

    @Test
    public void userIsAbleToNavigateToViewAVacancy() {
        HomePagePom homePagePom = new HomePagePom(startDriver());
        CareersPom careersPom = homePagePom.navigationBarPom.clickCareersButton();
        VacancyPom vacancyPom = careersPom.getVacanciesList().get(4);

        String expectedJobTitle = vacancyPom.getVacancyName();
        VacancyInformationPom vacancyInformationPom = vacancyPom.clickViewButton();

        CustomAssert.areEqual(vacancyInformationPom.getJobTitle(), expectedJobTitle);
    }
}
