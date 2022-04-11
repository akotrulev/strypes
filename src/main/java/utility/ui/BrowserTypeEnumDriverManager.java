package utility.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.VoidDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.function.Consumer;
import java.util.function.Supplier;

public enum BrowserTypeEnumDriverManager {
    CHROME(BrowserType.CHROME, ChromeDriver::new, (WebDriverManager) -> io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup()),
    FIREFOX(BrowserType.FIREFOX, FirefoxDriver::new, (WebDriverManager) -> io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup()),
    IE(BrowserType.IE, InternetExplorerDriver::new, (WebDriverManager) -> io.github.bonigarcia.wdm.WebDriverManager.iedriver().setup()),
    EDGE(BrowserType.EDGE, EdgeDriver::new, (WebDriverManager) -> io.github.bonigarcia.wdm.WebDriverManager.edgedriver().browserVersion("98").setup()),
    SAFARI(BrowserType.SAFARI, SafariDriver::new, (WebDriverManager) -> io.github.bonigarcia.wdm.WebDriverManager.chromiumdriver().setup()),
    OPERA(BrowserType.OPERA_BLINK, OperaDriver::new, (WebDriverManager) -> io.github.bonigarcia.wdm.WebDriverManager.operadriver().setup());

    BrowserTypeEnumDriverManager(String browserType, Supplier<RemoteWebDriver> remoteWebDriver, Consumer<WebDriverManager> webDriverManagerConsumer) {
        this.browserType = browserType;
        this.remoteWebDriver = remoteWebDriver;
        this.webDriverManagerConsumer = webDriverManagerConsumer;
    }

    private String browserType;
    private Supplier<RemoteWebDriver> remoteWebDriver;
    private Consumer<WebDriverManager> webDriverManagerConsumer;

    public String getBrowserType() {

        return browserType;

    }

    public Consumer<WebDriverManager> getWebDriverManagerConsumer() {
        return webDriverManagerConsumer;

    }

    public RemoteWebDriver getRemoteWebDriver() {
        this.webDriverManagerConsumer.accept(new VoidDriverManager());
        RemoteWebDriver remoteWebDriver = this.remoteWebDriver.get();
        remoteWebDriver.manage().window().maximize();
        return remoteWebDriver;
    }
}
