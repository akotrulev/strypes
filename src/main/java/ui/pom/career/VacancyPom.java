package ui.pom.career;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.pom.BasePageObject;

public class VacancyPom extends BasePageObject {
    protected static final String TITLE = "(//h2/a[starts-with(@href, 'https://strypes.eu/jobs/')])[%s]";
    protected static final String VIEW_BUTTON = "(//span/span[@class='elementor-button-text' and contains(text(), 'View')])[%s]";

    private int position;
    public VacancyPom(WebDriver driver, int position) {
        super(driver);
        this.position = position;
    }

    public VacancyInformationPom clickViewButton() {
        clickElement(By.xpath(String.format(VIEW_BUTTON, position)));
        return new VacancyInformationPom(webDriver);
    }

    public String getVacancyName() {
        return getElementText(By.xpath(String.format(TITLE, position)));
    }
}
