package main;

public class Conta {

	private static int contaCounter = 1;
	
	private int numeroDaConta;
	private Pessoa pessoa;
	private Double saldo = 0.0;
	
	public Conta(Pessoa pessoa) {
		this.numeroDaConta = Conta.contaCounter;
        this.pessoa = pessoa;
        this.updateSaldo();
        Conta.contaCounter += 1;
	}
	
	public void updateSaldo() {
		this.saldo = this.getSaldo();
		
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public int getnumeroDaConta() {
		return numeroDaConta;
	}
	
	
	
	public String toString() {

        return "\nBank account: " + this.getnumeroDaConta() +
                "\nCliente: " + this.pessoa.getNome() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n" ;
	}
	
	public void sacar(Double valor) {
		if(this.getSaldo() >= valor && valor > 0) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com sucesso!!");
		}else {			
			throw new MyException("Erro ao sacar o saldo o seu saldo é de: R$" + getSaldo() + 
			" e o valor que você gostaria de sacar é de: R$" + valor);
		}
		
	}
	
	public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Deposito realizado com sucesso!!");
		}else {
			System.out.println("Erro ao digitar valor de saque");
		}
	}
	
	public void transferencia(Conta contaParaDeposito, Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Transferencia realizada com sucesso!!");
		}else {
			System.out.println("Transferencia recusada por alguma falha!");
		}
	}
}
