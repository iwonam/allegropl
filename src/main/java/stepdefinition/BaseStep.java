package stepdefinition;

import helpers.DriverFactory;
import model.DriverType;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class BaseStep {

    protected WebDriver driver;

    public void setUpTest(){
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getSpecificDriver( DriverType.CHROME );
        driver.manage().timeouts().pageLoadTimeout( 10, TimeUnit.SECONDS );
    }

    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
