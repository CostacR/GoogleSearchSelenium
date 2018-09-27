package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultFirstPage extends GoogleSearchBasePage{

    @FindBy (xpath = "//div[@id='resultStats']")
    private WebElement searchResultTextField;

    @FindAll(
            {
                    @FindBy(xpath = "//*[@id='rso']/div[1]/div/div[1]/div/div[1]"),
                    @FindBy(xpath = "//span[@class='st']")
            })
    private List<WebElement> searchResults;

    @FindBy (xpath = "//*[@id='pnnext']/span[2]")
    WebElement secondSearchPageButton;


    public GoogleSearchResultSecondPage nextButtonClick(){
        secondSearchPageButton.click();
        return new GoogleSearchResultSecondPage(driver);
    }

    public GoogleSearchResultFirstPage(WebDriver driver) {
            this.driver=driver;
            PageFactory.initElements(driver, this);
        }

    public int searchSizeResult()  {
        System.out.println(searchResults.size());
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
        return getCurrentUrl().toLowerCase().contains("google.com/search?")
                && searchResultTextField.getText().contains("результатів")
                ;}
}
