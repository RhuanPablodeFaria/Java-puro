package main;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contaBancaria;

	public static void main(String[] args) {
		contaBancaria = new ArrayList<Conta>();
		operacoes();
	}

	public static void operacoes() {

		System.out.println("------------------------------------------------------");
		System.out.println("-------------Bem vindos a nossa Agência---------------");
		System.out.println("------------------------------------------------------");
		System.out.println("***** Selecione uma operação que deseja realizar *****");
		System.out.println("------------------------------------------------------");
		System.out.println("	   |   Opção 1 - Criar conta   |");
		System.out.println("	   |   Opção 2 - Depositar     |");
		System.out.println("	   |   Opção 3 - Sacar         |");
		System.out.println("	   |   Opção 4 - Transferir    |");
		System.out.println("	   |   Opção 5 - Listar        |");
		System.out.println("	   |   Opção 6 - Sair          |");
		System.out.println();
		int valor = input.nextInt();

		switch (valor) {

		case 1:
			criarConta();
			break;

		case 2:
			depositar();
			break;

		case 3:
			sacar();
			break;

		case 4:
			transferir();
			break;

		case 5:
			listarContas();
			break;

		case 6:
			System.out.println("Obrigado pela preferencia!");
			System.exit(0);

		default:
			System.out.println("Numero invalido!");
			operacoes();
			break;

		}
	}

	public static void criarConta() {
		System.out.println("\nNome: ");
		String nome = input.next();

		System.out.println("\nCPF: ");
		String cpf = input.next();
		

		if (cpf.length() != 11) {
			System.out.println("");
		}
		
		System.out.println("\nEmail: ");
		String email = input.next();
		System.out.println();

		Pessoa cliente = new Pessoa(nome, email, cpf);

		Conta conta = new Conta(cliente);

		contaBancaria.add(conta);

		System.out.println("Sua conta foi criada");
		System.out.println();
		operacoes();
	}

	public static Conta encontrarConta(int numeroDaConta) {
		Conta conta = null;
		if (contaBancaria.size() > 0) {
			for (Conta contas : contaBancaria) {
				if (contas.getnumeroDaConta() == numeroDaConta) {
					conta = contas;
				}
			}
		}
		return conta;
	}

	public static void depositar() {
		System.out.println("Conta em que deseja depositar: ");
		int numeracaoDaConta = input.nextInt();
		Conta conta = encontrarConta(numeracaoDaConta);

		if (conta != null) {
			System.out.println("Qual valor deseja depositar? ");
			double valor = input.nextDouble();

			conta.depositar(valor);
		} else {
			System.out.println("Conta nao encontrada para deposito");
		}

		operacoes();
	}

	public static void sacar() {
		System.out.println("Numero da conta: ");
		int numeroDaConta = input.nextInt();
		Conta conta = encontrarConta(numeroDaConta);

		if (conta != null) {
			System.out.println("Qual valor para sacar?");
			double valorDoSaque = input.nextDouble();

			try {
				conta.sacar(valorDoSaque);
				
			} catch (Exception e) {
				String a= e.getMessage();
				System.out.println(a);
				
			}

		} else {
			System.out.println("Conta não encontrada!");
		}
		operacoes();
	}

	public static void transferir() {
		System.out.println("Qual conta do remetente ");
		int numeroDaConta = input.nextInt();

		Conta contaRemetente = encontrarConta(numeroDaConta);

		if (contaRemetente != null) {
			System.out.println("Qual o destinatario? ");
			int numeroDaConta2 = input.nextInt();
			Conta contaDestinatario = encontrarConta(numeroDaConta2);

			if (contaDestinatario != null) {
				System.out.println("Qual valor deseja transferir?");
				double valorDaTransferencia = input.nextDouble();

				contaRemetente.transferencia(contaDestinatario, valorDaTransferencia);

			} else {
				System.out.println("Conta não encontrada!");
			}
		} else {
			System.out.println("Conta não encontrada!");
		}

		operacoes();
	}

	public static void listarContas() {
		if (contaBancaria.size() > 0) {
			for (Conta conta : contaBancaria) {
				System.out.println(conta);
			}
		} else {
			System.out.println("--- Não há contas cadastradas ---");
		}

		operacoes();
	}
}
