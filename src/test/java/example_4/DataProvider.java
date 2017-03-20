package example_4;

import org.testng.annotations.Test;

public class DataProvider {

    @org.testng.annotations.DataProvider
    public Object [][] dataProvider(){
        return new Object[][]{
                {'A'},
                {'B'},
                {'C'},
                {'D'}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void test(char character){
        System.out.println(character);
    }

}
