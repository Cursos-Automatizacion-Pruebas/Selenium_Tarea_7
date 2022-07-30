package models;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("comments")
public class CommentsModel {
    @ExcelCellName("key")
    private String key;
    @ExcelCellName("comments")
    private String coments;

    public String getKey() {
        return key;
    }

    public String getComments() {
        return coments;
    }
}
