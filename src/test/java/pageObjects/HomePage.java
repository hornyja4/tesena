package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by JHornych on 20.03.2017.
 */
public class HomePage {

    @FindBy(xpath = "")
    private WebElement login;

    RemoteWebDriver driver;

    public HomePage(){

    }

    public LoginPage prihlas(){
        login.click();
        return new LoginPage();
    }

}
