package homework.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static homework.api.ConstantTrello.*;
import static homework.api.TrelloApi.baseRequestConfiguration;
import static homework.api.TrelloApi.successResponse;
import static org.apache.commons.lang.RandomStringUtils.random;

public class TrelloCardJSONTests {
    @Test
    public void createCardWithNameTest() {
        String nameCard = "Lorem ipsum card "  + random(5, true, true);

        Response answer = TrelloApiBuilder.with()
                .createName(nameCard)
                .getidList()
                .callPostCardApi();
        answer.then().specification(successResponse());
    }

    @Test
    public void createCardWithPosTest() {
        String nameCard = "Lorem ipsum card "  + random(5, true, true);

        Response answer = TrelloApiBuilder.with()
                .createName(nameCard)
                .createCardPos(POS_CARD)
                .callPostCardApi();
        answer.then().specification(successResponse());
    }

    @Test
    public void deleteCardByIDTest() {


        RestAssured
                .given(baseRequestConfiguration())
                .log().everything()
                .delete(CARDS + CARDS_ID)
                .prettyPeek()
                .then()
                .specification(successResponse());
    }
}
