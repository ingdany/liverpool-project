package pages;

import config.env_target;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage extends env_target {

    static By productTitle = By.className("a-product__information--title");
    static By productPrice = By.cssSelector(".a-product__paragraphDiscountPrice.m-0.d-inline");

    static WebDriverWait wait;

    public static void verify_title(String product) throws InterruptedException {
        Duration duration = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        System.out.println("Product Title: " + driver.findElement(productTitle).getText());
        Assert.assertTrue(driver.findElement(productTitle).getText().contains(product));
    }

    public static void verify_price() throws InterruptedException {
        try {
            Duration duration = Duration.ofSeconds(10);
            wait = new WebDriverWait(driver, duration);
            wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
            System.out.println("Product Price: " + driver.findElement(productPrice).getText());
            Assert.assertTrue(driver.findElement(productPrice).isDisplayed());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }

}
