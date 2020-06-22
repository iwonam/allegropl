package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import model.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

    public  WebDriver driver;
    String url = "https://allegro.pl/";

    public WebDriver getSpecificDriver(DriverType driverType) {

            switch (driverType) {
                case CHROME:
                    return getChromeDriver();
                case FIREFOX:
                    return getFirefoxDriver();
                default:
                    throw new IllegalArgumentException( "Browser doesn't exist" );
            }
    }

    private WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to( url );
        return driver;
    }

    private WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to( url );
        return driver;
    }
}
