package homework.hw7.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class MetalsColors {

    public static MetalsColors checkForm = new MetalsColors(
            Arrays.asList(3, 8),
            Arrays.asList("Water", "Fire"),
            "Red",
            "Selen",
            Arrays.asList("Cucumber", "Tomato")
    );

    public List<Integer> summary;
    public List<String> elements;
    public String color;
    public String metals;
    public List<String> vegetables;

    public String asLogString() {
        return String.join("", new ArrayList<String>() {{
            add("Summary: ");
            add(Integer.toString(summary.stream().mapToInt(i -> i).sum()));
            add("\nElements: ");
            add(String.join(", ", elements));
            add("\nColor: ");
            add(color);
            add("\nMetal: ");
            add(metals);
            add("\nVegetables: ");
            add(String.join(", ", vegetables));
        }});
    }
}
