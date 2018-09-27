package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchMainPage extends GoogleSearchBasePage{
    @FindBy (xpath = "//input[@id='lst-ib']")
    private WebElement searchItemField;

    public GoogleSearchMainPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public <T> T search (String searchItem){
        searchItemField.sendKeys(searchItem);
        searchItemField.sendKeys(Keys.ENTER);

        if (isUrlContains("/search", 5)) {
            return (T) new GoogleSearchResultFirstPage(driver);
        }
        else return (T) new GoogleSearchMainPage(driver);

    }

    public boolean isPageLoaded() {
        return getCurrentUrl().toLowerCase().contains("https://www.google.com/")
                && getCurrentTitle().toLowerCase().contains("google")
                ;}
}
