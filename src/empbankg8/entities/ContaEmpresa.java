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
		if (valor <= limiteEstudantil) {
			credito(valor);
			this.emprestimoEmpresa = this.emprestimoEmpresa - valor;
		}else {
			System.out.println("Operação não autorizada. " + "Valor disponível: " + this.limiteEstudantil);
			
		}
	}

	@Override
	public String getInformacaoEspecifica() {
		// TODO Auto-generated method stub
		return null;
	}
	
}