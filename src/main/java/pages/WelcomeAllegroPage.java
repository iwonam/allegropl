package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomeAllegroPage extends BasePage{

    protected WebDriverWait wait;
    String searchItemValue = "iPhone";

    public WelcomeAllegroPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 5);
    }

    @FindBy(xpath = "//*[ @data-role= 'close-and-accept-consent']")
    WebElement closeAndAcceptContent;

    @FindBy(xpath = "//*[@type = 'search']")
    WebElement searchInput;

    @FindBy(xpath = "//*[@data-role = 'search-button']")
    WebElement searchButton;

    public WelcomeAllegroPage searchItem(){
        wait.until( ExpectedConditions.elementToBeClickable( closeAndAcceptContent ) ).click();
        wait.until(ExpectedConditions.visibilityOf( searchInput)).sendKeys( searchItemValue );
        wait.until( ExpectedConditions.elementToBeClickable( searchButton ) ).submit();
        return this;
    }
}
