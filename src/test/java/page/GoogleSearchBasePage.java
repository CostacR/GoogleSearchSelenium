package page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchBasePage {
    protected WebDriver driver;


    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    protected String getCurrentTitle() {
        return driver.getTitle();
    }

    protected boolean isUrlContains(String partiaUrl, int timeOutInSec){//ожидает когда Url будет совпадать с заданым, после этого True/false
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        try {
            return wait.until(ExpectedConditions.urlContains(partiaUrl));
        }catch (TimeoutException e){
            return false;
        }



    }

}
