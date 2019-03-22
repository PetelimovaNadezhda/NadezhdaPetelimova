package homework.api;

import beans.TrelloAnswer;
import beans.TrelloAnswerCard;
import beans.TrelloAnswerChecklist;
import beans.TrelloAnswerList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.util.List;

import static homework.api.ConstantTrello.TRELLO_API_URI;
import static org.hamcrest.Matchers.lessThan;

public class TrelloApi {
    //set base request and response specifications tu use in tests
    public static ResponseSpecification successResponse() {
        return new ResponseSpecBuilder()
                .expectResponseTime(lessThan(20000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static RequestSpecification baseRequestConfiguration() {
        return new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .addQueryParam("key", KEY)
                .addQueryParam("token", TOKEN)
                .setContentType("application/json")
                .setBaseUri(TRELLO_API_URI)
                .build();
    }

    public static List<TrelloAnswer> getListTrelloAnswers(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<List<TrelloAnswer>>() {
        }.getType());
    }

    public static List<TrelloAnswerCard> getListTrelloAnswersCards(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<List<TrelloAnswerCard>>() {
        }.getType());
    }

    public static TrelloAnswerCard getListTrelloAnswersCard(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<TrelloAnswerCard>() {
        }.getType());
    }

    public static List<TrelloAnswerList> getListTrelloAnswersList(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<List<TrelloAnswerList>>() {
        }.getType());
    }

    public static TrelloAnswer getTrelloAnswers(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<TrelloAnswer>() {
        }.getType());
    }


    public static List<TrelloAnswerChecklist> getListTrelloAnswersChecklist(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<List<TrelloAnswerChecklist>>() {
        }.getType());
    }

    public static TrelloAnswerChecklist getListTrelloAnswersChecklistObject(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<TrelloAnswerChecklist>() {
        }.getType());
    }
}
