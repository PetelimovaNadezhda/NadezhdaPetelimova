package homework.hw4;

public enum LogPatterns {
    ELEMENTS("%s: condition changed to %s"),
    METAL_COLOR("%s: value changed to %s");

    public final String patterns;

    LogPatterns(String patterns) {
        this.patterns = patterns;
    }
}
