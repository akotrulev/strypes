package ui.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CareersPom extends BasePageObject {

    public final static By VACANCIES = By.cssSelector("article.elementor-post");
    public NavigationBarPom navigationBarPom;

    public CareersPom(WebDriver driver) {
        super(driver);
        navigationBarPom = new NavigationBarPom(driver);

    }

    public List<WebElement> getVacanciesList() {
        return findElementsByLocator(VACANCIES);
    }

    public int getVacanciesCount() {
        return getVacanciesList().size();
    }
}
