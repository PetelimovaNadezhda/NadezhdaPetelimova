package homework.api;

import beans.TrelloAnswer;
import beans.TrelloAnswerCard;
import beans.TrelloAnswerChecklist;
import beans.TrelloAnswerList;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

import static homework.api.ConstantTrello.*;
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

    static List<TrelloAnswerList> getBoardListsByIdTest(String id) {
        Response answer = TrelloApiBuilder.with()
                .getID(id)
                .callGetApi(BOARDS, "/lists");
        answer.then().specification(successResponse());
        return getListTrelloAnswersList(answer);
    }

    static List<TrelloAnswerCard> getBoardCardsByIdTest(String id) {
        Response answer = TrelloApiBuilder.with()
                .getID(id)
                .callGetApi(BOARDS, "/cards");
        answer.then().specification(successResponse());
        return getListTrelloAnswersCards(answer);
    }

    static TrelloAnswer generateBoard() {
        String boardName = "Lorem ipsum board " + random(12, true, true);
        Response answer = TrelloApiBuilder.with()
                .createListsforBoard()
                .createName(boardName)
                .callPostBoardApi();
        return getTrelloAnswers(answer);
    }

    static TrelloAnswerCard generateCard(String id) {
        String nameCard = "Lorem ipsum card " + random(5, true, true);

        Response answer = TrelloApiBuilder.with()
                .createName(nameCard)
                .getidList(id)
                .callPostCardApi();
        answer.then().specification(successResponse());

        TrelloAnswerCard answers = getListTrelloAnswersCard(answer);
        return answers;
    }

    static List<TrelloAnswerChecklist> getChecklists(String idCard) {
        Response answer = TrelloApiBuilder.with()
                .getID(idCard)
                .callGetApi(CARDS, "/checklists");
        answer.then().specification(successResponse());
        return getListTrelloAnswersChecklist(answer);
    }

    static TrelloAnswerChecklist generateChecklist(String idCard) {
        Response answer = TrelloApiBuilder.with()
                .getIDCard(idCard)
                .getID("")
                .callPostChecklistApi("");
        answer.then().specification(successResponse());
        return getListTrelloAnswersChecklistObject(answer);
    }


}

