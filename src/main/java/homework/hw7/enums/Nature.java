package homework.hw7.enums;

import java.util.HashMap;

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
        idElement.put(WATER.value, 0);
        idElement.put(EARTH.value, 1);
        idElement.put(WIND.value, 2);
        idElement.put(FIRE.value, 3);
    }
}
