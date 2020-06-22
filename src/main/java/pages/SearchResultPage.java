package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasePage {

    protected WebDriverWait wait;
    String sortingValue = " cena: od najwyższej ";

    public SearchResultPage(WebDriver driver) {
        super( driver );
        wait = new WebDriverWait(driver, 7);
    }

    @FindBy(xpath = "//select[@class='_1h7wt _k70df _7qjq4 _27496_3VqWr']")
    WebElement dropdownSort;

    @FindBy(xpath = "//*[text() = 'używane']/ancestor::li//label")
    WebElement usedItemCheckbox;

    @FindBy(xpath = "//div[@class = '_9c44d_378hD _9c44d_3TOu4']")
    WebElement loadingState;

    @FindBy(xpath = "//div[@class = '_9c44d_378hD']")
    WebElement normalState;

    @FindBy(xpath = "//section[@class = '_9c44d_3UJEh']//h2[@class = '_9c44d_LUA1k']//a[1]")
    WebElement firstItem;

    @FindBy(xpath = "//h1[@class = '_9a071_1Ux3M _9a071_3nB-- _9a071_1R3g4 _9a071_1S3No']")
    WebElement chooseItem;


    public SearchResultPage sortSearchResult(){
        wait.until(ExpectedConditions.visibilityOf(dropdownSort));
        Select sortItem = new Select( dropdownSort );
        sortItem.selectByVisibleText( sortingValue );
        return this;
    }

    public SearchResultPage filterSearchResult(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript( "window.scrollBy(0,250)" );
        wait.until( ExpectedConditions.elementToBeClickable( usedItemCheckbox ) ).click();
        js.executeScript( "window.scrollBy(0,0)" );
        return this;
    }

    public String clickFirstPromotedItem(){
        wait.until(ExpectedConditions.visibilityOf(loadingState));
        wait.until(ExpectedConditions.visibilityOf(normalState));
        String item = firstItem.getAttribute( "innerText" );
        wait.until( ExpectedConditions.elementToBeClickable( firstItem ) ).click();

        return item;
    }

    public String checkItemName(){
        wait.until( ExpectedConditions.visibilityOf( chooseItem ) );
        return chooseItem.getAttribute( "innerText" );
    }

}