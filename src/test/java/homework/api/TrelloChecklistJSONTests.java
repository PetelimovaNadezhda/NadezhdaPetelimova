package homework.api;

import beans.TrelloAnswer;
import cucumber.api.java.After;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static homework.api.ConstantTrello.BOARDS;
import static homework.api.TrelloApi.baseRequestConfiguration;
import static homework.api.TrelloApi.successResponse;
import static homework.api.TrelloGetMetodsApi.*;
import static org.apache.commons.lang.RandomStringUtils.random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TrelloChecklistJSONTests {
    @AfterMethod
    public void afterTest() {
        TrelloApiBuilder.params.clear();
        TrelloApiBuilder.pathParams.clear();
    }

    @Test
    public void createChecklistsTest() {
        String idBoard = generateBoard().id;
        String idCard = generateCard(idBoard).id;

        Response answer = TrelloApiBuilder.with()
                .getIDCard(idCard)
                .getID("")
                .callPostChecklistApi("");
        answer.then().specification(successResponse());

        assertThat(getChecklists(idCard).size(), equalTo(1));
    }

    @Test
    public void createChecklistsWithNameTest() {
        String idBoard = generateBoard().id;
        String idCard = generateCard(idBoard).id;
        String name = "Lorem ipsum checklist " + random(12, true, true);

        Response answer = TrelloApiBuilder.with()
                .createName(name)
                .getIDCard(idCard)
                .getID("")
                .callPostChecklistApi("");
        answer.then().specification(successResponse());

        assertThat(getChecklists(idCard).get(0).name, equalTo(name));
    }

    @Test
    public void createCheckItemTest() {
        String idBoard = generateBoard().id;
        String idCard = generateCard(idBoard).id;
        String idChecklist = generateChecklist(idCard).id;
        String name = "Lorem ipsum checkItems " + random(12, true, true);

        Response answer = TrelloApiBuilder.with()
                .createName(name)
                .getID(idChecklist)
                .callPostChecklistApi("/checkItems");
        answer.then().specification(successResponse());

        assertThat(getChecklists(idCard).get(0).checkItems.get(0).name, equalTo(name));
    }

    @AfterMethod
    public void deleteBoardTestByIdLorem() {
        for (TrelloAnswer trelloAnswer : getBoardsList()) {
            if (trelloAnswer.name.contains("Lorem"))
                RestAssured
                        .given(baseRequestConfiguration())
                        .log().everything()
                        .delete(BOARDS + trelloAnswer.id)
                        .prettyPeek()
                        .then()
                        .specification(successResponse());
        }
    }
}
