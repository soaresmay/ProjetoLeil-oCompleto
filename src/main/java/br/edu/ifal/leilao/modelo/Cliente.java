package br.edu.ifal.leilao.modelo;

public class Cliente {

	private String nome;
	private String cpf;

	public Cliente(String nome, String string) {
		super();
		this.nome = nome;
		this.cpf = string;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
