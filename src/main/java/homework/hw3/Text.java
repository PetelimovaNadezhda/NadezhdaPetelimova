package homework.hw3;

public enum Text {
    PRACTICES_PICTURE_TEXT("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project"),
    CUSTOM_PICTURE_TEXT("To be flexible and\n" +
            "customizable"),
    MULTI_PICTURE_TEXT("To be multiplatform"),
    BASE_PICTURE_TEXT("Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…"),
    MAIN_TITLE_TEXT("EPAM FRAMEWORK WISHES…"),
    MAIN_SUB_TITLE_TEXT("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    MAIN_SUB_TEXT("JDI GITHUB"),
    HOME_PAGE_TITLE("Home Page");

    public final String text;

    Text(String text) {
        this.text = text;
    }
}
