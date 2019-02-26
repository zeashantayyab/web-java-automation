package Emirates.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static Utilities.HelperClass.round;


public class OrderCheckoutPage {

    //final variables
    public static final String PAGE_TITLE = "Women - My Store";
    public static final String PAGE_URL = "http://automationpractice.com/index.php?id_product=5&controller=product";

    //local webdriver variable
    WebDriver webDriver;
    By prodCondition = By.xpath(".//p[@id='product_condition']/span");
    By newPrice = By.xpath(".//div[@class='price']/p[@class='our_price_display']/span");
    By reductionPercent = By.xpath(".//div[@class='price']/p[@id='reduction_percent']");
    By oldPrice = By.xpath(".//div[@class='price']/p[@id='old_price']/span[@id='old_price_display']");
    By quantityPlus = By.xpath(".//p[@id='quantity_wanted_p']/a[2]");
    By addToCart = By.xpath(".//p[@id='add_to_cart']/button[@type='submit']");
    By totalProduct = By.xpath(".//div[@class='layer_cart_cart col-xs-12 col-md-6']/div[@class='layer_cart_row']/span[@class='ajax_block_products_total']");
    By totalShipping = By.xpath(".//div[@class='layer_cart_cart col-xs-12 col-md-6']/div[@class='layer_cart_row']/span[@class='ajax_cart_shipping_cost']");
    By total = By.xpath(".//div[@class='layer_cart_cart col-xs-12 col-md-6']/div[@class='layer_cart_row']/span[@class='ajax_block_cart_total']");

    //Page Class Constructor
    public OrderCheckoutPage(WebDriver driver) {
        this.webDriver = driver;


    }


    public String GetProductCondition() {
        webDriver.findElement(prodCondition).isDisplayed();

        return webDriver.findElement(prodCondition).getText();
    }

    public boolean IsReducedPriceCorrect() {

        String newPriceStr = webDriver.findElement(newPrice).getText().replace("$", "");
        String oldPriceStr = webDriver.findElement(oldPrice).getText().replace("$", "");
        String reductionPercentStr = webDriver.findElement(reductionPercent).getText().replace("%", "");

        float newPriceFloat = Float.parseFloat(newPriceStr);
        float oldPriceFloat = Float.parseFloat(oldPriceStr);
        float percentInt = Float.parseFloat(reductionPercentStr);


        float result = round(((oldPriceFloat * percentInt) / 100) + oldPriceFloat, 2);

        if (newPriceFloat == result) {

            System.out.println("result:" + result);
            return true;

        } else
            return false;

    }

    public void ClickPlusButton() {

        try {
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(Departure_Airport));

            TimeUnit.SECONDS.sleep(2);
            webDriver.findElement(quantityPlus).isDisplayed();
            webDriver.findElement(quantityPlus).click();
            TimeUnit.SECONDS.sleep(2);


        } catch (NoSuchElementException nse) {
            System.out.println("Not Found - " + quantityPlus);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }


    }

    public void ClickAddToCart() {

        try {
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(Departure_Airport));

            TimeUnit.SECONDS.sleep(2);
            webDriver.findElement(addToCart).isDisplayed();
            webDriver.findElement(addToCart).click();
            TimeUnit.SECONDS.sleep(2);


        } catch (NoSuchElementException nse) {
            System.out.println("Not Found - " + addToCart);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }


    }

    public boolean ProductSuccessfullyAdded() {

        String totalPro= webDriver.findElement(totalProduct).getText().replace("$","" );
        String totalShip=webDriver.findElement(totalShipping).getText().replace("$","");
        String tot=webDriver.findElement(total).getText().replace("$","");

        float totalProFloat= Float.parseFloat(totalPro);
        float totalShipFloat= Float.parseFloat(totalShip);
        float totFloat= Float.parseFloat(tot);



        float result1 = round(((totalProFloat + totalShipFloat)), 2);

        if (totFloat == result1) {

            System.out.println("result:" + result1);

            return true;

        } else
            return false;
    }

}



/*


package com.codility.selenium.candidate;

        import static org.junit.Assert.assertEquals;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.junit.Test;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.Keys;
        import static org.junit.Assert.assertTrue;
        import com.codility.selenium.tests.WebDriverTestCase;


public class Solution extends WebDriverTestCase {

   /*
      You can copy credentials from here:
       - jack.sparrow@thepiratebay.se    blackpearl
       - will.turner@gentlemen.com       savoirvivre
    */

  /*  @Test
    public void verifyLoginPageTitle() {
        String title = webDriver.getTitle();
        System.out.println(title);
        assertEquals( "ARR", title);
    }

    @Test
    public void verifyEmailPasswordField() {
        By emailInput = By.xpath("//input[@id='email-input']");
        By passwordInput = By.xpath("//*[@id='password-input']");
        By loginButton = By.xpath("//*[@id='login-button']");
        assertTrue(webDriver.findElement(emailInput).isDisplayed());
        assertTrue(webDriver.findElement(passwordInput).isDisplayed());
        assertTrue(webDriver.findElement(loginButton).isDisplayed());

    }

    @Test
    public void ShouldVerifyThatEmptyFieldsAreValidated() {
        By emailInput = By.xpath("//input[@id='email-input']");
        By passwordInput = By.xpath("//*[@id='password-input']");
        By loginButton = By.xpath("//*[@id='login-button']");
        // By successMessage = By.xpath("//*[@id='container']/div");
        By emailERROR = By.xpath("//*[@id='messages']/div[1]");
        By passwordERROR = By.xpath("//*[@id='messages']/div[2]");

        webDriver.findElement(emailInput).clear();
        webDriver.findElement(emailInput).sendKeys("");
        webDriver.findElement(passwordInput).clear();
        webDriver.findElement(passwordInput).sendKeys("");

        webDriver.findElement(loginButton).click();

        assertTrue(webDriver.findElement(emailERROR).isDisplayed());
        assertTrue(webDriver.findElement(passwordERROR).isDisplayed());


    }

    @Test
    public void verifyErrorOnInvalidCredentials () {
        By emailInput = By.xpath("//input[@id='email-input']");
        By passwordInput = By.xpath("//*[@id='password-input']");
        By loginButton = By.xpath("//*[@id='login-button']");
        By NoSuccessMessage = By.xpath("//*[@id='messages']/div");

        webDriver.findElement(emailInput).clear();
        webDriver.findElement(emailInput).sendKeys("will.turner@gentlemen.com");
        webDriver.findElement(passwordInput).clear();
        webDriver.findElement(passwordInput).sendKeys("savoirvivre");

        webDriver.findElement(loginButton).click();
        //

        assertTrue(webDriver.findElement(NoSuccessMessage).isDisplayed());


    }

    @Test
    public void verifySuccessOnValidCredentials () {
        By emailInput = By.xpath("//input[@id='email-input']");
        By passwordInput = By.xpath("//*[@id='password-input']");
        By loginButton = By.xpath("//*[@id='login-button']");
        By successMessage = By.xpath("//*[@id='container']/div");

        webDriver.findElement(emailInput).clear();
        webDriver.findElement(emailInput).sendKeys("jack.sparrow@thepiratebay.se");
        webDriver.findElement(passwordInput).clear();
        webDriver.findElement(passwordInput).sendKeys("blackpearl");

        webDriver.findElement(loginButton).click();

        assertTrue(webDriver.findElement(successMessage).isDisplayed());


    }

}
*/