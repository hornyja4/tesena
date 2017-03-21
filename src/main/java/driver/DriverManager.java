package driver;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private RemoteWebDriver driver;

    private static DriverManager instance;

    /**
     * Singleton pattern
     * @return DriverManager instance
     */
    public static DriverManager getInstance(){
        if(instance == null){
            instance = new DriverManager();
        }
        return instance;
    }

    private DriverManager(){
        getDriver();
    }

    public RemoteWebDriver getDriver(){

        if(driver != null){
            return driver;
        }

        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");

        if(PropertiesManager.isRemote()){

            try {

                URL url = new URL(System.getProperty("remoteURL"));
                driver = new RemoteWebDriver(url, PropertiesManager.getCapabilities());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }else{

            Platform platform = PropertiesManager.getPlatform();

            switch (platform){

                case WINDOWS:

                    String browserName = PropertiesManager.getBrowserName();

                    switch (browserName){

                        case "chrome":
                            driver = new ChromeDriver();
                            break;
                        case "firefox":
                            driver = new FirefoxDriver();
                            break;
                        case "ie":
                            driver = new InternetExplorerDriver();
                            break;
                    }

                    break;
                case ANDROID:
                    break;
                default:
                    throw new RuntimeException("You set wrong platform. Options are WINDOWS or ANDROID");
            }

        }

        // getting URL from Maven property
        String url = System.getProperty("URL");

        driver.get(url);
        driver.manage().window().maximize();

        return driver;
    }

    /**
     * Synchronization method. Wait until element is visible. With timeout 50 seconds
     * @param element
     */
    public void waitForElement(final WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return element.isDisplayed();
            }
        });
    }

    /**
     * Wait for until page is loaded.
     */
    public void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        Wait<WebDriver> wait = new WebDriverWait(driver, 5);
        wait.until(expectation);
    }
}
