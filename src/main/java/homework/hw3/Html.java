package homework.hw3;

public enum Html {
    INDEX_HTML_URL("https://epam.github.io/JDI/"),
    HTML_SUB_URL("https://github.com/epam/JDI");

    public final String htmlName;

    Html(String html) {
        this.htmlName = html;
    }
}
