package homework.hw6;

public enum UsersTable {
    ROMAN("Roman", "roman"),
    IVAN("Sergey Ivan", "ivan"),
    VLAD("Vladzimir", "vlad"),
    HELEN("Helen Bennett", "helen"),
    YOSHI("Yoshi Tannamuri", "yoshi"),
    GIO("Giovanni Rovelli", "gio");

    public final String name;
    public final String id;

    UsersTable(String name, String id) {
        this.id = id;
        this.name = name;
    }
}
