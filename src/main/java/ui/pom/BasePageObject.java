package ui.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import utility.ui.constant.SystemPropertyNames;

import java.util.List;

/**
 * Every page object will inherit this class, giving it access to it's methods. First PO class initialisation
 * the Webdriver will be parsed via constructor
 */
public class BasePageObject {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    private String baseUrl;

    public BasePageObject(WebDriver webDriver) {
        baseUrl = System.getProperty(SystemPropertyNames.BASE_UI_URL);
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 15, 50);
    }

    public void goToBasePage() {
        Reporter.log("Opening home page " + baseUrl);
        webDriver.get(baseUrl);
    }

    public void navigateToUrl(String url) {
        Reporter.log("Opening home page " + url);
        webDriver.get(url);
    }

    protected String getElementText(WebElement element) {
        Reporter.log("Getting text from element " + element.getTagName() + "and trimming white spaces");
        return element.getText().trim();
    }

    protected void writeText(WebElement element, String text) {
        Reporter.log("Clearing text from " + element.getTagName());
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        ExpectedCondition<Boolean> elementTextEqualsString = arg0 -> element.getText().equals("");
        webDriverWait.until(elementTextEqualsString);
        Reporter.log("Writing text " + text + " to element " + element.getTagName());
        element.sendKeys(text);
    }

    protected void clickElement(WebElement element) {
        Reporter.log("Clicking element " + element.getTagName());
        element.click();
    }

    public void quitDriver() {
        webDriver.quit();
    }

    protected WebElement findElementByLocator(By locator) {
        waitForElementWithLocator(locator);
        return webDriver.findElement(locator);
    }

    protected List<WebElement> findElementsByLocator(By locator) {
        waitForElementWithLocator(locator);
        return webDriver.findElements(locator);
    }

    protected void waitForElementWithLocator(By locator) {
        Reporter.log("Waiting for presence of element " + locator.toString());
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Reporter.log("Waiting for visibility of element " + locator.toString());
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected boolean elementIsVisible(By locator) {
        try {
            Reporter.log("Waiting for visibility of element " + locator.toString());
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    protected void waitForElement(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 15, 50);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void addCookieToBrowser(Cookie cookie) {
        goToBasePage();
        webDriver.manage().addCookie(cookie);
        webDriver.navigate().refresh();
    }

    public void scrollDown(WebElement webElement) {
        webElement.sendKeys(Keys.PAGE_DOWN);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}

