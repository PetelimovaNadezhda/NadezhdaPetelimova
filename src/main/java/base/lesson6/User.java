package base.lesson6;

public enum User {
    PITER("epam", "1234", "PITER CHAILOVSKII");

    public final String login;
    public final String password;
    public final String name;

    User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public static User getUserByUserName(String username) {
        for (User user : values()) {
            if (user.name.equals(username)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Wrong user name: " + username);
    }
}