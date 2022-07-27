package utilities;

import models.ArticleDataModel;
import models.CredentialsModel;
import models.SettingsDataModel;
import models.UserDataModel;
import org.testng.annotations.DataProvider;

public class DataProviders {
    private final Logs log = new Logs();
    public static final String BAD_USER_INFO_DP = "Bad USER Info Data Provider";

    public CredentialsModel getValidCredentials() {
        log.debug("Cogiendo las credenciales válidas");
        var credentialsMap = new MapParser().getCredentialsMap();
        return credentialsMap.get("1");
    }

    /*public CredentialsModel getLockedCredentials() {
        log.debug("Cogiendo las credenciales inválidas");
        var credentialsMap = new MapParser().getCredentialsMap();
        return credentialsMap.get("locked");
    }

    public String getLockedMessage() {
        return "Epic sadface: Sorry, this user has been locked out.";
    }*/

    public UserDataModel getUserData() {
        return new UserDataModel();
    }

    public ArticleDataModel getArticleData() {
        return new ArticleDataModel();
    }

    public SettingsDataModel getSettingsData() {
        return new SettingsDataModel();
    }

    @DataProvider(name = BAD_USER_INFO_DP)
    public Object[][] badCredentialsDataProvider() {
        var userData = new UserDataModel();
        var errorMessageMap = new MapParser().getErrorMessageMap();

        var username = userData.getUser();
        var email = userData.getEmail();
        var password = userData.getPassword();
        var blank = "";

        var missingUsername = errorMessageMap.get("missingUsername").getErrorMessage();
        var missingEmail = errorMessageMap.get("missingEmail").getErrorMessage();
        var missingPassword = errorMessageMap.get("missingPassword").getErrorMessage();

        return new Object[][]{
                {blank, email, password, missingUsername},
                {username, blank, password, missingEmail},
                {username, email, blank, missingPassword},
        };
    }
}
