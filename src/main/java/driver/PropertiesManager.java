package driver;


import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PropertiesManager {

    private static DesiredCapabilities capabilities;

    public static void setCapabilities(DesiredCapabilities capabilities) {
        PropertiesManager.capabilities = capabilities;
    }

    public static Platform getPlatform(){
        if(capabilities == null){
            throw new RuntimeException("You did not set capabilities.");
        }
        return capabilities.getPlatform();
    }

    public static String getBrowserName(){
        if(capabilities == null){
            throw new RuntimeException("You did not set capabilities.");
        }
        return capabilities.getBrowserName();
    }

    public static boolean isRemote(){
        return System.getProperty("remote").equals("true");
    }

    public static DesiredCapabilities getCapabilities(){
        return capabilities;
    }
}
