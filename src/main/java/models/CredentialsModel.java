package models;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("credentials")
public class CredentialsModel {
    @ExcelCellName("key")
    private String key;
    @ExcelCellName("username")
    private String username;
    @ExcelCellName("email")
    private String email;
    @ExcelCellName("password")
    private String password;

    public String getKey() {
        return key;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
