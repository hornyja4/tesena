package example_4;


import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataMethodProvider {

    @Test(dataProvider = "dataProvider")
    public void test_1(String email){
        System.out.println("@Test_1 email:" + email);
    }

    @Test(dataProvider = "dataProvider")
    public void test_2(int number){
        System.out.println("@Test_2 number:" + number);
    }

    @org.testng.annotations.DataProvider
    public Object [][] dataProvider(Method method){

        Object[][] result = null;

        if(method.getName().equals("test_1")){
            result =  new Object[][]{{"jan.hornych@tesena.com"}};
        }else if(method.getName().equals("test_2")){
            result =  new Object[][]{{739627731}};
        }
        return result;
    }

}
