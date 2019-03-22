package homework.api;

import beans.TrelloAnswer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static homework.api.ConstantTrello.*;
import static homework.api.TrelloApi.baseRequestConfiguration;
import static homework.api.TrelloApi.successResponse;
import static homework.api.TrelloGetMetodsApi.*;
import static org.apache.commons.lang.RandomStringUtils.random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TrelloCardJSONTests {
    @AfterMethod
    public void afterTest() {
        TrelloApiBuilder.params.clear();
        TrelloApiBuilder.pathParams.clear();
    }

    @Test
    public void createCardWithNameTest() {
        String nameCard = "Lorem ipsum card " + random(5, true, true);
        String id = generateBoard().id;

        Response answer = TrelloApiBuilder.with()
                .createName(nameCard)
                .getidList(id)
                .callPostCardApi();
        answer.then().specification(successResponse());

        assertThat(getBoardCardsByIdTest(id).size(), equalTo(1));
    }

    @Test
    public void createCardWithPosTest() {
        String nameCard = "Lorem ipsum card pos top " + random(5, true, true);
        String id = generateBoard().id;
        generateCard(id);

        Response answer = TrelloApiBuilder.with()
                .createName(nameCard)
                .getidList(id)
                .createCardPos(POS_CARD)
                .callPostCardApi();
        answer.then().specification(successResponse());

        assertThat(getBoardCardsByIdTest(id).get(0).name, equalTo(nameCard));
    }

    @Test
    public void deleteCardByIDTest() {
        String idBoard = generateBoard().id;
        String idCard = generateCard(idBoard).id;
        int count = getBoardCardsByIdTest(idBoard).size();

        RestAssured
                .given(baseRequestConfiguration())
                .log().everything()
                .delete(CARDS + idCard)
                .prettyPeek()
                .then()
                .specification(successResponse());

        assertThat(getBoardCardsByIdTest(idBoard).size(), equalTo(count - 1));
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
