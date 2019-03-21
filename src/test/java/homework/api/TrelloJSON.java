package homework.api;

import beans.TrelloAnswer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static homework.api.ConstantTrello.*;
import static homework.api.TrelloApi.*;
import static org.apache.commons.lang.RandomStringUtils.random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TrelloJSON {
    @Test
    public void createNewBoardTest(){
        String boardName = "Lorem ipsum board " + random(12, true, true);
        Response answer = TrelloApi.with()
                .createName(boardName)
                .callPostBoardApi();
        answer.then().specification(successResponse());
        TrelloAnswer answers =  TrelloApi.getTrelloAnswers(answer);
        assertThat(answers.name, equalTo(boardName));
        ID_BOARD = answers.id;
    }

    @Test
    public void createNewBoardTestWithLists() throws IOException {
        String boardName = "Lorem ipsum board " + random(12, true, true);
        Response answer = TrelloApi.with()
                .createListsforBoard()
                .createName(boardName)
                .callPostBoardApi();
        answer.then().specification(successResponse());
        TrelloAnswer answers =  TrelloApi.getTrelloAnswers(answer);
        assertThat(answers.name, equalTo(boardName));
        ID_BOARD = answers.id;
    }


    @Test
    public void createNewBoardTestWithDescriptions() throws IOException {
        String boardName = "Lorem ipsum board " + random(12, true, true);
        String desc = "Lorem ipsum desc " + random(12, true, true);
        Response answer = TrelloApi.with()
                .createDescforBoard(desc)
                .createName(boardName)
                .callPostBoardApi();
        answer.then().specification(successResponse());
        TrelloAnswer answers =  TrelloApi.getTrelloAnswers(answer);
        assertThat(answers.name, equalTo(boardName+",name"));
        ID_BOARD = answers.id;
    }


    @Test
    public void deleteBoardTestById() {
        int count = TrelloApi.getBoardsList().size();
        RestAssured
                .given(baseRequestConfiguration())
                .log().everything()
                .delete(BOARDS + ID_BOARD)
                .prettyPeek()
                .then()
                .specification(successResponse());
        assertThat(TrelloApi.getBoardsList().size(), equalTo(count-1));
    }


    @Test
    public void createCardWithNameTest() {
        String name = NAME_CARD;
        Response answer = TrelloApi.with()
                .createName(NAME_CARD)
                .callPostCardApi();
        answer.then().specification(successResponse());
    }

    @Test
    public void createCardWithPosTest() {
        String name = NAME_CARD;
        Response answer = TrelloApi.with()
                .createName(NAME_CARD)
                .createCardPos(POS_CARD)
                .callPostCardApi();
        answer.then().specification(successResponse());
    }

    @Test
    public void deleteCardByIDTest() {
        RestAssured
                .given(baseRequestConfiguration())
                .log().everything()
                .delete(CARDS + CARDS_ID)
                .prettyPeek()
                .then()
                .specification(successResponse());
    }

    @Test
    public void createChecklistsTest() {
        Response answer = TrelloApi.with()
                .getIDCard()
                .callPostChecklistApi();
        answer.then().specification(successResponse());
    }


    @Test
    public void createChecklistsWithNameTest() {
        String name = "Lorem ipsum checklist " + random(12, true, true);
        Response answer = TrelloApi.with()
                .createName(name)
                .getIDCard()
                .callPostChecklistApi();
        answer.then().specification(successResponse());
    }

    @Test
    public void createCheckItemTest() {
        String name = "Lorem ipsum checkItems " + random(12, true, true);
        Response answer = TrelloApi.with()
                .getIDCheckList()
                .createName(name)
                .callPostChecklistApi();
        answer.then().specification(successResponse());
    }

}
