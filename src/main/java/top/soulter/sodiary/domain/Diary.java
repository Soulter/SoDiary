package top.soulter.sodiary.domain;

import lombok.Data;

@Data
public class Diary {
    String title;
    String time;
    String content;
    long id;
}
