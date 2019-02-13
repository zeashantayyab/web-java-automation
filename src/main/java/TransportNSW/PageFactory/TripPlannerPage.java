package TransportNSW.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.HelperClass;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.NoSuchElementException;

public class TripPlannerPage {

    //final variables
    public String PAGE_TITLE = "Trip planner | transportnsw.info";
    public String PAGE_URL = "https://transportnsw.info/trip#/";

    //local webdriver variable
    WebDriver driver;

    @FindBy(xpath="//*[@id=\"search-input-From\"]")
    WebElement dropdownField_tripFrom;

    @FindBy(id="search-input-To")
    WebElement dropdownField_tripTo;


    @FindBy(xpath="//*[@id=\"tp-search-form\"]/div[2]/button")
    WebElement btn_ClearResult;

    @FindBy(id="btn-earlier")
    WebElement btn_earlierResults;

    @FindBy(id="btn-later")
    WebElement btn_laterResults;

    By listOfTripResults =By.xpath("//trip-summary[contains(@trip, \"trip\")]");
    By btn_GoTrip = By.xpath("//*[@id=\"search-button\"]");
    By firstResult = By.xpath("//*[@id=\"tripAnchor0\"]");
    By suggestionFrom = By.xpath("//*[@id=\"suggestions-From\"]");
    By suggestionTo = By.xpath("//*[@id=\"suggestions-To\"]");
    //-----------------------

    //Page Class Constructor
    public TripPlannerPage (WebDriver driver){
        this.driver = driver;
        //Create all webElement of this page
        PageFactory.initElements(driver, this);
    }

    //Action Methods
    public void setFromLocation(String fromLocation){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        dropdownField_tripFrom.clear();
        dropdownField_tripFrom.sendKeys(fromLocation);
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionFrom));
        dropdownField_tripFrom.sendKeys(Keys.ARROW_DOWN);
        dropdownField_tripFrom.sendKeys(Keys.ENTER);

    }

    public void setToLocation(String toLocation){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        dropdownField_tripTo.clear();
        dropdownField_tripTo.sendKeys(toLocation);
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionTo));
        dropdownField_tripTo.sendKeys(Keys.ARROW_DOWN);
        dropdownField_tripTo.sendKeys(Keys.ENTER);
    }

    public void pressGoButton(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_GoTrip));
        driver.findElement(btn_GoTrip).click();
    }

    public void enterTripLocations(String from_location, String to_location){

        setFromLocation(from_location);
        setToLocation(to_location);
        pressGoButton();

    }

    public void pressEarlierButton(){
        btn_earlierResults.click();
    }

    public void pressLaterButton(){
        btn_laterResults.click();
    }

    public boolean isTripResultsDisplayed(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(firstResult));
            System.out.println("No. of Results = "+ driver.findElements(listOfTripResults).size());
            if(driver.findElements(listOfTripResults).size()>0)
                return true;
            else
                return false;
        }catch (NoSuchElementException e ) {
            System.out.println("ERROR > Trip Plan Results Not Displayed  ");
            return false;
        }catch (Exception ex){
            return false;
        }

    }



}
