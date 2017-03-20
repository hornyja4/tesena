package example_4;


import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GroupDataProvider {

    @Test(dataProvider = "dataProvider", groups = "groupA")
    public void test1(int number) {
        Assert.assertEquals(number, 1);
    }

    @org.testng.annotations.DataProvider(name = "dataProvider")
    public Object[][] provideData(ITestContext context) {

        Object[][] result = null;

        for (String group : context.getIncludedGroups()) {

            System.out.println("group : " + group);

            if ("groupA".equals(group)) {
                result = new Object[][] { { 1 } };
                break;
            }

        }

        if (result == null) {
            result = new Object[][] { { 2 } };
        }
        return result;

    }

}
