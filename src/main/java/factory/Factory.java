package factory;


public class Factory {

    /*

    public static <T extends PageObject> T createObject(T... klazz){

        driverManager = DriverManager.getInstance();

        Object object = null;

        try {
            object = klazz.getClass().getComponentType().newInstance();

            PageFactory.initElements(driverManager.getDriver(), object);

            driverManager.waitForPageToLoad();

            ((PageObject) object).synchronised();

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) object;

    } */

}
