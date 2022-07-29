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
        System.out.println("valor column key: " + this.key);
        return key;
    }

    public String getComments() {
        System.out.println("valor column comment: " + this.coments);
        return coments;
    }
}
