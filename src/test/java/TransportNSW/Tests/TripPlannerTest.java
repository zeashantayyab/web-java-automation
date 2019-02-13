package TransportNSW.Tests;

import Utilities.*;
import TransportNSW.PageFactory.TripPlannerPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import Utilities.DriverFactory.browserType;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

//    Scenario: A trip request can be executed and results returned
//    Given Phileas is planning a trip
//    When he executes a trip plan from "North Sydney Station" to "Town Hall Station"
//    Then a list of trips should be provided

public class TripPlannerTest {

    WebDriver driver;
    DriverFactory.browserType type = browserType.CHROME;
    TripPlannerPage tripPlannerPage;

    @Before
    public void setup(){

        driver = DriverFactory.getDriver(type);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tripPlannerPage = new TripPlannerPage(driver);

    }

    @After
    public void teardown(){
        driver.quit();
    }


    @Test
    public void VerifyTripPlanner_NowResults(){

        driver.get(tripPlannerPage.PAGE_URL);
        //Enter Trip From and To Location and Press Go Button
        tripPlannerPage.enterTripLocations("North Sydney Station","Town Hall Station");

        assertTrue(tripPlannerPage.isTripResultsDisplayed());

        System.out.println(">>>> Successfully Displayed the Now Trip Results ");


        driver.close();
    }
    @Test
    public void VerifyTripPlanner_EarlierResults(){

        driver.get(tripPlannerPage.PAGE_URL);
        //Enter Trip From and To Location and Press Go Button
        tripPlannerPage.enterTripLocations("North Sydney Station","Town Hall Station");
        tripPlannerPage.pressEarlierButton();
        assertTrue(tripPlannerPage.isTripResultsDisplayed());

        System.out.println(">>>> Successfully Displayed the Earlier Trip Results");


        driver.close();
    }

    @Test
    public void VerifyTripPlanner_LaterResults(){

        driver.get(tripPlannerPage.PAGE_URL);
        //Enter Trip From and To Location and Press Go Button
        tripPlannerPage.enterTripLocations("North Sydney Station","Town Hall Station");
        tripPlannerPage.pressLaterButton();
        assertTrue(tripPlannerPage.isTripResultsDisplayed());

        System.out.println(">>>> Successfully Displayed the Later Trip Results");


        driver.close();
    }
}
