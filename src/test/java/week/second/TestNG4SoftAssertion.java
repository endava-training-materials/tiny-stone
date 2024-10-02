package week.second;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG4SoftAssertion {


    @Test()
    public void firstTest(){

        System.out.println("\nFIRST TEST STARTS!\n");

        SoftAssert softAssert = new SoftAssert();

        int firstNum = 10;
        int secondNum = 20;

        int sum = addition( firstNum, secondNum);

        softAssert.assertTrue(sum < 25,
                "Error! Sum is greater than or equal 25!");

        softAssert.assertFalse(sum < 20,
                "Error! Sum is not less than 20!");

        softAssert.assertNotEquals(firstNum, secondNum,
                "Error! Given numbers are equal!");

        softAssert.assertAll();

        System.out.println("\nFIRST TEST ENDS!");

    }

    private int addition(int firstNum, int secondNum){

        int sum = firstNum + secondNum;
        System.out.println("The sum is: " + sum + "\n");

        return sum;
    }

}
