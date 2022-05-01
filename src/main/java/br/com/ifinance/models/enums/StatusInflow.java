package br.com.ifinance.models.enums;

public enum StatusInflow {

    RECEBIDO(0, "Recebido"),
    RECEBER(1, "A receber");

    private Integer code;
    private String desc;

    StatusInflow(Integer code, String desc) {
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
