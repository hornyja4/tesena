package example_1;

import org.testng.annotations.*;

public class TestConfiguration {

    @BeforeClass
    public void beforeClass(){
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("@AfterClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("@BeforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("@AfterMethod");
    }

    @Test(groups = "test")
    public void test_first(){
        System.out.println("test_first");
    }

    @Test
    public void test_second(){
        System.out.println("test_second");
    }

    @BeforeGroups(value = "test")
    public void beforeGroups(){
        System.out.println("@BeforeGroups");
    }

}
