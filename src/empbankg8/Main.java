package empbankg8;


import java.util.ArrayList;
import java.util.Scanner;

import empbankg8.entities.*;

public class Main {

	public static void main(String[] args) {

		int dataSistema = 10;

		ArrayList<ContaEspecial> clientesContaEspecials = new ArrayList<>();
		ArrayList<ContaCorrente> contasCorrente = new ArrayList<>();
		ArrayList<ContaPoupanca> contasPoupanca = new ArrayList<>();
		ArrayList<ContaEstudantil> contasEstudantis = new ArrayList<>();
		ArrayList<ContaEmpresa> contasEmpresa = new ArrayList<>();
		
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
					contasPoupanca.add(poupanca);
					System.out.println(poupanca.toString());
					Utils.imprimeMenuPrincipal();
					opcao = entrada.nextInt();
					System.out.println(opcao);
					break;
				}
				case 2: {
					ContaCorrente contaCorrente = new ContaCorrente(cpf, nome, senha);
					System.out.println("Conta aberta com sucesso!");
					contasCorrente.add(contaCorrente);
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
				case 4: {
					ContaEmpresa contaEmpresa = new ContaEmpresa(cpf, nome, senha);
					contasEmpresa.add(contaEmpresa);
					System.out.println("Conta aberta com sucesso! ");
					System.out.println(contaEmpresa.toString());
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
						int indiceCP = Utils.loginPoupanca(numConta, codSenha, contasPoupanca);
						if (indiceCP == -1){
							System.out.println("Número da conta ou senha incorretos!");
							Utils.imprimeMenuPrincipal();
							opcao = entrada.nextInt();
						} else {
							System.out.printf("(Dia dos depositos: %d)\nInforme um dia do mês seguinte: ", dataSistema);
							int dataInformada = entrada.nextInt();
							while (opcao != 0) {
								Utils.imprimirOpcoesContaPoupanca();
								opcao = entrada.nextInt();
								if (opcao == 1) {
									System.out.println("Qual valor você deseja depositar na conta? ");
									double valor = entrada.nextDouble();
									contasPoupanca.get(indiceCP).credito(valor, dataSistema);
									System.out.println(contasPoupanca.get(indiceCP).toString());
								} else if (opcao == 2) {
									System.out.println("Qual valor você deseja debitar na conta (dia informado)? ");
									double valor = entrada.nextDouble();
									contasPoupanca.get(indiceCP).debitar(valor, dataInformada);
									System.out.println(contasPoupanca.get(indiceCP).toString());
								} else if (opcao == 3) {
									contasPoupanca.get(indiceCP).correcao(dataInformada);

									Utils.imprimirDadosDaConta(contasPoupanca.get(indiceCP));
								} else if (opcao==0){
									Utils.imprimirSaidaBanco();
									break;
								}
							}
						}
						break;
					case 2: // OPCAO CONTA CORRENTE
						int indiceCC = Utils.loginCorrente(numConta, codSenha, contasCorrente);
						if (indiceCC == -1){
							System.out.println("Número da conta ou senha incorretos!");
							Utils.imprimeMenuPrincipal();
							opcao = entrada.nextInt();
						} else {
							while (opcao != 0) {
								Utils.imprimirOpcoesContaCorrente();
								opcao = entrada.nextInt();
								if (opcao == 1) {
									if (contasCorrente.get(indiceCC).getnumMovimentacao() < 10){
										System.out.println("Qual valor você deseja depositar na conta? ");
										double valor = entrada.nextDouble();
										contasCorrente.get(indiceCC).credito(valor);
										System.out.println(contasCorrente.get(indiceCC).toString());
									} else {
										System.out.println("Você atingiu o numero máximo de operações!");
										if (ContaCorrente.perguntaTalao(entrada)){
											contasCorrente.get(indiceCC).solicitarTalao();
										}
									}
								} else if (opcao == 2) {
									if (contasCorrente.get(indiceCC).getnumMovimentacao() < 10){
										System.out.println("Qual valor você deseja debitar na conta? ");
										double valor = entrada.nextDouble();
										contasCorrente.get(indiceCC).debitar(valor);
										System.out.println(contasCorrente.get(indiceCC).toString());
									}else {
										System.out.println("Você atingiu o numero máximo de operações!");
										if (ContaCorrente.perguntaTalao(entrada)){
											contasCorrente.get(indiceCC).solicitarTalao();
										}
									}
								} else if (opcao == 3) {
									Utils.imprimirDadosDaConta(contasCorrente.get(indiceCC));
									System.out.printf("O saldo disponível é R$ %.2f\n", contasCorrente.get(indiceCC).getSaldo());
								}else if (opcao == 4) {
									System.out.println("Talões solicitados: " + contasCorrente.get(indiceCC).getContadorTalao());
								}else if (opcao == 6) {
									Utils.imprimirOpcoesContaCorrente();

								}
								else if (opcao == 0){
									if (ContaCorrente.perguntaTalao(entrada)){
										contasCorrente.get(indiceCC).solicitarTalao();
										opcao = 6;
									} else {
										Utils.imprimirSaidaBanco();
										break;
									}
								}
							}
						}
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
								}else if(opcao == 0) {
									Utils.imprimirSaidaBanco();
									break;
								}
							}
						}
						break;
					}
					case 4: { // OPCAO CONTA EMPRESA	
						int indiceContaEmpresa = Utils.loginEmpresa(numConta, codSenha, contasEmpresa);
						if(indiceContaEmpresa == -1) {
							System.out.println("Número da conta ou senha incorretos!");
							Utils.imprimeMenuPrincipal();
							opcao = entrada.nextInt();
							break;
						} else {
							ContaEmpresa contaEmpresaLogada = contasEmpresa.get(indiceContaEmpresa);
							Utils.imprimirDadosDaConta(contaEmpresaLogada);
							while(opcao != 0) {
								Utils.imprimirOpcoesContaEstundantil();
								opcao = entrada.nextInt();
								if (opcao == 1) {
									System.out.println("Qual valor você deseja creditar na conta? ");
									double valor = entrada.nextDouble();
									contaEmpresaLogada.credito(valor);
									Utils.imprimirDadosDaConta(contaEmpresaLogada);
								}else if(opcao ==2) {
									System.out.println("Qual valor você deseja debitar na conta? ");
									double valor = entrada.nextDouble();
									contaEmpresaLogada.debitar(valor);
									Utils.imprimirDadosDaConta(contaEmpresaLogada);
								}else if(opcao == 3) {
									System.out.println("Qual valor você deseja usar do seu limite para empréstimo? ");
									double valor = entrada.nextDouble();
									contaEmpresaLogada.usarEmpresa(valor);
									Utils.imprimirDadosDaConta(contaEmpresaLogada);
								}else if(opcao == 4) {
									System.out.println("O saldo disponível é R$" + contaEmpresaLogada.getSaldo());
								}else if(opcao == 5){
									System.out.println("O limite para empréstimo disponível é R$" + contaEmpresaLogada.getEmprestimoEmpresa());
								}else if(opcao == 0) {
									Utils.imprimirSaidaBanco();
									break;
								}
							}
							break;
						}
	
					}
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
									contaEstudantilLogada.debitar(valor);
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
