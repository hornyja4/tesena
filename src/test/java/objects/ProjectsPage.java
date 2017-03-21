package objects;

import driver.PageObject;
import factory.Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ProjectsPage extends PageObject {

    @FindBy(id = "projects-index")
    private WebElement projects;

    @Override
    public void synchronize() {
        waitForElement(projects);
    }

    public SelectedProjectPage selectProject(String projectName){
        projects.findElement(By.xpath("//a[text()='" + projectName + "']")).click();
        return Factory.createObject();
    }
}
