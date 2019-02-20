package homework.hw6;

// TODO Basically, this is not the 'Table' at all.
// TODO What is the business sense on this entity ?

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public class Superhero {
    Integer number;
    String user;
    String description;

    public Superhero(String numberType, String user, String description) {
        this.number = Integer.parseInt(numberType);
        this.user = user;
        this.description = description.replaceAll("[\n ]", " ");
    }

}
