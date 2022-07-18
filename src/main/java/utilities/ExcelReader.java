package utilities;

import com.poiji.bind.Poiji;
import models.CredentialsModel;
import models.ErrorMessageModel;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private final String EXCEL_PATH = "src/test/resources/data/testData.xlsx";
    private final Logs log = new Logs();

    public List<ErrorMessageModel> getErrorMessages() {
        log.debug("Reading error message from excel: " + EXCEL_PATH);
        return Poiji.fromExcel(new File(EXCEL_PATH), ErrorMessageModel.class);
    }

    public List<CredentialsModel> getCredentials() {
        log.debug("Reading crendentials from excel: " + EXCEL_PATH);
        return Poiji.fromExcel(new File(EXCEL_PATH), CredentialsModel.class);
    }
}
