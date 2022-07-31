package empbankg8.entities;
<<<<<<< HEAD:src/empbankg8/ContaEspecial.java
=======

public class ContaEspecial extends ContaPrincipal {
>>>>>>> 97273702820a8c06143626277f1a3273d6b7552c:src/empbankg8/entities/ContaEspecial.java

public class ContaEspecial extends ContaPrincipal {
	
	private double limite;
	
	public ContaEspecial(String cpf, String nome, String senha) {
		super(cpf, nome, senha,"ESPECIAL");
		this.limite = 1000.00;
	}

	public double getLimite() {
		return limite;
	}

	private void setLimite(double limite) {
		this.limite = limite;
	}
	
	public double getLimiteUsado() {
		return 1000.00 - this.limite;
	}

	public boolean usarLimite(double valor) {
		
		if(valor <= 0) {
			System.out.println("Valor de uso do limite inválido!");
			return false;
		}
		
		if(valor > limite) {
			System.out.println("Limite indisponível!");
			return false;
		}
		
		double novoLimite = getLimite() - valor;
		this.setLimite(novoLimite);
		this.credito(valor);
		System.out.println("Operação realizada com sucesso!");
		return true;
	}
	
	public void pagarLimiteUsado(double valor) {
		double limiteUsado = this.getLimiteUsado();
		
		if(valor <= 0) {
			System.out.println("Valor deve ser positivo!");
			return;
		}
		
		if(valor > limiteUsado) {
			System.out.println("Valor superior ao limite usado!");
			return;
		}
	
		double saldoAtual = this.getSaldo();
		if(saldoAtual < valor) {
			System.out.println("Saldo insuficiente para pagamento do limite!");
			return;
		}
		
		this.debito(valor);
		this.setLimite(this.limite + valor);
		System.out.println("Operação realizada com sucesso!");
	}

	public void debitar(double valor) {
		double novoSaldo = this.getSaldo() - valor;
		
		if(novoSaldo < 0) {
			boolean usouLimite = this.usarLimite(Math.abs(novoSaldo));
			if(!usouLimite) {
				System.out.println("Não foi possivel realizar o debito");
				return;
			}
		}
		
		this.debito(valor);
	}
	
	public String toString() {
		return "\nNúmero: " + this.getNumero() + " \n" + "Nome: " + this.getNome() + " \n" + "Cpf: " + this.getCpf() + " \n" + "Saldo: " + this.getSaldo() + " \n" + "Limite: " + this.getLimite();
	}

	@Override
	public String getInformacaoEspecifica() {
		// TODO Auto-generated method stub
		return null;
	}
}
