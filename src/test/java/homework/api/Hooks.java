package homework.api;

import beans.TrelloAnswer;
import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;

import static homework.api.ConstantTrello.BOARDS;
import static homework.api.TrelloApi.baseRequestConfiguration;
import static homework.api.TrelloApi.successResponse;
import static homework.api.TrelloGetAndGenerateMetodsApi.getBoardsList;

public class Hooks {
    @AfterMethod
    public void afterTest() {
        TrelloApiBuilder.params.clear();
        TrelloApiBuilder.pathParams.clear();

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
