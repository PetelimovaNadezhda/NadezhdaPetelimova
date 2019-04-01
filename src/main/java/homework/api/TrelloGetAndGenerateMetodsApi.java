package homework.api;

import beans.TrelloAnswer;
import beans.TrelloAnswerCard;
import beans.TrelloAnswerChecklist;
import beans.TrelloAnswerList;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.util.List;

import static homework.api.ConstantTrello.*;
import static homework.api.TrelloApi.*;
import static org.apache.commons.lang.RandomStringUtils.random;

class TrelloGetAndGenerateMetodsApi {
    static List<TrelloAnswer> getBoardsList() {
        Response answer = TrelloApiBuilder.with()
                .setID(NO_ID)
                .callApi(Method.GET, MY_BOARDS, NO_PATH_GET);
        answer.then().specification(successResponse());
        return deserializeResponse(answer, new TypeToken<List<TrelloAnswer>>() {
        }.getType());
    }

    static List<TrelloAnswerList> getBoardListsByIdTest(String id) {
        Response answer = TrelloApiBuilder.with()
                .setID(id)
                .callApi(Method.GET, BOARDS, LISTS);
        answer.then().specification(successResponse());
        return deserializeResponse(answer, new TypeToken<List<TrelloAnswerList>>() {
        }.getType());
    }

    static List<TrelloAnswerCard> getBoardCardsByIdTest(String id) {
        Response answer = TrelloApiBuilder.with()
                .setID(id)
                .callApi(Method.GET, BOARDS, "/cards");
        answer.then().specification(successResponse());
        return deserializeResponse(answer, new TypeToken<List<TrelloAnswerCard>>() {
        }.getType());
    }

    static List<TrelloAnswerChecklist> getChecklists(String idCard) {
        Response answer = TrelloApiBuilder.with()
                .setID(idCard)
                .callApi(Method.GET, CARDS, "/checklists");
        answer.then().specification(successResponse());
        return deserializeResponse(answer, new TypeToken<List<TrelloAnswerChecklist>>() {
        }.getType());
    }

    static TrelloAnswer generateBoard() {
        String boardName = "Lorem ipsum board " + random(5, true, true);
        Response answer = TrelloApiBuilder.with()
                .setListsForBoard()
                .setName(boardName)
                .setID(NO_ID)
                .callApi(Method.POST, BOARDS, NO_PATH_GET);
        return deserializeResponse(answer, TrelloAnswer.class);
    }

    static TrelloAnswerCard generateCard(String id) {
        String nameCard = "Lorem ipsum card " + random(5, true, true);

        Response answer = TrelloApiBuilder.with()
                .setName(nameCard)
                .setIDList(id)
                .setID(NO_ID)
                .callApi(Method.POST, CARDS, NO_PATH_GET);
        answer.then().specification(successResponse());
        return deserializeResponse(answer, TrelloAnswerCard.class);
    }

    static TrelloAnswerChecklist generateChecklist(String idCard) {
        Response answer = TrelloApiBuilder.with()
                .setIDCard(idCard)
                .setID(NO_ID)
                .callApi(Method.POST, CHECKLISTS, NO_PATH_GET);
        answer.then().specification(successResponse());
        return deserializeResponse(answer, TrelloAnswerChecklist.class);
    }
}

