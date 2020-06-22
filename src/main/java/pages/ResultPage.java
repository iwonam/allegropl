package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ResultPage extends BasePage {

    protected WebDriverWait wait;
    String sortingValue = " cena: od najwyższej ";

    public ResultPage(WebDriver driver) {
        super( driver );
        wait = new WebDriverWait(driver, 7);
    }

    @FindBy(xpath = "//select[@data-value = 'm']")
    WebElement dropdownSort;

    @FindBy(xpath = "//*[text() = 'używane']/ancestor::li//label")
    WebElement usedItemCheckbox;

    @FindBy(xpath = "(//h2[@class = '_9c44d_LUA1k']//a)[1]")
    WebElement firstItem;

    @FindBy(xpath = "//h1[@class = '_9a071_1Ux3M _9a071_3nB-- _9a071_1R3g4 _9a071_1S3No']")
    WebElement chooseItem;


    public ResultPage sortingItems(){
        Select sortItem = new Select( dropdownSort );
        sortItem.selectByVisibleText( sortingValue );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript( "window.scrollBy(0,250)" );
        wait.until( ExpectedConditions.elementToBeClickable( usedItemCheckbox ) ).click();
        js.executeScript( "window.scrollBy(0,0)" );
        return this;
    }

    public String chooseFirstItem(){
        String item = firstItem.getAttribute( "innerText" );
        wait.until( ExpectedConditions.elementToBeClickable( firstItem ) ).click();
        wait.until( ExpectedConditions.visibilityOf( chooseItem ) );
        getItemName();
        return item;
    }

    public String getItemName(){
        return chooseItem.getAttribute( "innerText" );
    }

}
