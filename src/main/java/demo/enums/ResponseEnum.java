package demo.enums;

public enum ResponseEnum {

    ERROR(-1, "Server Error"),

    SUCCESS(0, "Succeed")

    ;

    Integer code;
    String  desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
