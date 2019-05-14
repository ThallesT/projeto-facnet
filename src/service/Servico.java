package service;

import model.Cliente;

import java.io.*;

public class Servico {

    private MascaraServico mascaraServico = new MascaraServico();

    /**
     * busca o arquivo do cliente pelo id e retorna um objeto Cliente com as informações acessadas no banco de dados
     *
     *
     * @param idCliente
     * @return
     */

    public Cliente buscaCliente(int idCliente){

        Cliente cliente = new Cliente();

        try{
            BufferedReader bufferedReader = abreArquivo("data/"+idCliente+".txt");

            cliente.setIdCliente(idCliente);
            cliente.setNome(bufferedReader.readLine());
            cliente.setEndereço(bufferedReader.readLine());
            cliente.setCep(bufferedReader.readLine());
            cliente.setCpf(bufferedReader.readLine());
            cliente.setTelefone(bufferedReader.readLine());
            cliente.setCelular(bufferedReader.readLine());

        }catch (Exception e){
            System.out.println("Erro ao ler o arquivo do cliente");
            System.out.println(e.getMessage());
        }
        return cliente;
    }

    /**
     * Armazena o cliente no banco de dados que estamos estruturando
     *
     * @param cliente
     * @return
     */

    public Cliente armazenaCliente(Cliente cliente){
        try{
            int idCliente = getSequence();
            BufferedWriter bufferedWriter = gravaArquivo("data/"+idCliente+".txt");

            cliente.setIdCliente(idCliente);
            bufferedWriter.write(cliente.getNome()+"\n");
            bufferedWriter.write(cliente.getEndereço()+"\n");
            bufferedWriter.write(mascaraServico.mascaraDeCep(cliente.getCep()+"\n"));
            bufferedWriter.write(mascaraServico.mascaraDeCpf(cliente.getCpf()+"\n"));
            bufferedWriter.write(mascaraServico.mascaraDeTelefone(cliente.getTelefone())+"\n");
            bufferedWriter.write(mascaraServico.mascaraDeCelular(cliente.getCelular()));

            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (Exception e){
            System.out.println("Erro ao gravar o arquivo do cliente");
            System.out.println(e.getMessage());
        }
        return cliente;
    }

    /**
     * Incrementa a sequence e retorna o valor atual;
     *
     * @return
     */

    public int getSequence(){

        try{
            FileInputStream fileInputStream = new FileInputStream("sequence/sequence.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = bufferedReader.readLine();
            int idCliente = Integer.parseInt(str);
            idCliente += 1;
            bufferedReader.close();

            FileOutputStream fileOutputStream = new FileOutputStream("sequence/sequence.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(""+idCliente);
            bufferedWriter.flush();
            bufferedWriter.close();
            return idCliente;


        }catch (Exception e){
            System.out.println("Erro ao resgatar sequence");
            e.printStackTrace();
            return 0;
        }

    }

    /**
     * Abre o arquivo especificado, e retorna um objeto de leitura;
     *
     * @param diretorio
     * @return
     * @throws Exception
     */
    public BufferedReader abreArquivo(String diretorio) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(diretorio);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader;
    }

    /**
     * retorna um objeto de gravação, que vai gravar o arquivo no diretorio especificado
     * @param diretorio
     * @return
     * @throws Exception
     */
    public BufferedWriter gravaArquivo(String diretorio) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream(diretorio);
        OutputStreamWriter outputStreamReader = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamReader);
        return bufferedWriter;
    }





}
