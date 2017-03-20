package example_2;


import org.testng.annotations.Test;

public class DependencyGroups {

    @Test(groups = "testGroup")
    public void testGroup_1(){
        System.out.println("@Test - testGroup_1");
    }

    @Test(groups = "testGroup")
    public void testGroup_2(){
        System.out.println("@Test - testGroup_2");
        throw new RuntimeException();
    }

    @Test(dependsOnGroups = "testGroup")
    public void dependencyGroupTest(){
        System.out.println("@Test - dependencyGroupTest");
    }

}


