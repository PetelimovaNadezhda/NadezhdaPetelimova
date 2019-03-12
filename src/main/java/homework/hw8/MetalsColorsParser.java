package homework.hw8;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import homework.hw7.entities.MetalsColors;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;

public class MetalsColorsParser {
    public static Collection<MetalsColors> dataMetalsColors() throws FileNotFoundException {
        Gson gson = new Gson();
        Type fooType = new TypeToken<HashMap<String, MetalsColors>>() {
        }.getType();
        JsonElement jsonData = new JsonParser()
                .parse(new FileReader("src/main/resources/hw8/JDI_ex8_metalsColorsDataSet.json"));
        HashMap<String, MetalsColors> data = gson.fromJson(jsonData, fooType);
        return data.values();
    }
}
