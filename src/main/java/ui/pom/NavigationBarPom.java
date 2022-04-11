package ui.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.pom.career.CareersPom;

public class NavigationBarPom extends BasePageObject {

    protected final static By HOME_BUTTON = By.xpath("//a[@class='elementor-item elementor-item-active menu-link' and contains(text(), 'Home')]");
    protected final static By ABOUT_BUTTON = By.xpath("//a[@class='elementor-item menu-link has-submenu' and contains(text(), 'About')]");
    protected final static By SERVICES_BUTTON = By.xpath("//a[@class='elementor-item menu-link has-submenu' and contains(text(), 'Services')]");
    protected final static By CUSTOMERS_BUTTON = By.xpath("//a[@class='elementor-item elementor-item-active menu-link' and contains(text(), 'Customers')]");
    protected final static By NEARSURANCE_BUTTON = By.xpath("//a[@class='elementor-item elementor-item-active menu-link' and contains(text(), 'Nearsurance')]");
    protected final static By MEDIA_BUTTON = By.xpath("//a[@class='elementor-item menu-link' and contains(text(), 'Media')]");
    protected final static By CAREERS_BUTTON = By.xpath("//a[@class='elementor-item menu-link' and contains(text(), 'Careers')]");
    public NavigationBarPom(WebDriver driver) {
        super(driver);
    }

    public void clickHomeButton() {
        clickElement(HOME_BUTTON);
    }

    public void clickAboutButton() {
        clickElement(ABOUT_BUTTON);
    }
    public void clickServicesButton() {
        clickElement(SERVICES_BUTTON);
    }

    public void clickCustomersButton() {
        clickElement(CUSTOMERS_BUTTON);
    }

    public void clickNearsuranceButton() {
        clickElement(NEARSURANCE_BUTTON);
    }

    public void clickMediaButton() {
        clickElement(MEDIA_BUTTON);
    }

    public CareersPom clickCareersButton() {
        clickElement(CAREERS_BUTTON);
        return new CareersPom(webDriver);
    }
}