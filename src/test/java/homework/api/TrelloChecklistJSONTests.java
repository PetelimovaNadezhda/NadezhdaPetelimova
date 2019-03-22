package homework.api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static homework.api.ConstantTrello.*;
import static homework.api.TrelloApi.successResponse;
import static homework.api.TrelloGetAndGenerateMetodsApi.*;
import static org.apache.commons.lang.RandomStringUtils.random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TrelloChecklistJSONTests extends Hooks{
    @Test
    public void createChecklistsTest() {
        String idBoard = generateBoard().id;
        String idCard = generateCard(idBoard).id;

        Response answer = TrelloApiBuilder.with()
                .setIDCard(idCard)
                .setID(NO_ID)
                .callPostApi(CHECKLISTS, NO_PATH_GET);
        answer.then().specification(successResponse());

        assertThat(getChecklists(idCard).size(), equalTo(1));
    }

    @Test
    public void createChecklistsWithNameTest() {
        String idBoard = generateBoard().id;
        String idCard = generateCard(idBoard).id;
        String name = "Lorem ipsum checklist " + random(5, true, true);

        Response answer = TrelloApiBuilder.with()
                .setName(name)
                .setIDCard(idCard)
                .setID(NO_ID)
                .callPostApi(CHECKLISTS, NO_PATH_GET);
        answer.then().specification(successResponse());

        assertThat(getChecklists(idCard).get(0).name, equalTo(name));
    }

    @Test
    public void createCheckItemTest() {
        String idBoard = generateBoard().id;
        String idCard = generateCard(idBoard).id;
        String idChecklist = generateChecklist(idCard).id;
        String name = "Lorem ipsum checkItems " + random(5, true, true);

        Response answer = TrelloApiBuilder.with()
                .setName(name)
                .setID(idChecklist)
                .callPostApi(CHECKLISTS, CHECK_ITEMS);
        answer.then().specification(successResponse());

        assertThat(getChecklists(idCard).get(0).checkItems.get(0).name, equalTo(name));
    }
}
