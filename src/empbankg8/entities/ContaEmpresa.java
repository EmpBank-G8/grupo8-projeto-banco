package empbankg8.entities;

public class ContaEmpresa extends ContaPrincipal {
	
	private double emprestimoEmpresa = 10000.00;
	
	public ContaEmpresa(String cnpj, String razaoSocial, String senha) {
		super(cnpj, razaoSocial, senha, "EMPRESA");
		
	}
	
	public double getEmprestimoEmpresa() {
		return emprestimoEmpresa;
		
	}
	
	public void usarEmpresa(double valor) {
		if (valor <= this.emprestimoEmpresa) {
			credito(valor);
			this.emprestimoEmpresa = this.emprestimoEmpresa - valor;
		}else {
			System.out.println("Operação não autorizada. " + "Valor disponível: " + this.emprestimoEmpresa);
			
		}
	}
	
	public void debitar(double valor) {
		this.debito(valor);
	}

	@Override
	public String getInformacaoEspecifica() {
		// TODO Auto-generated method stub
		return "Limite de Empréstimo " + emprestimoEmpresa;
	}
	public String toString() {
		return "\nNúmero: " + this.getNumero() + " \n" + "Nome: " + this.getNome() + " \n" + "Cpf: " + this.getCpf() + " \n" + "Saldo: " + this.getSaldo() + " \n" + "Limite: " + this.getEmprestimoEmpresa();
	}
	
}