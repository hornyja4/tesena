package factory;


import driver.DriverManager;
import driver.PageObject;
import org.openqa.selenium.support.PageFactory;

public class Factory {

    private static DriverManager driverManager;

    public static <T extends PageObject> T createObject(T... klazz){

        driverManager = DriverManager.getInstance();

        Object object = null;

        try {
            object = klazz.getClass().getComponentType().newInstance();

            PageFactory.initElements(driverManager.getDriver(), object);

            driverManager.waitForPageToLoad();

            ((PageObject) object).synchronize();

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) object;

    }

}
