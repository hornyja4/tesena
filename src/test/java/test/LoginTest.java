package test;

import driver.DriverManager;
import driver.PropertiesManager;
import factory.Factory;
import listener.Reporter;
import listener.TestListener;
import objects.DefaultPage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Reporter.class, TestListener.class})
public class LoginTest {

    @BeforeClass
    public void initialize(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        capabilities.setPlatform(Platform.WINDOWS);
        PropertiesManager.setCapabilities(capabilities);
    }

    @Test
    public void loginTest(){
        DefaultPage defaultPage = Factory.createObject();
        defaultPage
                .clickToLogin()
                .login("hornyja4", "123456");
    }

    @AfterClass
    public void reset(){
        DriverManager.getInstance().getDriver().quit();
    }

}
