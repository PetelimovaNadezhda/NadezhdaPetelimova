package homework.hw4;

public enum Regex {
    WIND_TRUE("Wind: condition changed to true"),
    WIND_FALSE("Wind: condition changed to false"),
    WATER_TRUE("Water: condition changed to true"),
    WATER_FALSE("Water: condition changed to false"),
    METAL_SELEN("metal: value changed to Selen"),
    COLOR_YELLOW("Colors: value changed to Yellow");

    public final String  regex;

    Regex(String regex) {
        this.regex = regex;
    }
}
