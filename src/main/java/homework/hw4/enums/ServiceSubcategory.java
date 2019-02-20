package homework.hw4.enums;

import java.util.List;

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

    public static ServiceSubcategory getServiceSubcategory(String value) {
        for (ServiceSubcategory val : ServiceSubcategory.values()) {
            if (val.text.equals(value))
                return val;
        }
        return null;
    }


    public static ServiceSubcategory[] valueOfList(List<String> expected) {
        ServiceSubcategory[] result = new ServiceSubcategory[expected.size()];
        int i = 0;
        for (String exp : expected) {
            result[i] = ServiceSubcategory.getServiceSubcategory(exp);
            i++;
        }
        return result;
    }
}
