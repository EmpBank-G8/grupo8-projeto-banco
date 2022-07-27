package empbankg8;

public class ContaEspecial extends ContaPrincipal{

	private double limite;
	
	public ContaEspecial(String cpf, String nome, String senha) {
		super(cpf, nome, senha);
		this.limite = 1000.00;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	public void usarLimite(double valor) {
		double novoLimite = getLimite() - valor;
		this.setLimite(novoLimite);
		this.credito(valor);
	}
	public String toString() {
		return "\nNúmero: " + this.getNumero() + " | " + "Nome: " + this.getNome() + " | " + "Cpf: " + this.getCpf() + " | " + "Saldo: " + this.getSaldo() + " | " + "Limite: " + this.getLimite();
	}
}
