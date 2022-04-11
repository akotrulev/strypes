package ui.pom.career;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.pom.BasePageObject;
import ui.pom.NavigationBarPom;

import java.util.ArrayList;
import java.util.List;

public class CareersPom extends BasePageObject {

    protected final static By VACANCIES = By.cssSelector("article.elementor-post");
    public NavigationBarPom navigationBarPom;

    public CareersPom(WebDriver driver) {
        super(driver);
        navigationBarPom = new NavigationBarPom(driver);

    }

    public List<VacancyPom> getVacanciesList() {
        ArrayList<VacancyPom> vacancyPomArrayList = new ArrayList<>();
        //Starts form 1 since xpath positions start form there
        for (int i = 1; i <= findElementsByLocator(VACANCIES).size(); i++) {
            vacancyPomArrayList.add(new VacancyPom(webDriver, i));
        }

        return vacancyPomArrayList;
    }

    public int getVacanciesCount() {
        return findElementsByLocator(VACANCIES).size();
    }
}
