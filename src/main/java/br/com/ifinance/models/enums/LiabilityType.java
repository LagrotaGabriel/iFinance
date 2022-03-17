package br.com.ifinance.models.enums;

public enum LiabilityType {

    VEICULO(0, "Veículo"),
    IMOVEL(1, "Imóvel"),
    CONTA(2, "Conta bancária"),
    CAPITAL(3,"Capital"),
    INVESTIMENTO(3, "Investimento"),
    ELETRONICO(4, "Eletrônico"),
    INTANGIVEL(5, "Intangivel"),
    JOIA(6, "Jóia"),
    OUTRO(7, "Outro");

    private Integer code;
    private String desc;

    LiabilityType(Integer code, String desc) {
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
