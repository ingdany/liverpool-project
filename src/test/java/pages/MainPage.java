package pages;

import config.env_target;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage extends env_target {

    static By searchBarLocator = By.id("mainSearchbar");
    static By productsLocated = By.className("a-plp-results-title");
    static By productThumbnails = By.className("m-plp-card-container");

    static WebDriverWait wait;

    public static void locate_search_bar() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBarLocator));
        Assert.assertTrue(driver.findElement(searchBarLocator).isDisplayed());
    }

    public static void search_product(String product) throws InterruptedException {
        driver.findElement(searchBarLocator).sendKeys(product);
        driver.findElement(searchBarLocator).sendKeys("\n");
    }

    public static void select_product(String product) throws InterruptedException {
        Duration duration = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsLocated));
        List<WebElement> list = driver.findElements(productThumbnails);
        boolean is_there = false;
        for (WebElement item : list) {
            if (item.getText().contains(product)) {
                is_there = true;
                item.click();
                break;
            }
        }
    }

//    public static void verify_title(String product) throws InterruptedException {
//        Duration duration = Duration.ofSeconds(10);
//        wait = new WebDriverWait(driver, duration);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(productsLocated));
//        Assert.assertTrue(driver.findElement(productsLocated).getText().contains(product));
//    }
}
