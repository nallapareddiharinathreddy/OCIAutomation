package OCI.TestCases;

import org.testng.annotations.Test;

public class TestB {

    @Test(priority = 1)
    public void First()
    {
        System.out.println("B : first method+1");
    }
    @Test(priority = 3)
    public void Second()
    {
        System.out.println("B : second method+3");
    }
    @Test(priority = 2)
    public void ElThird()
    {
        System.out.println("B : third method+2");
    }
}
