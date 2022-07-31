package empbankg8;

import empbankg8.entities.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

	public static void imprimeBemVindo() {
		System.out.println("*************************************");
		System.out.println("*                                   *");
		System.out.println("*      Bem-vindo(a) ao G8-Bank      *");
		System.out.println("*                                   *");
		System.out.println("* Nunca foi tão fácil ter um banco! *");
		System.out.println("*                                   *");
		System.out.println("*************************************");
	}

	public static void imprimeMenuPrincipal() {
		System.out.println("\n* MENU PRINCIPAL *");
		System.out.println("\n1 - Abrir Conta");
		System.out.println("2 - Acessar Conta");
		System.out.println("0 - Sair");
		System.out.print("Selecione a opção desejada: ");
	}

	public static void imprimirMenuOpcoesContas() {
		System.out.println("\n1 - Conta Poupança");
		System.out.println("2 - Conta Corrente");
		System.out.println("3 - Conta Especial");
		System.out.println("4 - Conta Empresa");
		System.out.println("5 - Conta Estudantil");
		System.out.println("6 - Retorne ao menu principal");
		System.out.println("0 - Sair");
		System.out.print("Escolha a opção desejada: ");
	}

	public static void imprimirDadosDaConta(ContaPrincipal conta) {
		imprimeBemVindo();
		System.out.println("\nCONTA " + conta.getTipoConta());
		System.out.println("\nNúmero: " + conta.getNumero());
		System.out.println("Nome: " + conta.getNome());
		System.out.println("CPF: " + conta.getCpf());
		System.out.println("\nSaldo Atual: R$ " + conta.getSaldo() + " - " + conta.getInformacaoEspecifica());

	}

	public static void imprimirOpcoesContaPoupanca() {
		System.out.println("Qual operação você deseja realizar?\n ");
		System.out.println("1 - Credito");
		System.out.println("2 - Débito");
		System.out.println("3 - Saldo");
		System.out.println("0 - Sair");
		System.out.print("Escolha a opção desejada: ");
	}

	public static void imprimirOpcoesContaCorrente() {
		System.out.println("Qual operação você deseja realizar?\n ");
		System.out.println("1 - Credito");
		System.out.println("2 - Débito");
		System.out.println("3 - Saldo");
		System.out.println("4 - Consulta de Talões Solicitados");
		System.out.println("5 - Menu Conta Corrente");

		System.out.println("0 - Sair");
		System.out.print("Escolha a opção desejada: ");
	}


	public static void imprimirOpcoesContaEspecial() {

		System.out.println("Qual operação você deseja realizar?\n ");
		System.out.println("1 - Credito");
		System.out.println("2 - Débito");
		System.out.println("3 - Usar limite");
		System.out.println("4 - Consultar saldo");
		System.out.println("5 - Limite disponível");
		System.out.println("6 - Pagar limite usado");
		System.out.println("0 - Sair");
		System.out.print("Escolha a opção desejada: ");
	}
	
	public static void imprimirOpcoesContaEstundantil() {
		System.out.println("Qual operação você deseja realizar?\n ");
		System.out.println("1 - Credito");
		System.out.println("2 - Débito");
		System.out.println("3 - Usar Limite Estudantil");
		System.out.println("4 - Consultar Saldo");
		System.out.println("5 - Consultar Limite Estudantil Disponível");
		System.out.println("0 - Sair");
		System.out.print("Escolha a opção desejada: ");
	}


	public static int loginPoupanca(int numConta, String codSenha, ArrayList<ContaPoupanca> array) {
		for (int i = 0; i < array.size(); i++) {
			if (numConta == (array.get(i).getNumero()) && codSenha.equals(array.get(i).getSenha())) {
				return i;
			}
		}
		return -1;
	}

	public static int loginCorrente(int numConta, String codSenha, ArrayList<ContaCorrente> array) {
		for (int i = 0; i < array.size(); i++) {
			if (numConta == (array.get(i).getNumero()) && codSenha.equals(array.get(i).getSenha())) {
				return i;
			}
		}
		return -1;
	}

	public static int login(int numConta, String codSenha, ArrayList<ContaEspecial> array) {
		for (int i = 0; i < array.size(); i++) {
			if (numConta == (array.get(i).getNumero()) && codSenha.equals(array.get(i).getSenha())) {
				return i;
			}
		}
		return -1;
	}


	
	public static int loginEstudantil(int numConta, String codSenha, ArrayList<ContaEstudantil> array) {
		for (int i = 0; i < array.size(); i++) {
			if (numConta == (array.get(i).getNumero()) && codSenha.equals(array.get(i).getSenha())) {
				return i;
			}
		}
		return -1;
	}
	
	public static int loginEmpresa(int numConta, String codSenha, ArrayList<ContaEmpresa> array) {
		for (int i = 0; i < array.size(); i++) {
			if (numConta == (array.get(i).getNumero()) && codSenha.equals(array.get(i).getSenha())) {
				return i;
			}
		}
		return -1;
	}

	public static void imprimirSaidaBanco() {
		System.out.println("Obrigado por usar o G8-Bank!");
	}




}
