package homework.api;

import beans.TrelloAnswer;
import beans.TrelloAnswerCard;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static homework.api.ConstantTrello.BOARDS;
import static homework.api.TrelloApi.*;
import static homework.api.TrelloGetMetodsApi.*;
import static org.apache.commons.lang.RandomStringUtils.random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TrelloBoardJSONTests {
    @Test
    public String createNewBoardTest() {
        String boardName = "Lorem ipsum board " + random(12, true, true);
        Response answer = TrelloApiBuilder.with()
                .createName(boardName)
                .callPostBoardApi();
        answer.then().specification(successResponse());
        TrelloAnswer answers = getTrelloAnswers(answer);

        boolean key = false;
        List<TrelloAnswer> allBoard = getBoardsList();
        for (TrelloAnswer element : allBoard) {
            if (element.name.equals(boardName))
                key = true;
        }

        assertThat("Board creation", true, equalTo(key));

        return answers.id;
    }

    @Test
    public String createNewBoardTestWithLists() {
        String boardName = "Lorem ipsum board " + random(12, true, true);
        Response answer = TrelloApiBuilder.with()
                .createListsforBoard()
                .createName(boardName)
                .callPostBoardApi();
        answer.then().specification(successResponse());
        TrelloAnswer answers = getTrelloAnswers(answer);

        List<TrelloAnswer> allBoard = getBoardsList();
        List<TrelloAnswerCard> allCards = null;
        for (TrelloAnswer element : allBoard) {
            if (element.name.equals(boardName)) {
                allCards = getBoardCardsByIdTest(element.id);
            }
        }

        assertThat(allCards.size(), equalTo(3));

        return answers.id;
    }

    @Test
    public String createNewBoardTestWithDescriptions() {
        String boardName = "Lorem ipsum board " + random(12, true, true);
        String desc = "Lorem ipsum desc " + random(12, true, true);
        Response answer = TrelloApiBuilder.with()
                .createDescforBoard(desc)
                .createName(boardName)
                .callPostBoardApi();
        answer.then().specification(successResponse());
        TrelloAnswer answers = getTrelloAnswers(answer);

        List<TrelloAnswer> allBoard = getBoardsList();
        String descActual = "";
        for (TrelloAnswer element : allBoard) {
            if (element.name.equals(boardName))
                descActual = element.desc;
        }
        assertThat(descActual, equalTo(desc));

        return answers.id;
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

        assertThat(getBoardsList().size(), equalTo(count - 1));
    }
}