package homework.hw6;

public enum UsersTableNames{
    ROMAN("Roman", "roman"),
    IVAN("Sergey Ivan", "ivan"),
    VLAD("Vladzimir", "vlad"),
    HELEN("Helen Bennett", "helen"),
    YOSHI("Yoshi Tannamuri", "yoshi"),
    GIO("Giovanni Rovelli", "gio");

    public final String name;
    public final String id;

        UsersTableNames(String name, String id) {
        this.id = id;
        this.name = name;
    }

    public static UsersTableNames getUsersTable(String value) {
        for (UsersTableNames val : UsersTableNames.values()) {
            if (val.name.equals(value))
                return val;
        }
        return null;
    }
}
