package example_6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;

public class RemoteDriver {

    private RemoteWebDriver driver;

    @BeforeSuite
    public void initChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");
    }

    @DataProvider
    public Object [][] dataProvider(){
        return new Object[][]{
                {"Issue 1", "Description"},
                {"Issue 2", "Description 2"}};
    }

    @BeforeClass()
    public void remoteDriver() throws IOException, InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.redmine.org");

        waitForElement(By.xpath("//a[@href='/login']"), 10);

        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        login.click();

        waitForElement(By.id("username"), 10);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("hornyja4");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.xpath("//input[@name='login']"));
        loginButton.click();

        waitForElement(By.id("loggedas"), 10);

        WebElement projects = driver.findElement(By.xpath("//a[@href='/projects']"));
        projects.click();

        waitForElement(By.linkText("Tesena"), 10);

        WebElement project = driver.findElement(By.linkText("Tesena"));
        project.click();

        waitForElement(By.xpath("//a[contains(@href, 'issues/new')]"), 10);

        WebElement newIssue = driver.findElement(By.xpath("//a[contains(@href, 'issues/new')]"));
        newIssue.click();

        synchronized (driver){
            driver.wait(5000);
        }
    }

    @Test(dataProvider = "dataProvider")
    public void createIssueTest(String name, String desc){

        waitForElement(By.id("issue-form"), 10);

        WebElement issueSubject = driver.findElement(By.id("issue_subject"));
        issueSubject.sendKeys(name);

        WebElement issueDesc = driver.findElement(By.id("issue_description"));
        issueDesc.sendKeys(desc);

        WebElement priority = driver.findElement(By.id("issue_priority_id"));
        Select prioritySelect = new Select(priority);

        prioritySelect.selectByVisibleText("High");

        WebElement submitAndContinue = driver.findElement(By.xpath("//input[@name='continue']"));
        submitAndContinue.click();

        waitForElement(By.id("flash_notice"), 10);

    }

    @AfterTest
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
