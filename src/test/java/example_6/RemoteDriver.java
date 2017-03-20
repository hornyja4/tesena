package example_6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class RemoteDriver {

    private RemoteWebDriver driver;

    @BeforeClass
    public void initChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");
    }

    @Test
    public void remoteDriver() throws IOException, InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://redmine.org");

        waitForElement(By.xpath("//a[@href='/login']"), 10);

        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        login.click();

        synchronized (driver){
            driver.wait(5000);
        }



    }

    @AfterClass
    public void reset(){
        driver.quit();
    }

    public void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        Wait<WebDriver> wait = new WebDriverWait(driver, 50);
        wait.until(expectation);
    }


    public void waitForElement(final By by, long timeout) {
        Wait<WebDriver> wait = new WebDriverWait(driver, timeout);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(by).isDisplayed();
            }
        });
    }

}
