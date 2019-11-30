package utils;

public class User {
    private String   name;

    public User() {
        this.name = "";
    }

    public User(String name) {
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
