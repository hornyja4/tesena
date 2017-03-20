package example_3;


import org.testng.annotations.Test;

//@Listeners(listener.TestListener.class)
public class ExpectedException {

    @Test(expectedExceptions = RuntimeException.class)
    public void expectedExceptionTest(){
        System.out.println("@Test - expectedExceptionTest");
        //throw new RuntimeException();
    }

}
