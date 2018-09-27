package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultSecondPage extends GoogleSearchBasePage{


    @FindBy (xpath = "//*[@id='resultStats']")
    private WebElement secondPageLocator;

    @FindBy(xpath = "//span[@class='st']")
    private List<WebElement> searchResults;

    public GoogleSearchResultSecondPage (WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public int searchSizeResult()  {
        return searchResults.size();
    }

    public List<String> getSearchResultList(){
        List<String> searchResultList = new ArrayList<String>();
        for (WebElement searchResults: searchResults) {
            ((JavascriptExecutor)driver).executeScript(
                    "arguments[0].scrollIntoView();", searchResults);
            searchResultList.add(searchResults.getText());
        }
        return searchResultList;}

    public boolean isPageLoaded() {
        return                getCurrentUrl().toLowerCase().contains("google.com/search?")
                && secondPageLocator.isDisplayed()
//                        .getText().toLowerCase().contains("сторінка 2")
                ;}


}
