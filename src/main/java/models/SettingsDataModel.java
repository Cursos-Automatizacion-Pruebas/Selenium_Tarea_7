package models;

import com.github.javafaker.Faker;

public class SettingsDataModel {
    private final String urlProfile;
    private final String bio;
    private final String password;

    public SettingsDataModel() {
        var faker= new Faker();
        urlProfile=faker.internet().url();
        bio = faker.random().hex();
        password = faker.internet().password();

    }

    public String getUrlProfile() {
        return urlProfile;
    }

    public String getBio() {
        return bio;
    }

    public String getPassword() {
        return password;
    }
}
