package homework.hw7;

import homework.hw7.pages.IndexPageJdi;
import homework.hw7.pages.MetalsColorsPageJdi;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://epam.github.io/JDI/")
public class JDISite {
    @Url("index.html")
    public static IndexPageJdi indexPageJdi;

    @Url("metals-colors.html")
    public static MetalsColorsPageJdi metalColorsPageJdi;
}