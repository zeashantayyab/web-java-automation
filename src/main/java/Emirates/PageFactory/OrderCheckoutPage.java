package Emirates.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;
import java.text.DecimalFormat;

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


    //Page Class Constructor
    public OrderCheckoutPage(WebDriver driver) {
        this.webDriver = driver;



    }

    /**
     * Round to certain number of decimals
     *
     * @param d
     * @param decimalPlace
     * @return
     */
    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    public String GetProductCondition() {
        webDriver.findElement(prodCondition).isDisplayed();

        return  webDriver.findElement(prodCondition).getText();
    }

    public boolean IsReducedPriceCorrect() {

        String newPriceStr = webDriver.findElement(newPrice).getText().replace("$","");
        String oldPriceStr = webDriver.findElement(oldPrice).getText().replace("$","");
        String reductionPercentStr = webDriver.findElement(reductionPercent).getText().replace("%","");

        float newPriceFloat = Float.parseFloat(newPriceStr);
        float oldPriceFloat = Float.parseFloat(oldPriceStr);
        float percentInt =  Float.parseFloat(reductionPercentStr);

        float result = round(((oldPriceFloat*percentInt)/100)+oldPriceFloat,2);

        if(newPriceFloat==result) {
            return true;

        }
        else
            return false;
    }

}
