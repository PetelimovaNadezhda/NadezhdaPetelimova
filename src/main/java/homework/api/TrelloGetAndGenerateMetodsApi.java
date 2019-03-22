package homework.api;

import beans.TrelloAnswer;
import beans.TrelloAnswerCard;
import beans.TrelloAnswerChecklist;
import beans.TrelloAnswerList;
import io.restassured.response.Response;

import java.util.List;

import static homework.api.ConstantTrello.*;
import static homework.api.TrelloApi.*;
import static org.apache.commons.lang.RandomStringUtils.random;

class TrelloGetAndGenerateMetodsApi {
    static List<TrelloAnswer> getBoardsList() {
        Response answer =TrelloApiBuilder.with()
                .setID(NO_ID)
                .callGetApi(MY_BOARDS, NO_PATH_GET);
        answer.then().specification(successResponse());
        return getListTrelloAnswers(answer);
    }

    static List<TrelloAnswerList> getBoardListsByIdTest(String id) {
        Response answer = TrelloApiBuilder.with()
                .setID(id)
                .callGetApi(BOARDS, LISTS);
        answer.then().specification(successResponse());
        return getListTrelloAnswersList(answer);
    }

    static List<TrelloAnswerCard> getBoardCardsByIdTest(String id) {
        Response answer = TrelloApiBuilder.with()
                .setID(id)
                .callGetApi(BOARDS, "/cards");
        answer.then().specification(successResponse());
        return getListTrelloAnswersCard(answer);
    }

    static List<TrelloAnswerChecklist> getChecklists(String idCard) {
        Response answer = TrelloApiBuilder.with()
                .setID(idCard)
                .callGetApi(CARDS, "/checklists");
        answer.then().specification(successResponse());
        return getListTrelloAnswersChecklist(answer);
    }

    static TrelloAnswer generateBoard() {
        String boardName = "Lorem ipsum board " + random(5, true, true);
        Response answer = TrelloApiBuilder.with()
                .setListsForBoard()
                .setName(boardName)
                .setID(NO_ID)
                .callPostApi(BOARDS, NO_PATH_GET);
        return getTrelloAnswers(answer);
    }

    static TrelloAnswerCard generateCard(String id) {
        String nameCard = "Lorem ipsum card " + random(5, true, true);

        Response answer = TrelloApiBuilder.with()
                .setName(nameCard)
                .setIDList(id)
                .setID(NO_ID)
                .callPostApi(CARDS, NO_PATH_GET);
        answer.then().specification(successResponse());

        return getTrelloAnswersCard(answer);
    }

    static TrelloAnswerChecklist generateChecklist(String idCard) {
        Response answer = TrelloApiBuilder.with()
                .setIDCard(idCard)
                .setID(NO_ID)
                .callPostApi(CHECKLISTS, NO_PATH_GET);
        answer.then().specification(successResponse());
        return getTrelloAnswersChecklist(answer);
    }
}

