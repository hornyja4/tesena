package objects;


import driver.PageObject;
import factory.Factory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DefaultPage extends PageObject{

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    @Override
    public void synchronize() {
        waitForElement(loginButton);
    }

    public LoginPage clickToLogin(){
        loginButton.click();
        return Factory.createObject();
    }
}
