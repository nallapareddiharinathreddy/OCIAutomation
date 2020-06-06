package OCI.test;

import org.testng.annotations.*;

public class TestingTestNG {

    @BeforeSuite
    public void abc()
    {
        System.out.println("before suite");
    }
    @AfterSuite
    public void aa()
    {
        System.out.println("after suite");
    }
    @BeforeClass
    public void cls()
    {
        System.out.println("before  class");

    }
    @AfterClass
    public void cls2()
    {
        System.out.println("After  class");

    }
    @BeforeTest
    public void m1()
    {
        System.out.println("before   test");

    }
    @AfterTest
    public void m2()
    {
        System.out.println("after   test");

    }

    @BeforeMethod
    public void m3()
    {
        System.out.println("before method");
    }
    @AfterMethod
    public void m4()
    {
        System.out.println("After method");
    }

    @Test
    public void test()
    {
        System.out.println("test 1");
        method();
    }

    @Test
    public void test2()
    {
        System.out.println("test 2");
        method();
    }
    public void method()
    {
        System.out.println("method calling");
    }

}
