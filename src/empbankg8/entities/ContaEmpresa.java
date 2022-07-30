package empbankg8.entities;

public class ContaEmpresa extends ContaPrincipal {
	
	private double emprestimoEmpresa = 10000.00;
	
	public ContaEmpresa(String cnpj, String razaoSocial, String senha) {
		super(cnpj, razaoSocial, senha, "EMPRESA"); //comentando aqui pra refazer o pull//
		
	}
	
	public double getEmprestimoEmpresa() {
		return emprestimoEmpresa;
		
	}
	
	public void usarEmpresa(double valor) {
		if (valor <= emprestimoEmpresa){
			credito(valor);
			this.emprestimoEmpresa = this.emprestimoEmpresa - valor;
		}else {
			System.out.println("Operação não autorizada. " + "Valor disponível: " + this.emprestimoEmpresa);
					
		}
	}

	@Override
	public String getInformacaoEspecifica() {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public String toString() {
        return "\nNúmero: " + this.getNumero() + " \n" + "Nome: " + this.getNome() + " \n" + "Cpf: " + this.getCpf() + " \n" + "Saldo: " + this.getSaldo();
    }
  
}

