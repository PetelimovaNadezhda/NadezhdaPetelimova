package homework.hw8;

import homework.hw8.entities.MetalsColors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static homework.hw8.enums.Nature.setId;

// TODO Take a look on Gson library and TypeToken approach.
// TODO Be careful about data structure, that used in json file.
public class MetalsColorsParser {
    public static List<MetalsColors> dataMetalsColors() {
        List<String> summary = new ArrayList<>();
        List<String> element = new ArrayList<>();
        String color;
        String metal;
        List<String> vegetables = new ArrayList<>();
        setId();

        List<MetalsColors> checkForm = new ArrayList<>();
        try {
            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(
                    new FileReader("src\\main\\resources\\hw8\\JDI_ex8_metalsColorsDataSet.json"));
            for (Object iter : data.values()) {
                summary.clear();
                element.clear();
                vegetables.clear();

                JSONArray summaryJson = (JSONArray) ((JSONObject) iter).get("summary");
                JSONArray elementJson = (JSONArray) ((JSONObject) iter).get("elements");
                String colorsJson = (String) ((JSONObject) iter).get("color");
                String metalsJson = (String) ((JSONObject) iter).get("metals");
                JSONArray vegetablesJson = (JSONArray) ((JSONObject) iter).get("vegetables");

                for (Object s : summaryJson) {
                    summary.add(s.toString());
                }

                metal = metalsJson;

                color = colorsJson;

                for (Object s : elementJson) {
                    element.add(s.toString());
                }

                for (Object s : vegetablesJson) {
                    vegetables.add(s.toString());
                }

                checkForm.add(new MetalsColors(summary, element, color, metal, vegetables));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return checkForm;
    }
}
