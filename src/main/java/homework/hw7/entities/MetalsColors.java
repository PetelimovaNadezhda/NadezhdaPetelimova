package homework.hw7.entities;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO Oh my good.
@AllArgsConstructor
public class MetalsColors {

    public static MetalsColors checkForm = new MetalsColors(new ArrayList<String>(Arrays.asList("3", "8")), new ArrayList<String>(Arrays.asList("Water", "Fire")), "Red", "Selen", new ArrayList<String>(Arrays.asList("Vegetables", "Cucumber", "Tomato")));

    public List<String> summary;
    public List<String> element;
    public String color;
    public String metal;
    public List<String> vegetables;
}

// TODO You can generate log in real time.
// TODO It is completely prohibited to create class in this way.
// TODO Every field should represent only one purpose !!


