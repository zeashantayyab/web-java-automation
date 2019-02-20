import Emirates.PageFactory.StorePage;
import Emirates.PageFactory.OrderCheckoutPage;

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
    OrderCheckoutPage orderCheckoutPageObj;

    @Before
    public void setup(){

        driver = DriverFactory.getDriver(type);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        storePageObj = new StorePage(driver);
        orderCheckoutPageObj = new OrderCheckoutPage(driver);

    }

    @After
    public void teardown(){
        driver.quit();
    }


//    @Test
    public void createAccount_Results(){

        driver.get(storePageObj.PAGE_URL);
        storePageObj.ClickSign();
        storePageObj.CreateAcc("zeashan.tayyyab@gmail.com");
        storePageObj.ClickCreateButn();
        storePageObj.ClickMrCheckbox();
        storePageObj.firstname("Zeashan");
        storePageObj.setLastname1("Tayyab");
        storePageObj.setEmail_id1("zeashan.tayyab@gmail.com");
        storePageObj.SetDateOfBirth("1","6", "2000");



        System.out.println(">>>> Successfully Displayed the Now Trip Results ");


        driver.close();
    }

    //I will got to Woman page, select item, Checkout > Land  on Checkout page
    //i will verify the total amount by unitprice * Qty
    @Test
    public void VerifyTotalAmountOnCheckoutPage(){

        driver.get(orderCheckoutPageObj.PAGE_URL);
        System.out.println("title"+orderCheckoutPageObj.PAGE_TITLE);
        assertTrue(driver.getTitle().equals(orderCheckoutPageObj.PAGE_TITLE));

        orderCheckoutPageObj.Go();

        System.out.println(">>>> Successfully Displayed Woman Page ");


        driver.close();
    }
}
