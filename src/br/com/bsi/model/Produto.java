package br.com.bsi.model;


public class Produto {
	
	  String nome;
	  long codigoDeIdentificacao;
	  double preco;
      int quantidade;
      
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getCodigoDeIdentificacao() {
		return codigoDeIdentificacao;
	}
	public void setCodigoDeIdentificacao(long codigoDeIdentificacao) {
		this.codigoDeIdentificacao = codigoDeIdentificacao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	 
	 

}
