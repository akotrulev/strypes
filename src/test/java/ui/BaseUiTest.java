package ui;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utility.ui.BrowserTypeEnumDriverManager;
import utility.ui.constant.SystemPropertyNames;

import java.util.LinkedList;
import java.util.Queue;

public class BaseUiTest {
    protected static BrowserTypeEnumDriverManager browserType;
    protected static Queue<WebDriver> queueToClose;

    @BeforeSuite
    public void createWebDrivers(ITestContext iTestContext) {
        // If base url is not set, default to prod url
        if (System.getProperty(SystemPropertyNames.BASE_UI_URL) == null) {
            System.setProperty(SystemPropertyNames.BASE_UI_URL, "");
        }

        // If browser type is not set, default to Chrome
        if (System.getProperty(SystemPropertyNames.BROWSER_TYPE) == null) {
            System.setProperty(SystemPropertyNames.BROWSER_TYPE, BrowserTypeEnumDriverManager.EDGE.name());
        }

        // Get and store the browser type
        browserType = BrowserTypeEnumDriverManager.valueOf(System.getProperty(SystemPropertyNames.BROWSER_TYPE));

        queueToClose = new LinkedList<>();
    }

    public WebDriver startDriver() {

        WebDriver driver = browserType.getRemoteWebDriver();
        queueToClose.add(driver);
        return driver;
    }

    @AfterSuite
    public void closeAllDrivers() {
        queueToClose.forEach(WebDriver::quit);
    }
}