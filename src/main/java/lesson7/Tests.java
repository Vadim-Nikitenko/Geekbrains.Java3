package lesson7;


import lesson7.annotations.AfterSuite;
import lesson7.annotations.BeforeSuite;
import lesson7.annotations.Test;

public class Tests {

    @BeforeSuite
    public static void preCondition() {
        System.out.println("precondition");
    }

    @Test(priority = 3)
    public static void testFirst() {
        System.out.println(1);
    }


    @Test(priority = 2)
    public static void testSecond() {
        System.out.println(2);
    }


    @Test(priority = 4)
    public static void testThird() {
        System.out.println(3);
    }

    @Test(priority = 1)
    public static void testFourth() {
        System.out.println(4);
    }

    @AfterSuite
    public static void postCondition() {
        System.out.println("post condition");
    }

}
