package homework.api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static homework.api.TrelloApi.successResponse;
import static java.lang.String.format;
import static org.apache.commons.lang.RandomStringUtils.random;

public class TrelloJSON {
    String boardName = "Lorem ipsum board " + random(12, true, true);

    @Test
    public void createNewBoardTest() throws UnsupportedEncodingException {
        RestAssured
                .given(TrelloApi.baseRequestConfiguration())
                .body(format("{\"name\": \"%s\"}", boardName))
                .log().everything()
                .post("boards/?name=name&defaultLabels=true&defaultLists=true&keepFromSource=none&prefs_permissionLevel=private&prefs_voting=disabled&prefs_comments=members&prefs_invitations=members&prefs_selfJoin=true&prefs_cardCovers=true&prefs_background=blue&prefs_cardAging=regular")
                .prettyPeek();
}

    @Test
    public void reachBuilderUsage(){
        TrelloApi.with()
                .boardsGet(boardName)
                .callApi()
                .then().specification(successResponse())
                .log().everything();
    }
}
