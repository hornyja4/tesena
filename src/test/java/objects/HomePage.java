package objects;

import driver.PageObject;
import factory.Factory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageObject {

    @FindBy(xpath = "//a[@href='/projects']")
    private WebElement projects;

    @Override
    public void synchronize() {
        waitForElement(projects);
    }

    public ProjectsPage clickToProjects(){
        projects.click();
        return Factory.createObject();
    }
}
