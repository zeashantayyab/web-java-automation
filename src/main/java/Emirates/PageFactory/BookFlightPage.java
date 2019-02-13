package Emirates.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class BookFlightPage {

    //final variables
    public static final String PAGE_TITLE = "Cargo Security";
    public static final String PAGE_URL = "https://www.emirates.com/";

    //local webdriver variable
    WebDriver driver;

    By Departure_Airport = By.xpath("//input[@name='Departure airport'][0]");
    By btn_Continue = By.xpath("//*[@id='panel0']/div/div/div/section/div[4]/div[1]/div[4]/a");//*[@id="panel0"]/div/div/div/section/div[4]/div[1]/div[4]/a  //*[@id="71226ce4-cf9c-4a87-8385-2869f42bf166"]
    By Arrival_Airport = By.xpath("//input[@name='Arrival airport'][0]");
    By bookingform = By.xpath("//*[@id='panel0']/div/div/div/section/div[1]/div/div[1]");///div/div/form");//*[@id="panel0"]/div/div/div/section/div[1]/div/div[1]
    //-----------------------

    //Page Class Constructor
    public BookFlightPage(WebDriver driver){
        this.driver = driver;
        //Create all webElement of this page
//        PageFactory.initElements(driver, this);
    }

    //Action Methods
    private void SetDepField(String deptfield){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(Departure_Airport));


            driver.findElement(Departure_Airport).click();
            driver.findElement(Departure_Airport).sendKeys(deptfield);
        }
        catch(NoSuchElementException nse){
            System.out.println("Not Found - "+ bookingform);
        }

    }

    private void SetArrivalField(String arrivalField) {
        driver.findElement(Arrival_Airport).sendKeys(arrivalField);
    }

    private void PressBtnCountine() {
        driver.findElement(btn_Continue).click();
    }

    public void EnterTripDetail(String enter_dept, String enter_arrival){

        SetDepField(enter_dept);
        SetArrivalField(enter_arrival);
        PressBtnCountine();

    }

}
