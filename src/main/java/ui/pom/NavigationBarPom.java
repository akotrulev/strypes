package ui.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBarPom extends BasePageObject {

    public final static By HOME_BUTTON = By.xpath("//a[@class='elementor-item elementor-item-active menu-link' and contains(text(), 'Home')]");
    public final static By ABOUT_BUTTON = By.xpath("//a[@class='elementor-item menu-link has-submenu' and contains(text(), 'About')]");
    public final static By SERVICES_BUTTON = By.xpath("//a[@class='elementor-item menu-link has-submenu' and contains(text(), 'Services')]");
    public final static By CUSTOMERS_BUTTON = By.xpath("//a[@class='elementor-item elementor-item-active menu-link' and contains(text(), 'Customers')]");
    public final static By NEARSURANCE_BUTTON = By.xpath("//a[@class='elementor-item elementor-item-active menu-link' and contains(text(), 'Nearsurance')]");
    public final static By MEDIA_BUTTON = By.xpath("//a[@class='elementor-item menu-link' and contains(text(), 'Media')]");
    public final static By CAREERS_BUTTON = By.xpath("//a[@class='elementor-item menu-link' and contains(text(), 'Careers')]");
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

    public void clickCareersButton() {
        clickElement(CAREERS_BUTTON);
    }
}