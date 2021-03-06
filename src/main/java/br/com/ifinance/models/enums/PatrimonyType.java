package br.com.ifinance.models.enums;

public enum PatrimonyType {

    VEICULO(0, "Veículo"),
    IMOVEL(1, "Imóvel"),
    CONTA(2, "Conta bancária"),
    INVESTIMENTO(3, "Investimento"),
    ELETRONICO(4, "Eletrônico"),
    INTANGIVEL(5, "Intangivel"),
    JOIA(6, "Jóia"),
    LIQUIDEZ(7, "Baixa liquidez"),
    OUTRO(8, "Outro");

    private Integer code;
    private String desc;

    PatrimonyType(Integer code, String desc) {
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
