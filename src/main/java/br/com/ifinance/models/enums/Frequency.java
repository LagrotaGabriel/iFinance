package br.com.ifinance.models.enums;

public enum Frequency {

    SEMANAL(0, "Semanal"),
    QUINZENAL(1, "Quinzenal"),
    MENSAL(2, "Mensal"),
    BIMESTRAL(3, "Bimestral"),
    TRIMESTRAL(4, "Trimestral"),
    SEMESTRAL(5, "Semestral"),
    ANUAL(6, "Anual");

    private Integer code;
    private String desc;

    Frequency(Integer code, String desc) {
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
