package homework.hw6.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import homework.hw3.Users;
import homework.hw4.*;

import static homework.hw4.BooleanLiterals.FALSE;
import static homework.hw4.BooleanLiterals.TRUE;
import static homework.hw4.ElementTypes.COLORS;
import static homework.hw4.ElementTypes.METAL;
import static homework.hw4.LogPatterns.ELEMENTS;
import static homework.hw4.LogPatterns.METAL_COLOR;

public class AssertionSteps{
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

    //TODO
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
}
