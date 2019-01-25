package lesson2;

import base.SeleniumBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleTestWithDataProvider extends SeleniumBase {

    @DataProvider
    private Object[][] simpleDataProvider(){
        return new Object[][]{
                {0, "Ivan"},
                {1, "Diana"},
                {2, "Roman"},
        };
    }

    @Test(dataProvider = "simpleDataProvider")
    public void SimpleTest(int i, String s){
        System.out.println("int = " + i + "\n" + "String = " + s);
    }

}
