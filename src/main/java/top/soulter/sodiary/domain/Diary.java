package top.soulter.sodiary.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Diary {
    String title;
    String time;
    String content;

    @TableField(exist = false)
    String brief;
    @TableField(exist = false)
    String bg;

    @TableField("is_lock")
    boolean isLock = false;
    long id;
}
