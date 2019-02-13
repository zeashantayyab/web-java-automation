package TransportNSW.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class LoginPage {

    //final variables
    public static final String PAGE_TITLE = "Cargo Security";
    public static final String PAGE_URL = "http://51.144.36.11/login";

    //local webdriver variable
    WebDriver driver;

    //@FindBy(xpath="//*[@id='clr-form-control-4']")
   // WebElement userField_loginForm;

   // @FindBy(xpath="//*[@id='clr-form-control-5']")
   // WebElement passField_loginForm;


    //@FindBy(xpath="//*[@id=\"login-container\"]/div/div/form/div/input")
   // WebElement btn_submit;

    By userField_loginForm = By.xpath("//*[@id='clr-form-control-1']");
    By btn_submit = By.xpath("//*[@id='login-container']/div/div/form/div/input");
    By passField_loginForm = By.xpath("//*[@id='clr-form-control-2']");
    By loginForm = By.xpath("//*[@id=\"login-container\"]/div/div/form");
    //By +button= By.xpath("/html/body/app-root/app-dashboard/div/div[2]/div/span[3]/clr-icon");

    //-----------------------

    //Page Class Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
        //Create all webElement of this page
//        PageFactory.initElements(driver, this);
    }

    //Action Methods
    private void setUserfield(String userfield){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-container\"]/div/div")));

            driver.findElement(By.xpath("//*[@id=\"clr-form-control-1\"]")).isDisplayed();
            driver.findElement(userField_loginForm).click();
            driver.findElement(userField_loginForm).sendKeys(userfield);
        }
        catch(NoSuchElementException nse){
            System.out.println("Not Found - "+ userField_loginForm);
        }

    }

    private void setPassField(String passField)

    {
        driver.findElement(passField_loginForm).sendKeys(passField);
    }

    private void pressbtn_submit(){
        driver.findElement(btn_submit).click();
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
