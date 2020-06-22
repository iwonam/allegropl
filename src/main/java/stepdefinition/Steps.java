package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import pages.HomePage;
import pages.SearchResultPage;

public class Steps extends BaseStep {

    HomePage homePage;
    SearchResultPage resultPage;
    String firstPromotedItemName;

    @Given("^Open Chrome and go to Allegro$")
    public void open_Chrome_and_go_to_Allegro() throws Throwable {
        setUpTest();
    }

    @When("^Enter the search phrase \"(.*)\"$")
    public void enterSearchPhrase(String searchPhrase) throws Throwable {
        homePage = new HomePage(driver);
        homePage.searchItem(searchPhrase);
    }

    @And("^Click the search button$")
    public void clickSearchBtn() throws Throwable {
        homePage.clickSearchBtn();
    }

    @Then("^Sort the search result$")
    public void sortSearchResult() throws Throwable {
        resultPage = new SearchResultPage(driver);
        resultPage.sortSearchResult();
    }

    @Then("^Filter the search result$")
    public void filterSearchResult() throws Throwable {
        resultPage.filterSearchResult();
    }

    @Then("^Click on the first promoted item$")
    public void clickFirstPromotedItem() throws Throwable {
        firstPromotedItemName = resultPage.clickFirstPromotedItem();
    }

    @Then("^Check the item name$")
    public void checkPageName() throws Throwable {
        Assert.assertEquals(firstPromotedItemName, resultPage.checkItemName());
        tearDown();
    }
}
