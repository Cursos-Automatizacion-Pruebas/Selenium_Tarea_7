package models;

import com.github.javafaker.Faker;

public class UserDataModel {
    private final String user;
    private final String email;
    private final String password;

    public UserDataModel() {
        var faker = new Faker();
        user = faker.name().username();
        email = faker.internet().emailAddress();
        password = faker.internet().password();
    }

    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
