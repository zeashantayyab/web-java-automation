package Emirates.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class Emiratestripplanner {

    //final variables
    public static final String PAGE_TITLE = "Cargo Security";
    public static final String PAGE_URL = "https://www.emirates.com/";

    //local webdriver variable
    WebDriver driver;

    //@FindBy(xpath="//*[@id='clr-form-control-4']")
   // WebElement userField_loginForm;

   // @FindBy(xpath="//*[@id='clr-form-control-5']")
   // WebElement passField_loginForm;


    //@FindBy(xpath="//*[@id=\"login-container\"]/div/div/form/div/input")
   // WebElement btn_submit;

    By Departure_Airport = By.xpath("//*[@id='f8b29127-1497-4b49-b434-ff35e7c72ac4']");
    By btn_Continue = By.xpath("//*[@id='panel0']/div/div/div/section/div[4]/div[1]/div[4]/a");//*[@id="panel0"]/div/div/div/section/div[4]/div[1]/div[4]/a
    By passField_loginForm = By.xpath("//*[@id='02f6824d-07c8-4a31-bdf7-0316aab97dc3']");
    By bookingform = By.xpath("//*[@id='panel0']/div/div/div/section/div[1]/div/div[1]");///div/div/form");//*[@id="panel0"]/div/div/div/section/div[1]/div/div[1]
    //By +button= By.xpath("/html/body/app-root/app-dashboard/div/div[2]/div/span[3]/clr-icon");

    //-----------------------

    //Page Class Constructor
    public Emiratestripplanner(WebDriver driver){
        this.driver = driver;
        //Create all webElement of this page
//        PageFactory.initElements(driver, this);
    }

    //Action Methods
    private void setUserfield(String userfield){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-container\"]/div/div")));

            driver.findElement(By.xpath("//*[@id=\"panel0\"]")).isDisplayed();
            driver.findElement(Departure_Airport).click();
            driver.findElement(Departure_Airport).sendKeys(userfield);
        }
        catch(NoSuchElementException nse){
            System.out.println("Not Found - "+ bookingform);
        }

    }

    private void setPassField(String passField)

    {
        driver.findElement(passField_loginForm).sendKeys(passField);
    }

    private void pressbtn_submit(){
        driver.findElement(btn_Continue).click();
    }

    public void enterLoginCredentials(String enter_user, String enter_pass){

        setUserfield(enter_user);
        setPassField(enter_pass);
        pressbtn_submit();

    }

    /*public void pressEarlierButton(){
        btn_earlierResults.click();
    }

    public void pressLaterButton(){
        btn_laterResults.click();
    }*/

    public void isLoginResultsDisplayed(){
        System.out.println("Home Page is Opened");

    }



}
