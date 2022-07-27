package empbankg8;

public class Utils {
	public static void imprimeMenuPrincipal() {
		imprimeCabecalho();
		System.out.println("1 - Abrir Conta");
		System.out.println("2 - Acessar Conta");
		System.out.println("0 - Sair");
		System.out.print("Selecione a opção desejada: ");
	}

	public static void imprimirMenuOpcoesContas() {
		imprimeCabecalho();
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
		imprimeCabecalho();
		System.out.println("\nCONTA " +  conta.getTipoConta());
		System.out.println("\nNome: " +   conta.getNome());
		System.out.println("CPF: " +   conta.getCpf());
		System.out.println("\nSaldo Atual: R$ " + conta.getSaldo() + 
				" - " + conta.getInformacaoEspecifica());
		
	}
	
	public static void imprimirMenuMovimentacao() {
		System.out.println("\nEscolha o tipo de movimentação: ");
		System.out.println("C - Crédito");
		System.out.println("D - Débito");
		
	}
	private static void imprimeCabecalho() {
		System.out.println("*************************************");
		System.out.println("*    Bem-vindo(a) ao Emp Bank-G8    *");
		System.out.println("*************************************\n");
	}

} 
