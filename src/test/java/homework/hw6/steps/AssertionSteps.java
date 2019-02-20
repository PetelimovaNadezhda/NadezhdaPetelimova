package homework.hw6.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import homework.hw3.Users;
import homework.hw4.Colors;
import homework.hw4.Elements;
import homework.hw4.Metals;
import homework.hw6.Table;

import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homework.hw3.Html.HTML_USER_TABLE;
import static homework.hw4.BooleanLiterals.FALSE;
import static homework.hw4.BooleanLiterals.TRUE;
import static homework.hw4.ElementTypes.COLORS;
import static homework.hw4.ElementTypes.METAL;
import static homework.hw4.LogPatterns.ELEMENTS;
import static homework.hw4.LogPatterns.METAL_COLOR;
import static org.testng.Assert.assertEquals;

public class AssertionSteps {
    @Then("^User name should be as for user '([^\"]*)'$")
    public void userNameShouldBeAsForUser(String user) {
        NavigationStep.indexPage.userNameAssert(Users.getUserByUserName(user));
    }

    @And("^Sections is displayed$")
    public void sectionIsDisplayed() {
        NavigationStep.differentElementsPage.checkSection();
    }

    @And("^Interface HomePage should have all needed elements$")
    public void interfaceHomePageShouldHaveAllNeededElements() {
        NavigationStep.indexPage.checkInterfaceIndexPage();
    }

    @Then("^Different Elements page is opened and interface Different Elements should have all needed elements$")
    public void differentElementsPageIsOpenedAndInterfaceDifferentElementsShouldHaveAllNeededElements() {
        NavigationStep.differentElementsPage.checkInterfaceDifferentPage();
    }

    @Then("^log update: '([^\"]*)' is '([^\"]*)'$")
    public void logUpdate(String what, String how) {
        switch (how) {
            case "TRUE":
                NavigationStep.differentElementsPage.assertLog(String.format(ELEMENTS.patterns, Elements.valueOf(what).text, TRUE.text));
                break;
            case "FALSE":
                NavigationStep.differentElementsPage.assertLog(String.format(ELEMENTS.patterns, Elements.valueOf(what).text, FALSE.text));
                break;
            case "METAL":
                NavigationStep.differentElementsPage.assertLog(String.format(METAL_COLOR.patterns, METAL.text, Metals.valueOf(what).text));
                break;
            case "COLOR":
                NavigationStep.differentElementsPage.assertLog(String.format(METAL_COLOR.patterns, COLORS.text, Colors.valueOf(what).text));
                break;
        }
    }

    @And("^(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void numbertypeDropdownsAreDisplayedOnUsersTableOnUserTablePage(int size) {
        NavigationStep.userTablePage.checkInterfaceDropdown(size);
    }

    @And("^(\\d+) User names are displayed on Users Table on User Table Page$")
    public void userNamesAreDisplayedOnUsersTableOnUserTablePage(int size) {
        NavigationStep.userTablePage.checkInterfaceNames(size);
    }

    @And("^(\\d+) Description images are displayed on Users Table on User Table Page$")
    public void descriptionImagesAreDisplayedOnUsersTableOnUserTablePage(int size) {
        NavigationStep.userTablePage.checkInterfaceImgs(size);
    }

    @And("^(\\d+) Description texts under images are displayed on Users Table on User Table Page$")
    public void descriptionTextsUnderImagesAreDisplayedOnUsersTableOnUserTablePage(int size) {
        NavigationStep.userTablePage.checkInterfaceText(size);
    }

    @And("^(\\d+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayedOnUsersTableOnUserTablePage(int size) {
        NavigationStep.userTablePage.checkInterfaceCheckbox(size);
    }

    @And("^User table contains following values:$")
    public void userTableContainsFollowingValues(List<Table> table) {
        NavigationStep.userTablePage.equalsTable(table);
    }

    @Then("^I log row has \"([^\"]*)\" text in log section$")
    public void logRowHasTextInLogSection(String s) {
        NavigationStep.userTablePage.assertLog(s);
    }

    @Then("^droplist contains values$")
    public void droplistContainsValues(List<String> list) {
        NavigationStep.userTablePage.checkInterfaceDroplist(list);
    }

    @Then("^User Table page is opened$")
    public void userTablePageIsOpened() {
        assertEquals(getWebDriver().getCurrentUrl(), HTML_USER_TABLE.htmlName);

    }
}