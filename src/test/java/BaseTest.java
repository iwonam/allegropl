import helpers.DriverFactory;
import model.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUpTest(){
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getSpecificDriver( DriverType.CHROME );
        driver.manage().timeouts().pageLoadTimeout( 10, TimeUnit.SECONDS );
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
