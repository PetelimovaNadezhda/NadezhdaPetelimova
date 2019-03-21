package homework.api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static homework.api.TrelloApi.successResponse;
import static org.apache.commons.lang.RandomStringUtils.random;

public class TrelloChecklistJSONTests {
    @Test
    public void createChecklistsTest() {
        Response answer = TrelloApiBuilder.with()
                .getIDCard()
                .callPostChecklistApi();
        answer.then().specification(successResponse());
    }

    @Test
    public void createChecklistsWithNameTest() {
        String name = "Lorem ipsum checklist " + random(12, true, true);
        Response answer = TrelloApiBuilder.with()
                .createName(name)
                .getIDCard()
                .callPostChecklistApi();
        answer.then().specification(successResponse());
    }

//    @Test
//    public void createCheckItemTest() {
//        String name = "Lorem ipsum checkItems " + random(12, true, true);
//        Response answer = TrelloApiBuilder.with()
//                .getID()
//                .createName(name)
//                .callPostChecklistApi();
//        answer.then().specification(successResponse());
//    }
}
