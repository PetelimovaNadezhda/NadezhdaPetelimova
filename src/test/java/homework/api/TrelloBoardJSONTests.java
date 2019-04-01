package homework.api;

import beans.TrelloAnswer;
import beans.TrelloAnswerCard;
import beans.TrelloAnswerList;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.List;

import static homework.api.ConstantTrello.*;
import static homework.api.TrelloApi.baseRequestConfiguration;
import static homework.api.TrelloApi.successResponse;
import static homework.api.TrelloGetAndGenerateMetodsApi.*;
import static org.apache.commons.lang.RandomStringUtils.random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class TrelloBoardJSONTests extends Hooks{
    @Test
    public void createNewBoardTest() {
        String boardName = "Lorem ipsum board " + random(5, true, true);
        Response answer = TrelloApiBuilder.with()
                .setName(boardName)
                .setID(NO_ID)
                .callApi(Method.POST, BOARDS, NO_PATH_GET);
        answer.then().specification(successResponse());

        boolean key = false;
        List<TrelloAnswer> allBoard = getBoardsList();

        for (TrelloAnswer element : allBoard) {
            if (element.name.equals(boardName))
                key = true;
        }

        //assertThat(allBoard, hasItem(Matchers.<TrelloAnswer>hasProperty("name", is(boardName))));

        assertThat("Board creation", key, is(true));
    }

    @Test
    public void createNewBoardTestWithLists() {
        String boardName = "Lorem ipsum board " + random(5, true, true);
        Response answer = TrelloApiBuilder.with()
                .setListsForBoard()
                .setName(boardName)
                .setID(NO_ID)
                .callApi(Method.POST, BOARDS, NO_PATH_GET);
        answer.then().specification(successResponse());

        List<TrelloAnswer> allBoard = getBoardsList();
        List<TrelloAnswerList> allLists = null;
        for (TrelloAnswer element : allBoard) {
            if (element.name.equals(boardName)) {
                allLists = getBoardListsByIdTest(element.id);
            }
        }

        assertThat(allLists, hasSize(3));
    }

    @Test
    public void createNewBoardTestWithDescriptions() {
        String boardName = "Lorem ipsum board " + random(5, true, true);
        String desc = "Lorem ipsum desc " + random(5, true, true);

        Response answer = TrelloApiBuilder.with()
                .setDescForBoard(desc)
                .setName(boardName)
                .setID(NO_ID)
                .callApi(Method.POST, BOARDS, NO_PATH_GET);
        answer.then().specification(successResponse());

        List<TrelloAnswer> allBoard = getBoardsList();

        String descActual = "";
        for (TrelloAnswer element : allBoard) {
            if (element.name.equals(boardName))
                descActual = element.desc;
        }
        assertThat(descActual, equalTo(desc));
    }

    @Test
    public void deleteBoardTestById() {
        String id = generateBoard().id;
        int count = getBoardsList().size();
        RestAssured
                .given(baseRequestConfiguration())
                .log().everything()
                .delete(BOARDS + id)
                .prettyPeek()
                .then()
                .specification(successResponse());

        assertThat(getBoardsList(), hasSize(count - 1));
    }

}
