package empbankg8;

import java.util.ArrayList;
import java.util.Scanner;

import empbankg8.entities.*;

public class Main {

	public static void main(String[] args) {

		ArrayList<ContaEspecial> clientesContaEspecials = new ArrayList<>();
		ArrayList<ContaCorrente> contaCorrentes = new ArrayList<>();
		ArrayList<ContaPoupanca> contaPoupancas = new ArrayList<>();
		ArrayList<ContaEstudantil> contasEstudantis = new ArrayList<>();

		Scanner entrada = new Scanner(System.in);

		Utils.imprimeBemVindo();
		Utils.imprimeMenuPrincipal();

		int opcao = entrada.nextInt();

		String nome, cpf, senha;

		while (opcao != 0) {

			if(opcao == 1) {

				entrada.nextLine();
				System.out.println("Digite seu nome: ");
				nome = entrada.nextLine();
				System.out.println("Digite seu CPF: ");
				cpf = entrada.nextLine();
				System.out.println("Digite sua senha: ");
				senha = entrada.nextLine();
				System.out.println("Qual tipo de conta você deseja abrir? ");
				Utils.imprimirMenuOpcoesContas();

				opcao = entrada.nextInt();

				switch (opcao) {
				case 1: {
					ContaPoupanca poupanca = new ContaPoupanca(cpf, nome, senha);
					System.out.println("Conta aberta com sucesso!");
					contaPoupancas.add(poupanca);
					System.out.println(poupanca.toString());
					Utils.imprimeMenuPrincipal();
					opcao = entrada.nextInt();
					System.out.println(opcao);
					break;
				}
				case 2: {
					ContaCorrente contaCorrente = new ContaCorrente(cpf, nome, senha);
					System.out.println("Conta aberta com sucesso!");
					contaCorrentes.add(contaCorrente);
					System.out.println(contaCorrente.toString());
					Utils.imprimeMenuPrincipal();
					opcao = entrada.nextInt();
					System.out.println(opcao);
					break;
				}
				case 3: {
					ContaEspecial contaEspecial = new ContaEspecial(cpf, nome, senha);
					clientesContaEspecials.add(contaEspecial);
					System.out.println("Conta aberta com sucesso! ");
					System.out.println(contaEspecial.toString());
					Utils.imprimeMenuPrincipal();
					opcao = entrada.nextInt();
					System.out.println(opcao);
					break;
				}
				case 5: {
					ContaEstudantil contaEstudantil = new ContaEstudantil(cpf, nome, senha);
					contasEstudantis.add(contaEstudantil);
					System.out.println("Conta aberta com sucesso! ");
					Utils.imprimirDadosDaConta(contaEstudantil);
					Utils.imprimeMenuPrincipal();
					opcao = entrada.nextInt();
					System.out.println(opcao);
					break;
				}
				default: {
					opcao = 0;
				}
				}
			}else if (opcao == 2) {
				System.out.println("Qual tipo de conta você deseja acessar? ");

				Utils.imprimirMenuOpcoesContas();

				opcao = entrada.nextInt();

				System.out.println("Digite o número da sua conta: ");

				int numConta = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Digite sua senha:");
				String codSenha = entrada.nextLine();
				switch (opcao) {
					case 1: // OPCAO CONTA POUPANÇA
						break;
					case 2: // OPCAO CONTA CORRENTE
						break;
					case 3: { // OPCAO CONTA ESPECIAL
						int indice = Utils.login(numConta, codSenha, clientesContaEspecials);
						if(indice == -1) {
							System.out.println("Número da conta ou senha incorretos!");
							Utils.imprimeMenuPrincipal();
							opcao = entrada.nextInt();
						}else {	
							while(opcao != 0) {
								Utils.imprimirOpcoesContaEspecial();
								opcao = entrada.nextInt();
								if (opcao == 1) {
									System.out.println("Qual valor você deseja creditar na conta? ");
									double valor = entrada.nextDouble();
									clientesContaEspecials.get(indice).credito(valor);
									System.out.println(clientesContaEspecials.get(indice).toString());
	
								}else if(opcao ==2) {
									System.out.println("Qual valor você deseja debitar na conta? ");
									double valor = entrada.nextDouble();
									clientesContaEspecials.get(indice).debitar(valor);
									System.out.println(clientesContaEspecials.get(indice).toString());
	
								}else if(opcao == 3) {
	
									System.out.println("Qual valor você deseja usar do seu limite? ");
									double valor = entrada.nextDouble();
									clientesContaEspecials.get(indice).usarLimite(valor);
									System.out.println(clientesContaEspecials.get(indice).toString());
	
								}else if(opcao == 4) {
	
									System.out.println("O saldo disponível é R$" + clientesContaEspecials.get(indice).getSaldo());
	
								}else if(opcao == 5){
									System.out.println("O limite usado é R$" + clientesContaEspecials.get(indice).getLimiteUsado());
									System.out.println("O limite disponível é R$" + clientesContaEspecials.get(indice).getLimite());
	
								}else if(opcao == 6){
									System.out.println("Qual valor você deseja pagar seu limite ?");
									double valor = entrada.nextDouble();
									clientesContaEspecials.get(indice).pagarLimiteUsado(valor);
								} else if(opcao == 0) {
									Utils.imprimirSaidaBanco();
									break;
								}
							}
						}
						break;
					}
					case 4: // OPCAO CONTA EMPRESA
						break;
					case 5: { // OPCAO CONTA ESTUDANTIL	
						int indiceContaEstudantil = Utils.loginEstudantil(numConta, codSenha, contasEstudantis);
						if(indiceContaEstudantil == -1) {
							System.out.println("Número da conta ou senha incorretos!");
							Utils.imprimeMenuPrincipal();
							opcao = entrada.nextInt();
							break;
						} else {
							ContaEstudantil contaEstudantilLogada = contasEstudantis.get(indiceContaEstudantil);
							Utils.imprimirDadosDaConta(contaEstudantilLogada);
							while(opcao != 0) {
								Utils.imprimirOpcoesContaEstundantil();
								opcao = entrada.nextInt();
								if (opcao == 1) {
									System.out.println("Qual valor você deseja creditar na conta? ");
									double valor = entrada.nextDouble();
									contaEstudantilLogada.credito(valor);
									Utils.imprimirDadosDaConta(contaEstudantilLogada);
								}else if(opcao ==2) {
									System.out.println("Qual valor você deseja debitar na conta? ");
									double valor = entrada.nextDouble();
									//contaEstudantilLogada.debito(valor);
									Utils.imprimirDadosDaConta(contaEstudantilLogada);
								}else if(opcao == 3) {
									System.out.println("Qual valor você deseja usar do seu limite estudantil? ");
									double valor = entrada.nextDouble();
									contaEstudantilLogada.usarEstudantil(valor);
									Utils.imprimirDadosDaConta(contaEstudantilLogada);
								}else if(opcao == 4) {
									System.out.println("O saldo disponível é R$" + contaEstudantilLogada.getSaldo());
								}else if(opcao == 5){
									System.out.println("O limite estudantil disponível é R$" + contaEstudantilLogada.getLimiteEstudantil());
								}else if(opcao == 0) {
									Utils.imprimirSaidaBanco();
									break;
								}
							}
							break;
						}
	
					}
					default:
				}

			}else if(opcao == 0) {
				System.out.println("Sair");
			}
			else {
				System.out.println("\nOpção inválida...");
				Utils.imprimeMenuPrincipal();
				opcao = entrada.nextInt();
			}
		}
	}
}