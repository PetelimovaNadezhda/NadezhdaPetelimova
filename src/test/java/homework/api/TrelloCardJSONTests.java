package homework.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static homework.api.ConstantTrello.*;
import static homework.api.TrelloApi.baseRequestConfiguration;
import static homework.api.TrelloApi.successResponse;
import static homework.api.TrelloGetAndGenerateMetodsApi.*;
import static org.apache.commons.lang.RandomStringUtils.random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class TrelloCardJSONTests extends Hooks {
    @Test
    public void createCardWithNameTest() {
        String nameCard = "Lorem ipsum card " + random(5, true, true);
        String id = generateBoard().id;

        Response answer = TrelloApiBuilder.with()
                .setName(nameCard)
                .setIDList(id)
                .setID(NO_ID)
                .callApi(Method.POST, CARDS, NO_PATH_GET);
        answer.then().specification(successResponse());

        assertThat(getBoardCardsByIdTest(id), hasSize(1));
    }

    @Test
    public void createCardWithPosTest() {
        String nameCard = "Lorem ipsum card pos top " + random(5, true, true);
        String id = generateBoard().id;
        generateCard(id);

        Response answer = TrelloApiBuilder.with()
                .setName(nameCard)
                .setIDList(id)
                .setCardPos(POS_CARD)
                .setID(NO_ID)
                .callApi(Method.POST, CARDS, NO_PATH_GET);
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

        assertThat(getBoardCardsByIdTest(idBoard), hasSize(count - 1));
    }
}
