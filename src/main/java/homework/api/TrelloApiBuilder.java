package homework.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

import static homework.api.ConstantTrello.*;
import static homework.api.TrelloApi.baseRequestConfiguration;
import static homework.api.TrelloGetAndGenerateMetodsApi.getBoardListsByIdTest;

public class TrelloApiBuilder {
    static HashMap<String, Object> params = new HashMap<>();
    static HashMap<String, String> pathParams = new HashMap<>();

    public static class ApiBuilder {
        TrelloApiBuilder trelloApi;

        private ApiBuilder(TrelloApiBuilder gcApi) {
            trelloApi = gcApi;
        }

        ApiBuilder setName(String name) {
            params.put(NAME, name);
            return this;
        }

        ApiBuilder setCardPos(String posCard) {
            params.put(POS, posCard);
            return this;
        }

        ApiBuilder setListsForBoard() {
            params.put(DEFAULT_LISTS, true);
            return this;
        }

        ApiBuilder setDescForBoard(String desc) {
            params.put(DESC, desc);
            return this;
        }

        ApiBuilder setIDCard(String idCard) {
            params.put(ID_CARD, idCard);
            return this;
        }

        ApiBuilder setID(String id) {
            pathParams.put(ID, id);
            return this;
        }


        ApiBuilder setIDList(String idBoard) {
            String idList = getBoardListsByIdTest(idBoard).get(0).id;
            params.put(ID_LIST, idList);
            return this;
        }

        Response callGetApi(String entities, String get) {
            return RestAssured.given(baseRequestConfiguration()).with()
                    .queryParams(params)
                    .pathParams(pathParams)
                    .log().all()
                    .get(entities + "{id}" + get)
                    .prettyPeek();
        }

        Response callPostApi(String entities, String get) {
            return RestAssured.given(baseRequestConfiguration()).with()
                    .queryParams(params)
                    .pathParams(pathParams)
                    .log().all()
                    .post(entities + "{id}" + get)
                    .prettyPeek();
        }
    }

    static ApiBuilder with() {
        TrelloApiBuilder api = new TrelloApiBuilder();
        return new ApiBuilder(api);
    }
}