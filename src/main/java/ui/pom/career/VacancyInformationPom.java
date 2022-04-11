package ui.pom.career;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.pom.BasePageObject;

public class VacancyInformationPom extends BasePageObject {
    protected final static By TITLE = By.cssSelector("h1.elementor-heading-title");

    public VacancyInformationPom(WebDriver webDriver) {
        super(webDriver);
    }

    public String getJobTitle() {
        return getElementText(TITLE);
    }
}
