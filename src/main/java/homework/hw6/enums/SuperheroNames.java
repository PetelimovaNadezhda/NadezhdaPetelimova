package homework.hw6.enums;

public enum SuperheroNames{
    ROMAN("Roman", "roman"),
    IVAN("Sergey Ivan", "ivan"),
    VLAD("Vladzimir", "vlad"),
    HELEN("Helen Bennett", "helen"),
    YOSHI("Yoshi Tannamuri", "yoshi"),
    GIO("Giovanni Rovelli", "gio");

    public final String name;
    public final String id;

    SuperheroNames(String name, String id) {
        this.id = id;
        this.name = name;
    }

    public static SuperheroNames getUsersTable(String value) {
        for (SuperheroNames val : SuperheroNames.values()) {
            if (val.name.equals(value))
                return val;
        }
        return null;
    }
}
