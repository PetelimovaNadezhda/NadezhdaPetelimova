package homework.hw7.entities;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class MetalsColors {

    public static MetalsColors checkForm = new MetalsColors(
            Arrays.asList("3", "8"),
            Arrays.asList("Water", "Fire"),
            "Red",
            "Selen",
            Arrays.asList("Vegetables", "Cucumber", "Tomato")
    );

    public List<String> summary;
    public List<String> element;
    public String color;
    public String metal;
    public List<String> vegetables;
}
