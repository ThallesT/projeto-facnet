import model.Cliente;
import service.Servico;

public class Main {

    public static void main(String[] args) {

            Cliente cliente = new Cliente();
            Servico servico = new Servico();

            cliente.setNome("teste");
            cliente.setEndereço("testeEndereço");
            cliente.setCep("72015035");
            cliente.setCpf("05840551222");
            cliente.setTelefone("6156362554");
            cliente.setCelular("61984483883");
            cliente = servico.armazenaCliente(cliente);


            Cliente cliente1 = servico.leCliente(cliente.getIdCliente());

            System.out.println(cliente1.getIdCliente());
            System.out.println(cliente1.getNome());
            System.out.println(cliente1.getEndereço());
            System.out.println(cliente1.getCep());
            System.out.println(cliente1.getCpf());
            System.out.println(cliente1.getTelefone());
            System.out.println(cliente1.getCelular());






    }
}
