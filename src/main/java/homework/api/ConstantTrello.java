package homework.api;

import static org.apache.commons.lang.RandomStringUtils.random;

public class ConstantTrello {
    public static final String TRELLO_API_URI = "https://api.trello.com/1/";
    public static final String BOARDS = "boards/";
    public static final String NAME_CARD = "Lorem ipsum card"  + random(5, true, true);
    public static final String POS_CARD = "top";
    public static final String ID_CHECKLIST = "5c93e1fbfe7aa6357b17a6d6";
    public static String ID_BOARD = "5c93ccfcc92bc46ddff19f46"; //Test board
    public static String ID_LIST = "5c93cd0702dc8e4cca7d4547";
    public static final String MY_BOARDS = "members/me/boards";
    public static final String CARDS = "/cards/";
    public static final String CARDS_API = "cards?idList=";
    public static final String CARDS_ID = "5c93e142f0f4d36165e146bf";
    public static final String CHECKLISTS = "checklists";
}
