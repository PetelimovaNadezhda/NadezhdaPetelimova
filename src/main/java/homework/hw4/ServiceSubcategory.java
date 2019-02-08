package homework.hw4;

public enum ServiceSubcategory {
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    USER_TABLE("User Table"),
    TABLES_WITH_PAGES("Table with pages"),
    DIFFERENT("Different elements"),
    PERFORMANCE("Performance");

    public final String text;

    ServiceSubcategory(String text) {
        this.text = text;
    }
}
