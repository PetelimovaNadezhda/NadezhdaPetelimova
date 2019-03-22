package homework.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

import static homework.api.ConstantTrello.*;
import static homework.api.TrelloApi.baseRequestConfiguration;
import static homework.api.TrelloGetMetodsApi.*;

public class TrelloApiBuilder {
    static HashMap<String, Object> params = new HashMap<>();
    static HashMap<String, String> pathParams = new HashMap<>();

    public static class ApiBuilder {
        TrelloApiBuilder trelloApi;

        private ApiBuilder(TrelloApiBuilder gcApi) {
            trelloApi = gcApi;
        }

        public ApiBuilder createName(String name) {
            params.put("name", name);
            return this;
        }

        public ApiBuilder createCardPos(String posCard) {
            params.put("pos", posCard);
            return this;
        }

        public ApiBuilder createListsforBoard() {
            params.put("defaultLists", true);
            return this;
        }

        public ApiBuilder createDescforBoard(String desc) {
            params.put("desc", desc);
            return this;
        }

        public ApiBuilder getIDCard(String idCard) {
            params.put("idCard", idCard);
            return this;
        }

        public ApiBuilder getID(String id) {
            pathParams.put("id", id);
            return this;
        }


        public ApiBuilder getidList(String idBoard) {
            String idList = getBoardListsByIdTest(idBoard).get(0).id;
            params.put("idList", idList);
            return this;
        }

        public Response callPostCardApi() {
            return RestAssured.given(baseRequestConfiguration()).with()
                    .log().all()
                    .queryParams(params)
                    .post(CARDS)
                    .prettyPeek();
        }


        public Response callGetApi(String entities, String get) {
            return RestAssured.given(baseRequestConfiguration()).with()
                    .queryParams(params)
                    .pathParams(pathParams)
                    .log().all()
                    .get(entities + "{id}" + get)
                    .prettyPeek();
        }

        public Response callPostBoardApi() {
            return RestAssured.given(baseRequestConfiguration()).with()
                    .queryParams(params)
                    .pathParams(pathParams)
                    .log().all()
                    .post(BOARDS)
                    .prettyPeek();
        }


        public Response callPostChecklistApi(String get) {
            return RestAssured.given(baseRequestConfiguration()).with()
                    .queryParams(params)
                    .pathParams(pathParams)
                    .log().all()
                    .post(CHECKLISTS + "{id}" + get)
                    .prettyPeek();
        }
    }

    public static ApiBuilder with() {
        TrelloApiBuilder api = new TrelloApiBuilder();
        return new ApiBuilder(api);
    }
}