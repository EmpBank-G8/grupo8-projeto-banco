package empbankg8;

import java.util.Scanner;

import empbankg8.entities.ContaEstudantil;

public class Main {

	public static void main(String[] args) {
		// Colocar Slogan
		Scanner entrada = new Scanner(System.in);
		Utils.imprimeMenuPrincipal();
		int opcao = entrada.nextInt();

		// while (opcao != 0) {

		if (opcao == 1) {
			Utils.imprimirMenuOpcoesContas();
			opcao = entrada.nextInt();
		} else if (opcao == 2) {
			System.out.println("Acessar Conta");

			ContaPrincipal contaEstudantil = new ContaEstudantil("123.045.456-78", "Cristiane Soares", "1234");
			Utils.imprimirDadosDaConta(contaEstudantil);
			Utils.imprimirMenuMovimentacao();

		} else if (opcao == 0) {
			System.out.println("Sair");
		} else {
			System.out.println("\nOpção inválida...");
			Utils.imprimeMenuPrincipal();
			opcao = entrada.nextInt();
		}
//		} 
	}
}
