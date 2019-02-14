import Emirates.PageFactory.StorePage;
import Utilities.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import Utilities.DriverFactory.browserType;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class StorePageTest {

    WebDriver driver;
    DriverFactory.browserType type = browserType.CHROME;
    StorePage storePageObj;

    @Before
    public void setup(){

        driver = DriverFactory.getDriver(type);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        storePageObj = new StorePage(driver);

    }

    @After
    public void teardown(){
        driver.quit();
    }


    @Test
    public void VerifyTripPlanner_Results(){

        driver.get(storePageObj.PAGE_URL);
        //Enter Trip From and To Location and Press Go Button
        storePageObj.ClickSign();



        System.out.println(">>>> Successfully Displayed the Now Trip Results ");


        driver.close();
    }

}
