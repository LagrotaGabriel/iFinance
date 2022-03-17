package br.com.ifinance.models.enums;

public enum TransactionType {

    ENTRADA(0, "Entrada"),
    SAIDA(1, "Saída");

    private Integer code;
    private String desc;

    TransactionType(Integer code, String desc) {
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
