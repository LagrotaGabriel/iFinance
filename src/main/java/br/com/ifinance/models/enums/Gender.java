package br.com.ifinance.models.enums;

public enum Gender {

    M(1, "Masculino"),
    F(2, "Feminino");

    Integer code;
    String desc;

    Gender(Integer code, String desc) {
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
