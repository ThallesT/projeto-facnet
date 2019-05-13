package service;

public class MascaraServico {


    public String mascaraDeTelefone(String telefone){
        return  telefone.replaceFirst("(\\d{2})(\\d{4})(\\d+)", "($1) $2-$3");
    }

    public String mascaraDeCelular(String celular){
        return  celular.replaceFirst("(\\d{2})(\\d{1})(\\d{4})(\\d+)", "($1)$2 $3-$4");
    }

    public String mascaraDeCpf(String cpf){
        return  cpf.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public String mascaraDeCep(String cep){
        return  cep.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

}
