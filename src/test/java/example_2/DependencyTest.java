package example_2;


import org.testng.annotations.Test;

public class DependencyTest {

    @Test
    public void configurationTest(){
        System.out.println("configuration");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"configurationTest"})
    public void test(){
        System.out.println("test");
    }

}
