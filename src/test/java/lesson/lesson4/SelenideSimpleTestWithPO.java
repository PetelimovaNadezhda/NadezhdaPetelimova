package lesson.lesson4;

import base.lesson4.SelenideIndexPage;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelenideSimpleTestWithPO {
    private SelenideIndexPage indexPage;

    @BeforeMethod
    public void initTest() {
        open("https://epam.github.io/JDI/index.html");
        indexPage = page(SelenideIndexPage.class);
    }

    @AfterMethod
    public void closeTest() {
        close();
    }

    @Test
    public void SimpleTest() {
        indexPage.login("epam", "1234");
    }
}