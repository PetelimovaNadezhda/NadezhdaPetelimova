package homework.api;

import beans.TrelloAnswer;
import beans.TrelloAnswerCard;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.List;

import static homework.api.ConstantTrello.*;
import static org.hamcrest.Matchers.lessThan;

public class TrelloApi {
    private static HashMap<String, Object> params = new HashMap<>();
    private  static HashMap<String,String> pathParams = new HashMap<>();

    public static class ApiBuilder {
        TrelloApi trelloApi;

        private ApiBuilder(TrelloApi gcApi) {
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

        public Response callGetCardsApi() {
            return RestAssured.given(baseRequestConfiguration()).with()
                    .log().all()
                    .get(TRELLO_API_URI + BOARDS + trelloApi.params.get("idBoard") + CARDS)
                    .prettyPeek();
        }

        public Response callPostCardApi() {
            return RestAssured.given(baseRequestConfiguration()).with()
                    .log().all()
                    .queryParams(TrelloApi.params)
                    .post(TRELLO_API_URI + CARDS_API + ID_LIST)
                    .prettyPeek();
        }

       public Response callPostBoardApi() {
            return RestAssured.given(baseRequestConfiguration()).with()
                    .queryParams(TrelloApi.params)
                    .log().all()
                    .post(BOARDS + "?name=name")
                    .prettyPeek();
        }


        public Response callPostChecklistApi() {
            return RestAssured.given(baseRequestConfiguration()).with()
                    .queryParams(TrelloApi.params)
                    .pathParams(TrelloApi.pathParams)
                    .log().all()
                    .post(CHECKLISTS+ "/{id}/checkItems")
                    .prettyPeek();
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

        public ApiBuilder getIDCheckList() {
            trelloApi.pathParams.put("id", ID_CHECKLIST);
            return this;
        }
    }
    public static ApiBuilder with() {
        TrelloApi api = new TrelloApi();
        return new ApiBuilder(api);
    }

    //set base request and response specifications tu use in tests
    public static ResponseSpecification successResponse() {
        return new ResponseSpecBuilder()
                .expectResponseTime(lessThan(20000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static RequestSpecification baseRequestConfiguration(){
        return new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .addQueryParam("key", "e2f7d12ed03353803f8cefdadbe0b696")
                .addQueryParam("token", "24e04a2725169e6aa36aa2b989f1219aa1aa341c0d44a027ca8ca738b8af3f6b")
                .setContentType("application/json")
                .setBaseUri(TRELLO_API_URI)
                .build();
    }

    public static List<TrelloAnswer> getBoardsList() {
        Response answer = RestAssured
                .given(TrelloApi.baseRequestConfiguration())
                .log().everything()
                .get(MY_BOARDS)
                .prettyPeek();
        answer.then().specification(successResponse());
        List<TrelloAnswer> listAnswer = TrelloApi.getListTrelloAnswers(answer);
        return listAnswer;
    }

    public String getBoardByIdTest() {
        Response answer = RestAssured
                .given(baseRequestConfiguration())
                .log().all()
                .get(TRELLO_API_URI + BOARDS + ID_BOARD)
                .prettyPeek();
        answer.then().specification(successResponse());
        List<TrelloAnswerCard> answers = TrelloApi.getListTrelloAnswersCard(answer);
        ID_LIST = answers.get(0).idList;
        return answers.get(0).idList;
    }

    public void getBoardCardByIdTest() {
        Response answer = TrelloApi.with()
                .getBoardCardById(ID_BOARD)
                .callGetCardsApi();
        List<TrelloAnswer> answers = TrelloApi.getListTrelloAnswers(answer);
        answer.then().specification(successResponse());
    }

    public static List<TrelloAnswer> getListTrelloAnswers(Response response){
        return new Gson().fromJson(response.asString().trim(), new TypeToken<List<TrelloAnswer>>(){}.getType());
    }

    public static List<TrelloAnswerCard> getListTrelloAnswersCard(Response response){
        return new Gson().fromJson(response.asString().trim(), new TypeToken<List<TrelloAnswerCard>>(){}.getType());
    }


    public static TrelloAnswer getTrelloAnswers(Response response){
        return new Gson().fromJson(response.asString().trim(), new TypeToken<TrelloAnswer>(){}.getType());
    }
}