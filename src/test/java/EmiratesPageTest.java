import Emirates.PageFactory.BookFlightPage;
import Utilities.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import Utilities.DriverFactory.browserType;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class EmiratesPageTest {

    WebDriver driver;
    DriverFactory.browserType type = browserType.CHROME;
    BookFlightPage bookFlightPageObj;

    @Before
    public void setup(){

        driver = DriverFactory.getDriver(type);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        bookFlightPageObj = new BookFlightPage(driver);

    }

    @After
    public void teardown(){
        driver.quit();
    }


    @Test
    public void VerifyTripPlanner_Results(){

        driver.get(bookFlightPageObj.PAGE_URL);
        //Enter Trip From and To Location and Press Go Button
        bookFlightPageObj.EnterTripDetail("Lahore (LHE)","Dubai (DXB)");



        System.out.println(">>>> Successfully Displayed the Now Trip Results ");


        driver.close();
    }

}
