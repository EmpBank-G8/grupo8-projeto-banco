package empbankg8;

import java.util.ArrayList;
import java.util.Scanner;

import empbankg8.entities.*;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<ContaEspecial> clientesContaEspecials = new ArrayList<>();
		ArrayList<ContaCorrente> contaCorrentes = new ArrayList<>();
		ArrayList<ContaPoupanca> contaPoupancas = new ArrayList<>();
		ArrayList<ContaEmpresa> contaEmpresas = new ArrayList<>();
		
		
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
					ContaEspecial c1 = new ContaEspecial(cpf, nome, senha);
					clientesContaEspecials.add(c1);
					System.out.println("Conta aberta com sucesso! ");
					System.out.println(c1.toString());
					Utils.imprimeMenuPrincipal();
					opcao = entrada.nextInt();
					System.out.println(opcao);
					break;
					}
				case 4:{
					ContaEmpresa empresa = new ContaEmpresa(cpf, nome, senha);
					System.out.println("Conta aberta com sucesso!");
					contaEmpresas.add(empresa);
					System.out.println(empresa.toString());
					Utils.imprimeMenuPrincipal();
					opcao = entrada.nextInt();
					System.out.println(opcao);
					break;
				}
				case 5: {
					ContaPrincipal contaEstudantil = new ContaEstudantil("123.045.456-78", "Cristiane Soares", "1234");
					Utils.imprimirDadosDaConta(contaEstudantil);
					Utils.imprimirMenuMovimentacao();
				}
				default:
					opcao = 0;
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
				
				int indice = Utils.login(numConta, codSenha, clientesContaEspecials);
				if(indice == -1) {
					System.out.println("Número da conta ou senha incorretos!");
						
					Utils.imprimeMenuPrincipal();
						
					opcao = entrada.nextInt();
				}else {	
					switch (opcao) {
					case 3: {
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
								clientesContaEspecials.get(indice).debito(valor);
								System.out.println(clientesContaEspecials.get(indice).toString());
								
							}else if(opcao == 3) {
								
								System.out.println("Qual valor você deseja usar do seu limite? ");
								double valor = entrada.nextDouble();
								clientesContaEspecials.get(indice).usarLimite(valor);
								System.out.println(clientesContaEspecials.get(indice).toString());
								
							}else if(opcao == 4) {
								
								System.out.println("O saldo disponível é R$" + clientesContaEspecials.get(indice).getSaldo());
								
							}else if(opcao == 5){
								System.out.println("O limite disponível é R$" + clientesContaEspecials.get(indice).getLimite());
								
							}else if(opcao == 0) {
								Utils.imprimirSaidaBanco();
								break;
							}
					}
						break;
					}
					default:
					}
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