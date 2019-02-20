package Emirates.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class OrderCheckoutPage {

    //final variables
    public static final String PAGE_TITLE = "Women - My Store";
    public static final String PAGE_URL = "http://automationpractice.com/index.php?id_category=3&controller=category";

    //local webdriver variable
    WebDriver driver;
    By linkTop = By.xpath("//*[@id='subcategories']/ul/li[1]/h5/a");
    By top = By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]");
    By Blouses= By. xpath("//*[@id='subcategories']/ul/li[2]/div[1]/a/img)");



    //Page Class Constructor
    public OrderCheckoutPage(WebDriver driver) {
        this.driver = driver;
        //Create all webElement of this page
        //PageFactory.initElements(driver, this);
    //-----------------------

    }

    public void Go (){
        try{
            driver.findElement(linkTop).click();
            driver.findElement(linkTop).isDisplayed();
            TimeUnit.SECONDS.sleep(5);
            driver.findElement(top).click();
            driver.findElement(top).isDisplayed();
            TimeUnit.SECONDS.sleep(5);

//           Mouse hover https://stackoverflow.com/questions/17293914/how-to-perform-mouseover-function-in-selenium-webdriver-using-java
       //     Actions action = new Actions(driver);
         //   WebElement we = webdriver.findElement(By.xpath("html/body/div[13]/ul/li[4]/a"));
          //  action.moveToElement(we).moveToElement(webdriver.findElement(By.xpath("/expression-here"))).click().build().perform();

        }
        catch (Exception ex) {


        }



    }

}
