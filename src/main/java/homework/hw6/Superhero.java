package homework.hw6;

import java.util.Objects;

import static java.lang.String.*;

// TODO Basically, this is not the 'Table' at all.
// TODO What is the business sense on this entity ?
public class Superhero {
    public static final String TEMPLATE = "%s%s%s";

    private Integer number;
    private String user;
    private String description;

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public Integer getNumber() {
        return number;
    }

    public Superhero(String numberType, String user, String description) {
        this.number = Integer.parseInt(numberType);
        this.user = user;
        this.description = description.replaceAll("[\n ]", " ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Superhero table = (Superhero) o;
        return Objects.equals(number, table.number) &&
                Objects.equals(user, table.user) &&
                Objects.equals(description, table.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, user, description);
    }

    @Override
    public String toString() {
        return format(TEMPLATE, number, user, description)
                .replaceAll("[\n ]", "");
    }
}
