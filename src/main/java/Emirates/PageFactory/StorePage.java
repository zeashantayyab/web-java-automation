package Emirates.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class StorePage {

    //final variables
    public static final String PAGE_TITLE = "My Store";
    public static final String PAGE_URL = "http://automationpractice.com/index.php";

    //local webdriver variable
    WebDriver driver;

    By Sign_in = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");
    By create_accfield = By.xpath("//*[@id='email_create']");
    By create_accbutton = By.xpath("//*[@id='SubmitCreate']/span");
    // By bookingform = By.xpath("//*[@id='panel0']/div/div/div/section/div[1]/div/div[1]");///div/div/form");//*[@id="panel0"]/div/div/div/section/div[1]/div/div[1]
    //-----------------------

    //Page Class Constructor
    public StorePage(WebDriver driver) {
        this.driver = driver;
        //Create all webElement of this page
        //PageFactory.initElements(driver, this);
    }

    //Action Methods
    private void ClickSignin() {
        try {
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(Departure_Airport));

            TimeUnit.SECONDS.sleep(5);
            driver.findElement(Sign_in).isDisplayed();
            driver.findElement(Sign_in).click();
            //driver.findElement(Departure_Airport).sendKeys(deptfield);
        } catch (NoSuchElementException nse) {
            System.out.println("Not Found - " + Sign_in);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }


        //private void SetArrivalField(String arrivalField) {
        //   driver.findElement(Arrival_Airport).sendKeys(arrivalField);
        //}

        // private void PressBtnCountine() {
        // driver.findElement(btn_Continue).click();
        //}
    }
        public void ClickSign(){


            //SetArrivalField(enter_arrival);
            // PressBtnCountine();


            try {

                ClickSignin();
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(Departure_Airport));

                TimeUnit.SECONDS.sleep(15);

                //driver.findElement(Departure_Airport).sendKeys(deptfield);
            } catch (NoSuchElementException nse) {
                System.out.println("Not Found - " + Sign_in);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }


        }

    }

/*
    //Action methods 2
    private void setCreateAccount(String createAccount){
        try {
            TimeUnit.SECONDS.sleep(5);
            driver.findElement(create_accfield).isDisplayed();
            driver.findElement(create_accfield).click();
            driver.findElement(create_accfield).sendKeys(createAccount);
        }

        catch(NoSuchElementException nse){
            System.out.println("Not Found - "+ Sign_in);
        }
        catch (InterruptedException ie){
            System.out.println(ie);
        }

        public void CreateAcc() {

            try {

                setCreateAccount(createAccount);
                TimeUnit.SECONDS.sleep(15);

            }
            catch(NoSuchElementException nse){
                System.out.println("Not Found - "+ create_accfield);
            }
            catch (InterruptedException ie){
                System.out.println(ie);
            }
        }
    }
*/