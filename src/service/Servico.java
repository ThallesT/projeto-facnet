package service;

import model.Cliente;
import model.enums.ArquivoEnum;

import java.io.*;
import java.util.Random;

public class Servico {

    private MascaraServico mascaraServico = new MascaraServico();


    public Cliente leCliente(int idCliente){

        Cliente cliente = new Cliente();

        try{
            FileInputStream fileInputStream = new FileInputStream("Data/"+idCliente+".txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

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

    public Cliente armazenaCliente(Cliente cliente){
        try{
            int idCliente = getSequence();
            FileOutputStream fileOutputStream = new FileOutputStream("Data/"+idCliente+".txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

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

    public Long geraId(){
        File file = null;
        Long id = null;
        do{
            Random random = new Random();
            id = random.nextLong();
            file = new File( id+".txt");
        }while(file.exists());
        return id;
    }


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






}
