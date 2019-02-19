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
    By creat_button = By.xpath("//*[@id='SubmitCreate']");
    By title_Mr= By.xpath("//*[@id='id_gender1']");
    By First_name= By.xpath("//*[@id='customer_firstname']");
    By Last_name= By.xpath("//*[@id='customer_lastname']");
    By Emai_id=By.xpath("//*[@id='email']");
    By Password=By.xpath("//*[@id='passwd']");
    By DOB_firstdropdown=By.xpath("//*[@id='days']");
    By DOB_seconddropdown =By.xpath("//*[@id='months']");
    By DOB_3rddropdpwn= By.xpath("//*[@id='years']");
    By newslettercheckbox= By.xpath("//*[@id='newsletter']");
    By specialoffercheckbox= By.xpath("//*[@id='optin']");

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

            TimeUnit.SECONDS.sleep(2);
            driver.findElement(Sign_in).isDisplayed();
            driver.findElement(Sign_in).click();
            //driver.findElement(Departure_Airport).sendKeys(deptfield);
        } catch (NoSuchElementException nse) {
            System.out.println("Not Found - " + Sign_in);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }


    }

    public void ClickSign() {


        try {

            ClickSignin();
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(Departure_Airport));

            TimeUnit.SECONDS.sleep(2);

            //driver.findElement(Departure_Airport).sendKeys(deptfield);
        } catch (NoSuchElementException nse) {
            System.out.println("Not Found - " + Sign_in);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }


    }


    //Action methods 2
    private void setCreateAccount(String createAccount) {
        try {
            TimeUnit.SECONDS.sleep(2);
            driver.findElement(create_accfield).isDisplayed();
            driver.findElement(create_accfield).click();
            driver.findElement(create_accfield).sendKeys(createAccount);
        } catch (
                NoSuchElementException nse) {
            System.out.println("Not Found - " + Sign_in);
        } catch (
                InterruptedException ie) {
            System.out.println(ie);
        }

    }

    public void CreateAcc(String createAccount1) {

        try {

            setCreateAccount(createAccount1);
            TimeUnit.SECONDS.sleep(2);

        } catch (NoSuchElementException nse) {
            System.out.println("Not Found - " + create_accfield);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }



    //Action methods 3
    private void setclickCreateButton() {
        try {
            TimeUnit.SECONDS.sleep(2);
            driver.findElement(creat_button).isDisplayed();
            driver.findElement(creat_button).click();

        } catch (
                NoSuchElementException nse) {
            System.out.println("Not Found - " + Sign_in);
        } catch (
                InterruptedException ie) {
            System.out.println(ie);
        }

    }

    public void ClickCreateButn() {

        try {

            setclickCreateButton();
            TimeUnit.SECONDS.sleep(2);

        } catch (NoSuchElementException nse) {
            System.out.println("Not Found - " + create_accfield);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }


    //Action methods 4
    private void setclickTitle() {
        try {
            TimeUnit.SECONDS.sleep(2);
            driver.findElement(title_Mr).isDisplayed();
            driver.findElement(title_Mr).click();

        } catch (
                NoSuchElementException nse) {
            System.out.println("Not Found - " + title_Mr);
        } catch (
                InterruptedException ie) {
            System.out.println(ie);
        }

    }

    public void ClickMrCheckbox() {

        try {

            setclickTitle();
            TimeUnit.SECONDS.sleep(5);

        } catch (NoSuchElementException nse) {
            System.out.println("Not Found - " + title_Mr);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }

    //Action methods 5
    private void setfirstName(String firstname ) {
        try {
            TimeUnit.SECONDS.sleep(2);
            driver.findElement(First_name).isDisplayed();
            driver.findElement(First_name).click();
            driver.findElement(First_name).sendKeys(firstname);

        } catch (
                NoSuchElementException nse) {
            System.out.println("Not Found - " + First_name);
        } catch (
                InterruptedException ie) {
            System.out.println(ie);
        }

    }

    public void firstname(String firstName1) {

        try {

            setfirstName(firstName1);
            TimeUnit.SECONDS.sleep(2);

        } catch (NoSuchElementException nse) {
            System.out.println("Not Found - " + First_name);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }

    //Action methods 6
    private void setLast_name(String lastName ) {
        try {
            TimeUnit.SECONDS.sleep(2);
            driver.findElement(Last_name).isDisplayed();
            driver.findElement(Last_name).click();
            driver.findElement(Last_name).sendKeys(lastName);

        } catch (
                NoSuchElementException nse) {
            System.out.println("Not Found - " + Last_name);
        } catch (
                InterruptedException ie) {
            System.out.println(ie);
        }

    }

    public void setLastname1(String lastname1) {

        try {

            setLast_name(lastname1);
            TimeUnit.SECONDS.sleep(2);

        } catch (NoSuchElementException nse) {
            System.out.println("Not Found - " + Last_name);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }

    private void setEmail_id(String Email_id ) {
        try {
            TimeUnit.SECONDS.sleep(2);
            driver.findElement(Emai_id).isDisplayed();
            driver.findElement(Emai_id).click();
            driver.findElement(Emai_id).clear();
            TimeUnit.SECONDS.sleep(2);
            driver.findElement(Emai_id).sendKeys(Email_id);

        } catch (
                NoSuchElementException nse) {
            System.out.println("Not Found - " + Emai_id);
        } catch (
                InterruptedException ie) {
            System.out.println(ie);
        }

    }

    public void setEmail_id1(String Email_id1) {

        try {

            setEmail_id(Email_id1);
            TimeUnit.SECONDS.sleep(2);

        } catch (NoSuchElementException nse) {
            System.out.println("Not Found - " + Emai_id);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }

}