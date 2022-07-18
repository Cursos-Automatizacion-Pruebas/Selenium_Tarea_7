package utilities;

import models.CredentialsModel;
import models.ErrorMessageModel;

import java.util.HashMap;

public class MapParser {
    private final Logs log = new Logs();

    public HashMap<String, ErrorMessageModel> getErrorMessageMap() {
        log.debug("Creating error message map");
        var map = new HashMap<String, ErrorMessageModel>();
        var errorMessageList = new ExcelReader().getErrorMessages();

        for (var errorMessage : errorMessageList) {
            map.put(errorMessage.getKey(), errorMessage);
        }
        return map;
    }

    public HashMap<String, CredentialsModel> getCredentialsMap() {
        log.debug("Creating Credentials map");
        var map = new HashMap<String, CredentialsModel>();
        var credentialsList = new ExcelReader().getCredentials();

        for (var credential : credentialsList) {
            map.put(credential.getKey(), credential);
        }
        return map;
    }
}