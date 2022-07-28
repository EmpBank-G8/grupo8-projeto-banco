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
		if(valor <= limite) {
			double novoLimite = getLimite() - valor;
			this.setLimite(novoLimite);
			this.credito(valor);
			System.out.println("Operação realizada com sucesso!");
		}else {
			System.out.println("Limite indisponível!");
		}
	}
	public String toString() {
		return "\nNúmero: " + this.getNumero() + " \n" + "Nome: " + this.getNome() + " \n" + "Cpf: " + this.getCpf() + " \n" + "Saldo: " + this.getSaldo() + " \n" + "Limite: " + this.getLimite();
	}
}
