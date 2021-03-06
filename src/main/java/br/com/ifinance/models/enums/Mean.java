package br.com.ifinance.models.enums;

public enum Mean {

    ESPECIE(0, "Espécie"),
    DEBITO(1, "Cartão de débito"),
    CREDITO(2, "Cartão de crédito"),
    PIX(3, "Transferência via PIX"),
    CHEQUE(4, "Cheque"),
    TED(5, "Transferência via TED"),
    DOC(6, "Transferência via DOC"),
    OUTRO(6, "Outro"),
    ABERTO(7, "Aberto"),
    BOLETO(8, "Boleto");

    private Integer code;
    private String desc;

    Mean(Integer code, String desc) {
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
