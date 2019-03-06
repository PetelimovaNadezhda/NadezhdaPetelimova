package homework.hw8.enums;

import java.util.HashMap;
import java.util.Hashtable;

public enum Nature {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public String value;

    Nature(String value) {
        this.value = value;
    }

    public static HashMap<String, Integer> idElement = new HashMap<>();
    public static void setId() {
        idElement.put(WATER.value, 1);
        idElement.put(EARTH.value, 2);
        idElement.put(WIND.value, 3);
        idElement.put(FIRE.value, 4);
    }

}
