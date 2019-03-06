package homework.hw7.entities;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO Oh my good.
@AllArgsConstructor
public class MetalsColors {
    public static MetalsColors COLOR = new MetalsColors("Red");
    public static MetalsColors METAL = new MetalsColors("Selen");
    public static MetalsColors SUMMARY = new MetalsColors(new ArrayList<>(Arrays.asList("3", "8")));
    //public static MetalsColors ELEMENT = new MetalsColors(new ArrayList<>(Arrays.asList("Water", "Fire")));
    public static MetalsColors VEGETABLES = new MetalsColors(new ArrayList<>(Arrays.asList("Vegetables", "Cucumber", "Tomato")));
    // TODO You can generate log in real time.
    public static MetalsColors LOG = new MetalsColors("Summary: 11\n" + "Elements: Water, Fire\n" + "Color: Red\n" + "Metal: Selen\n" + "Vegetables: Cucumber, Tomato");

    public List<String> summary;
    //public List<String> element;
    public String color;
    public String metal;
    public List<String> vegetables;
    public String logList;

    // TODO It is completely prohibited to create class in this way.
    // TODO Every field should represent only one purpose !!
    public MetalsColors(String val) {
        this.color = val;
        this.metal = val;
        this.logList = val;
    }

    public MetalsColors(ArrayList<String> vals) {
        this.summary = vals;
        //this.element = vals;
        this.vegetables = vals;
    }
}
