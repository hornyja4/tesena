package driver;


import org.openqa.selenium.WebElement;

public abstract class PageObject {

    public DriverManager driverManager = DriverManager.getInstance();

    public PageObject(){
        driverManager.waitForPageToLoad();
    }

    public abstract void synchronize();

    public void waitForElement(WebElement element){
        driverManager.waitForElement(element);
    }

}
