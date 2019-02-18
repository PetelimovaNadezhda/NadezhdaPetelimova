package homework.hw3;

public enum Users {
    PITER("epam", "1234", "PITER CHAILOVSKII");

    public final String login;
    public final String password;
    public final String name;

    Users(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public static Users getUserByUserName(String username) {
        for (Users user : values()) {
            if (user.name.equals(username)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Wrong user name: " + username);
    }
}