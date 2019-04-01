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

import java.lang.reflect.Type;

import static homework.api.ConstantTrello.TRELLO_API_URI;
import static org.hamcrest.Matchers.lessThan;

public class TrelloApi {
    static ResponseSpecification successResponse() {
        return new ResponseSpecBuilder()
                .expectResponseTime(lessThan(20000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    static RequestSpecification baseRequestConfiguration() {
        return new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .addQueryParam("key", KEY )
                .addQueryParam("token", TOKEN)
                .setContentType("application/json")
                .setBaseUri(TRELLO_API_URI)
                .build();
    }

    public static <B> B deserializeResponse(Response response, Type beanClass) {
        return new Gson().fromJson(response.asString().trim(), beanClass);
    }
}
