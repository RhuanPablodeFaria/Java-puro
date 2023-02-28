package main;
import java.util.Date;

public class Pessoa {

	private static int conta = 1;
	
	private int idPessoa;
	private String email;
	private String cpf;
	private String nome;
	private Date dataHoraAtual;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String email, String cpf) {
		this.idPessoa = Pessoa.conta;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataHoraAtual = new Date();
		Pessoa.conta += 1;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public Date getDataHoraAtual() {
		return this.dataHoraAtual;
	}
	
	public String toString() {
		return "\nNome: " + getNome() +
			   "\nCpf: " + getCpf() + 
			   "\nEmail: " + getEmail() + 
			   "\nData: " + Utils.dateToString(this.getDataHoraAtual());
	}
	
}
