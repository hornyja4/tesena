package objects;

import driver.PageObject;
import factory.Factory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginButton;

    @Override
    public void synchronize() {
        waitForElement(username);
    }

    public HomePage login(String user, String pwd){
        username.sendKeys(user);
        password.sendKeys(pwd);
        loginButton.click();
        return Factory.createObject();
    }

}
