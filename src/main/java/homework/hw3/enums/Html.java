package homework.hw3.enums;

public enum Html {
    INDEX_HTML_URL("https://epam.github.io/JDI/"),
    HTML_SUB_URL("https://github.com/epam/JDI"),
    HTML_USER_TABLE("https://epam.github.io/JDI/user-table.html");

    public final String htmlName;

    Html(String html) {
        this.htmlName = html;
    }
}
