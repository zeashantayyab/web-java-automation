package TransportNSW.Tests;

import TransportNSW.PageFactory.LoginPage;
import Utilities.DriverFactory;
import Utilities.DriverFactory.browserType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

//    Scenario: A trip request can be executed and results returned
//    Given Phileas is planning a trip
//    When he executes a trip plan from "North Sydney Station" to "Town Hall Station"
//    Then a list of trips should be provided

public class LoginPageTest {

    WebDriver driver;
    browserType type = browserType.CHROME;
    LoginPage loginPageObj;

    @Before
    public void setup() {

        driver = DriverFactory.getDriver(type);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPageObj = new LoginPage(driver);

    }

    @After
    public void teardown() {
        driver.quit();
    }


    @Test
    public void verifylogin_credentials() {

        driver.get(loginPageObj.PAGE_URL);
        //Enter Trip From and To Location and Press Go Button
        loginPageObj.enterLoginCredentials("shm01", "12345678");

        loginPageObj.isLoginResultsDisplayed();


        driver.close();
    }
}