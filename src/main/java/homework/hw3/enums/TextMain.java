package homework.hw3.enums;

public enum TextMain {
    MAIN_TITLE_TEXT("EPAM FRAMEWORK WISHES…"),
    MAIN_SUB_TITLE_TEXT("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    MAIN_SUB_TEXT("JDI GITHUB"),
    HOME_PAGE_TITLE("Home Page");

    public final String text;

    TextMain(String text) {
        this.text = text;
    }
}
