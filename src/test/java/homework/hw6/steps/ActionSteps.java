package homework.hw6.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import homework.hw3.Users;
import homework.hw4.*;
import homework.hw6.RunAcceptianceIT;

public class ActionSteps extends RunAcceptianceIT {
    @When("^I login as user '([^\"]*)'$")
    public void iLoginAsUser(String user) {
        new SelenideIndexPage().login(Users.getUserByUserName(user));
    }

    @And("^I click on '([^\"]*)' button in Service dropdown$")
    public void iClickOnButtonInServiceDropdown(String select) throws Throwable {
        new SelenideIndexPage().openPage(ServiceSubcategory.valueOf(select));
        throw new PendingException();
    }

    //TODO
    @When("^I click on '([^\"]*)' button in the Left section and check drop down$")
    public void iClickOnButtonInTheLeftSectionAndCheckDropDown(String button) throws Throwable {
        new SelenideIndexPage().serviceMenu(ServiceSubcategory.values());
        throw new PendingException();
    }

    //TODO
    @And("^I click on '([^\"]*)' button in the Header and check drop down$")
    public void iClickOnButtonInTheHeaderAndCheckDropDown(String arg0) throws Throwable {
        new SelenideIndexPage().serviceMenuHeader(ServiceSubcategory.values());
        throw new PendingException();
    }

    @When("^I select in the checkboxes '([^\"]*)'$")
    public void iSelectInTheCheckboxes(String element) {
        new DifferentElementsPage().selectNatureElements(Elements.valueOf(element));

    }

    @When("^I select in the radio '([^\"]*)'$")
    public void iSelectInTheRadio(String element) {
        new DifferentElementsPage().selectMetal(Metals.valueOf(element));

    }

    @When("^I select in the dropdown '([^\"]*)'$")
    public void iSelectInTheDropdown(String element) {
        new DifferentElementsPage().selectColor(Colors.valueOf(element));
    }

    @When("^I unselect in the checkboxes '([^\"]*)'$")
    public void iUnselectInTheCheckboxes(String element) {
        new DifferentElementsPage().selectNatureElements(Elements.valueOf(element));
    }
}
