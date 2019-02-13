package Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public enum browserType {
        FIREFOX,
        CHROME,
        IE,     //not implemented
        SAFARI  //not implemented
    }
    public static WebDriver getDriver(browserType type){
        WebDriver driver = null;
        String pathOfDrivers = System.getProperty("user.dir")+"/src/main/resource/";

        switch (type){
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", pathOfDrivers+"geckodriver");
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", pathOfDrivers+"chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", pathOfDrivers+"chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}
