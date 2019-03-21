package homework.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

import static homework.api.ConstantTrello.*;
import static homework.api.TrelloApi.baseRequestConfiguration;
import static homework.api.TrelloGetMetodsApi.*;

public class TrelloApiBuilder {
    private static HashMap<String, Object> params = new HashMap<>();
    private static HashMap<String, String> pathParams = new HashMap<>();

    public static class ApiBuilder {
        TrelloApiBuilder trelloApi;

        private ApiBuilder(TrelloApiBuilder gcApi) {
            trelloApi = gcApi;
        }

        public ApiBuilder getBoardCardById(String id) {
            trelloApi.params.put("idBoard", id);
            return this;
        }

        public ApiBuilder createName(String name) {
            trelloApi.params.put("name", name);
            return this;
        }

        public ApiBuilder createCardPos(String posCard) {
            trelloApi.params.put("pos", posCard);
            return this;
        }

        public ApiBuilder createListsforBoard() {
            trelloApi.params.put("defaultLists", true);
            return this;
        }

        public ApiBuilder createDescforBoard(String desc) {
            trelloApi.params.put("desc", desc);
            return this;
        }

        public ApiBuilder getIDCard() {
            trelloApi.params.put("idCard", CARDS_ID);
            return this;
        }

        public ApiBuilder getID(String id) {
            trelloApi.pathParams.put("id", id);
            return this;
        }


        public ApiBuilder getidList() {
            String idList = getBoardListsByIdTest(generateBoard().id).get(0).id;
            trelloApi.pathParams.put("idList", idList);
            return this;
        }

        public Response callGetCardsApi() {
            return RestAssured.given(baseRequestConfiguration()).with()
                    .log().all()
                    .get(TRELLO_API_URI + BOARDS + trelloApi.params.get("idBoard") + CARDS)
                    .prettyPeek();
        }

        public Response callPostCardApi() {
            return RestAssured.given(baseRequestConfiguration()).with()
                    .log().all()
                    .queryParams(params)
                    .post(CARDS)
                    .prettyPeek();
        }

        public Response callPostBoardApi() {
            return RestAssured.given(baseRequestConfiguration()).with()
                    .queryParams(params)
                    .pathParams(pathParams)
                    .log().all()
                    .post(BOARDS + "{id}")
                    .prettyPeek();
        }


        public Response callPostChecklistApi() {
            return RestAssured.given(baseRequestConfiguration()).with()
                    .queryParams(params)
                    .pathParams(pathParams)
                    .log().all()
                    .post(CHECKLISTS + "/{id}/checkItems")
                    .prettyPeek();
        }
    }

    public static ApiBuilder with() {
        TrelloApiBuilder api = new TrelloApiBuilder();
        return new ApiBuilder(api);
    }
}