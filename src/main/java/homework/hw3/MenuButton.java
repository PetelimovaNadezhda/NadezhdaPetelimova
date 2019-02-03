package homework.hw3;

public enum MenuButton {
    HOME_BUTTON("HOME"),
    CONTACT_FORM_BUTTON("CONTACT FORM"),
    SERVICE_BUTTON("SERVICE"),
    METALS_COLORS_BUTTON("METALS & COLORS");

    public final String buttonName;

    MenuButton(String button) {
        this.buttonName = button;
    }
}
