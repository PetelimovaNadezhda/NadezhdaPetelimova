package homework.api;

import beans.TrelloAnswer;
import beans.TrelloAnswerCard;
import beans.TrelloAnswerList;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

import static homework.api.ConstantTrello.BOARDS;
import static homework.api.ConstantTrello.MY_BOARDS;
import static homework.api.TrelloApi.*;
import static org.apache.commons.lang.RandomStringUtils.random;

public class TrelloGetMetodsApi {
    static List<TrelloAnswer> getBoardsList() {
        Response answer = RestAssured
                .given(baseRequestConfiguration())
                .log().everything()
                .get(MY_BOARDS)
                .prettyPeek();
        answer.then().specification(successResponse());
        List<TrelloAnswer> listAnswer = getListTrelloAnswers(answer);
        return listAnswer;
    }

    public static TrelloAnswer getBoardByIdTest(String id) {
        Response answer = RestAssured
                .given(baseRequestConfiguration())
                .log().all()
                .get(BOARDS + id)
                .prettyPeek();
        answer.then().specification(successResponse());
        TrelloAnswer answers = getTrelloAnswers(answer);
        return answers;
    }

    static List<TrelloAnswerCard> getBoardCardsByIdTest(String id) {
        Response answer = TrelloApiBuilder.with()
                .getBoardCardById(id)
                .callGetCardsApi();
        answer.then().specification(successResponse());
        return getListTrelloAnswersCard(answer);
    }

    static List<TrelloAnswerList> getBoardListsByIdTest(String id) {
        Response answer = TrelloApiBuilder.with()
                .getBoardCardById(id)
                .getidList()
                .callGetCardsApi();
        answer.then().specification(successResponse());
        return getListTrelloAnswersList(answer);
    }

    static TrelloAnswer generateBoard() {
        String boardName = "Lorem ipsum board " + random(12, true, true);
        Response answer = TrelloApiBuilder.with()
                .createListsforBoard()
                .createName(boardName)
                .callPostBoardApi();
        return getTrelloAnswers(answer);
    }

    static List<TrelloAnswerCard> generateCard() {
        String cardName = "Lorem ipsum board " + random(12, true, true);
        Response answer = TrelloApiBuilder.with()
                .createName(cardName)
                .getidList()
                .callPostCardApi();
        return getListTrelloAnswersCard(answer);
    }
}
