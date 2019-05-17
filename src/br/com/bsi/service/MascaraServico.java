package br.com.bsi.service;

public class MascaraServico {


    /**
     * Método que mascara o numero de telefone fornecido pelo usuario
     *
     * @param telefone
     * @return
     */
    public String mascaraDeTelefone(String telefone){
        return  telefone.replaceFirst("(\\d{2})(\\d{4})(\\d+)", "($1) $2-$3");
    }

    /**
     * Método que mascara o numero de Celular fornecido pelo usuario
     *
     * @param celular
     * @return
     */
    public String mascaraDeCelular(String celular){
        return  celular.replaceFirst("(\\d{2})(\\d{1})(\\d{4})(\\d+)", "($1)$2 $3-$4");
    }

    /**
     * Método que mascara o numero de cpf fornecido pelo usuario
     *
     * @param cpf
     * @return
     */
    public String mascaraDeCpf(String cpf){
        return  cpf.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    /**
     * Método que mascara o numero de cep fornecido pelo usuario
     *
     * @param cep
     * @return
     */
    public String mascaraDeCep(String cep){
        return  cep.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

}
