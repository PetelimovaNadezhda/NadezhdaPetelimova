package homework.hw6.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import homework.hw3.Users;
import homework.hw4.Colors;
import homework.hw4.Elements;
import homework.hw4.Metals;
import homework.hw4.ServiceSubcategory;

import java.util.List;

public class ActionSteps{
    @When("^I login as user '([^\"]*)'$")
    public void iLoginAsUser(String user) {
        NavigationStep.indexPage.login(Users.getUserByUserName(user));
    }

    @And("^I click on '([^\"]*)' button in Service dropdown$")
    public void iClickOnButtonInServiceDropdown(String select) throws Throwable {
        NavigationStep.indexPage.openPage(ServiceSubcategory.getServiceSubcategory(select));
    }

    @When("^I click on Service button in the Left section and check drop down (.*)$")
    public void iClickOnButtonInTheLeftSectionAndCheckDropDown(List<String> expected) throws Throwable {
        NavigationStep.indexPage.serviceMenuString(expected);
    }

    @And("^I click on Service button in the Header and check drop down (.*)$")
    public void iClickOnButtonInTheHeaderAndCheckDropDown(List<String> expected) throws Throwable {
        NavigationStep.indexPage.serviceMenuHeaderString(expected);
    }

    @When("^I select in the checkboxes '([^\"]*)'$")
    public void iSelectInTheCheckboxes(String element) {
        NavigationStep.differentElementsPage.selectNatureElements(Elements.valueOf(element));

    }

    @When("^I select in the radio '([^\"]*)'$")
    public void iSelectInTheRadio(String element) {
        NavigationStep.differentElementsPage.selectMetal(Metals.valueOf(element));

    }

    @When("^I select in the dropdown '([^\"]*)'$")
    public void iSelectInTheDropdown(String element) {
        NavigationStep.differentElementsPage.selectColor(Colors.valueOf(element));
    }

    @When("^I unselect in the checkboxes '([^\"]*)'$")
    public void iUnselectInTheCheckboxes(String element) {
        NavigationStep.differentElementsPage.selectNatureElements(Elements.valueOf(element));
    }
}
