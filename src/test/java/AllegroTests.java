import org.testng.annotations.Test;
import pages.ResultPage;
import pages.WelcomeAllegroPage;

public class AllegroTests extends BaseTest{


    @Test(groups = "welcome allegro")
    public void goToAllegroAndSearchItem(){
        WelcomeAllegroPage welcomeAllegroPage = new WelcomeAllegroPage( driver );
        welcomeAllegroPage.searchItem();
    }

    @Test(groups = "sorting", dependsOnMethods = "goToAllegroAndSearchItem")
    public void sortingItems(){
        ResultPage resultPage = new ResultPage( driver );
        resultPage.sortingItems();
    }

    @Test(groups = "choose item", dependsOnMethods = "sortingItems")
    public void chooseItem(){
        ResultPage resultPage = new ResultPage( driver );
        resultPage.chooseFirstItem();
    }

}
