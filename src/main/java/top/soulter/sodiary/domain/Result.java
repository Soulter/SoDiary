package top.soulter.sodiary.domain;

import lombok.Data;

@Data
public class Result {
    public Result() {
    }
    public Result(int code, String description) {
        this.code = code;
        this.description = description;
    }
    public Result(int code, String description, Object msg) {
        this.code = code;
        this.description = description;
        this.msg = msg;
    }
    int code;
    String description;
    Object msg;
}
