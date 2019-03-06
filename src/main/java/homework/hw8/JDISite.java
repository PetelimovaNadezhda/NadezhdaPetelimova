package homework.hw8;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import homework.hw8.pages.IndexPageJdi;
import homework.hw8.pages.MetalsColorsPageJdi;

@JSite("https://epam.github.io/JDI/")
public class JDISite {
    @Url("index.html")
    public static IndexPageJdi indexPageJdi;

    @Url("metals-colors.html")
    public static MetalsColorsPageJdi metalColorsPageJdi;
}