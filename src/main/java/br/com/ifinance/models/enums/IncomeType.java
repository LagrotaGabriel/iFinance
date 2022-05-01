package br.com.ifinance.models.enums;

public enum IncomeType {

    SALARIO(0, "Salário"),
    DIVIDENDO(1, "Dividendo"),
    EXTRA(2, "Extra"),
    OUTRO(3, "Outro");

    private Integer code;
    private String desc;

    IncomeType(Integer code, String desc) {
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
