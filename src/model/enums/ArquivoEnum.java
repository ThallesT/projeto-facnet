package model.enums;

public enum ArquivoEnum {


    R("Reader/Leitor"),

    W("Writer/Escritor");


    private final String arquivoEnum;

    ArquivoEnum(String arquivoEnum) {
        this.arquivoEnum = arquivoEnum;
    }

    public String getValor() {
        return this.toString();
    }

    public String getDescricao() {
        return arquivoEnum;
    }

    public static ArquivoEnum[] getValores(){
        return values();
    }


}