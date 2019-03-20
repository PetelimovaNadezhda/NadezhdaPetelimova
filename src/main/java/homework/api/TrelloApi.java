package homework.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import io.restassured.response.Response;

import java.util.HashMap;

import static org.hamcrest.Matchers.lessThan;

public class TrelloApi {

    public static final String BOARDS = "/boards";

    private HashMap<String, String> params = new HashMap<>();

    public static class ApiBuilder {
        TrelloApi trelloApi;

        private ApiBuilder(TrelloApi gcApi) {
            trelloApi = gcApi;
        }

        public ApiBuilder boardsGet(String text) {
            trelloApi.params.put("text", text);
            return this;
        }

        public Response callApi() {
            return RestAssured.with()
                    .queryParams(trelloApi.params)
                    .log().all()
                    .get(YANDEX_SPELLER_API_URI).prettyPeek();
        }
    }
    public static ApiBuilder with() {
        TrelloApi api = new TrelloApi();
        return new ApiBuilder(api);
    }

    public static final String YANDEX_SPELLER_API_URI =
            "https://api.trello.com/1/members/me/boards/5c8ceb1d09764d100f188768/cards?key=e2f7d12ed03353803f8cefdadbe0b696&token=24e04a2725169e6aa36aa2b989f1219aa1aa341c0d44a027ca8ca738b8af3f6b}";


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
                .addQueryParam("key", "e2f7d12ed03353803f8cefdadbe0b696")
                .addQueryParam("token", "24e04a2725169e6aa36aa2b989f1219aa1aa341c0d44a027ca8ca738b8af3f6b")
                .setContentType("application/json")
                .build();
    }

}