package homework.hw3;

public enum TextForImg {
    PRACTICES_PICTURE_TEXT("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project"),
    CUSTOM_PICTURE_TEXT("To be flexible and\n" +
            "customizable"),
    MULTI_PICTURE_TEXT("To be multiplatform"),
    BASE_PICTURE_TEXT("Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…");

    public final String text;

    TextForImg(String text) {
        this.text = text;
    }
}
