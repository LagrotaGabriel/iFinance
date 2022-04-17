package br.com.ifinance.models.enums;

public enum StatusLiability {

    PAGO(0, "Pago"),
    PAGAR(1, "A pagar");

    private Integer code;
    private String desc;

    StatusLiability(Integer code, String desc) {
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
