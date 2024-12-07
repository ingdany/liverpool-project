package pages;

import config.env_target;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class MainPage extends env_target {

    static By searchBarLocator = By.id("mainSearchbar");
    static By productsLocated = By.className("a-plp-results-title");
    static By productThumbnails = By.className("m-plp-card-container");
    static By searchBrandLocator = By.id("searchBrand");
    static By countLocator = By.className("a-plp-results-title");
    static By categoriesMenu = By.className("m-navDesktop__menuList");
//    static By modalContent = By.id("newMegaMenu-modal");
//    static By modalContent = By.cssSelector(".modal-dialog.modal-dialog-centered.content-mm.LP");
//    static By optionMenu = By.xpath("//*[@id=\\\"categories-sidebarMenu\"]");
//    static By optionMenu = By.xpath("//*[@id=\"categories-sidebarMenu\"]/div/div[6]/li/a");

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

    public static void filter_price(String price) throws InterruptedException {
        Duration duration = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsLocated));
        By priceFilterLocator = By.xpath("//label[contains(text(),'" + price + "')]");
        WebElement priceFilterElement = wait.until(ExpectedConditions.elementToBeClickable(priceFilterLocator));
        priceFilterElement.click();
        By parentPriceFilterLocator = By.xpath("//label[contains(text(),'" + price + "')]/parent::div//*");
        WebElement parentPriceFilterElement = wait.until(ExpectedConditions.elementToBeClickable(parentPriceFilterLocator));
        parentPriceFilterElement.click();
    }

    public static void search_brand(String brand) throws InterruptedException {
        WebElement searchBrandElement = wait.until(ExpectedConditions.elementToBeClickable(searchBrandLocator));
        searchBrandElement.sendKeys(brand);
        By brandFilterLocator = By.xpath("//label[contains(text(),'" + brand.toUpperCase() + "')]");
        WebElement brandFilterElement = wait.until(ExpectedConditions.elementToBeClickable(brandFilterLocator));
        brandFilterElement.click();
        By parentBrandFilterLocator = By.xpath("//label[contains(text(),'" + brand.toUpperCase() + "')]/parent::div//*");
        WebElement parentBrandFilterElement = wait.until(ExpectedConditions.elementToBeClickable(parentBrandFilterLocator));
        parentBrandFilterElement.click();
    }

    public static void filter_size(String size) throws InterruptedException {
        By sizeFilterLocator = By.xpath("//label[contains(text(),'" + size + "')]");
        WebElement sizeFilterElement = wait.until(ExpectedConditions.elementToBeClickable(sizeFilterLocator));
        sizeFilterElement.click();
        By parentSizeFilterLocator = By.xpath("//label[contains(text(),'" + size + "')]/parent::div//*");
        WebElement parentSizeFilterElement = wait.until(ExpectedConditions.elementToBeClickable(parentSizeFilterLocator));
        parentSizeFilterElement.click();
    }

    public static void verify_count() throws InterruptedException {
        try {
            Thread.sleep(3000);
            WebElement countElement = wait.until(ExpectedConditions.visibilityOfElementLocated(countLocator));
            Assert.assertTrue(driver.findElement(countLocator).isDisplayed());
            System.out.println(countElement.getText());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }

    }

    public static void select_categories() throws InterruptedException {
        WebElement categoriesElement = wait.until(ExpectedConditions.elementToBeClickable(categoriesMenu));
        categoriesElement.click();
    }

    public static void select_menu(String menu) throws InterruptedException {
        try {
            Thread.sleep(3000);
            By sidebarMenu = By.xpath("//*[@id='categories-sidebarMenu']/div/div[6]/li/a");
            Actions actions = new Actions(driver);
            WebElement sidebarMenuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sidebarMenu));
            actions.moveToElement(sidebarMenuElement).perform();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void select_sub_menu(String subMenu) throws InterruptedException {
        try {
            By subMenuLocator = By.xpath(".//*[contains(text(),'" + subMenu + "')]");
            WebElement subMenuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(subMenuLocator));
            subMenuElement.click();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verify_product(String product) throws InterruptedException {
        try {
            Duration duration = Duration.ofSeconds(10);
            wait = new WebDriverWait(driver, duration);
            wait.until(ExpectedConditions.visibilityOfElementLocated(productsLocated));
            List<WebElement> list = driver.findElements(productThumbnails);
            boolean is_there = false;
            for (WebElement item : list) {
                if (item.getText().contains(product)) {
                    is_there = true;
                    break;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }

}
