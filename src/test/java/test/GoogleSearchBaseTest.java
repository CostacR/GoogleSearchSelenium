package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import page.GoogleSearchMainPage;


public class GoogleSearchBaseTest {
    WebDriver driver;
    GoogleSearchMainPage googleSearchMainPage;

    @Parameters({"browserName", "urLink"})

    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browserName,
                             @Optional ("https://www.google.com/") String urLink) throws Exception {

        switch (browserName.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new Exception("browser "+browserName+" is not supported") ;
        }

        driver.get(urLink);
        googleSearchMainPage = new GoogleSearchMainPage(driver);

    }
    @AfterMethod (alwaysRun = true)
    public void afterMethod (){
//        driver.quit();
    }
}
