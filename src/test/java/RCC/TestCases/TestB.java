package RCC.TestCases;

import RCC.testBase.TestBase;
import org.testng.annotations.Test;

public class TestB extends TestBase {

    @Test(priority = 1)
    public void First() throws Exception
    {
        System.out.println("B : first method");
        Thread.sleep(60000);
    }
    @Test(priority = 2)
    public void Abc() throws Exception
    {
        System.out.println("B : second method");
        Thread.sleep(60000);
    }
    @Test(priority = 3,groups = {"Smoke"})
    public void Cde() throws  Exception
    {
        System.out.println("B : third method");
        Thread.sleep(60000);
    }
}
