package empbankg8;

public class ContaEmpresarial {
		
	double saldo;
	double emprestimoEmpresarial;
	double pedirEmprestimo;
	int limiteDeOperacoes;
	
	
	public ContaEmpresarial(double saldo, double emprestimoEmpresarial, double pedirEmprestimo, int limiteDeOperacoes) {
		super();
		this.saldo = saldo;
		this.emprestimoEmpresarial = emprestimoEmpresarial;
		this.pedirEmprestimo = pedirEmprestimo;
		this.limiteDeOperacoes = limiteDeOperacoes;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getEmprestimoEmpresarial() {
		return emprestimoEmpresarial;
	}
	public void setEmprestimoEmpresarial(double emprestimoEmpresarial) {
		this.emprestimoEmpresarial = emprestimoEmpresarial;
	}
	public double getPedirEmprestimo() {
		return pedirEmprestimo;
	}
	public void setPedirEmprestimo(double pedirEmprestimo) {
		this.pedirEmprestimo = pedirEmprestimo;
	}
	public int getLimiteDeOperacoes() {
		return limiteDeOperacoes;
	}
	public void setLimiteDeOperacoes(int limiteDeOperacoes) {
		this.limiteDeOperacoes = limiteDeOperacoes;
	}
	
	
	public String toString() {
		return "\nSaldo: " + this.getSaldo() +
				"\nEmprestimo Empresarial: " + this.getEmprestimoEmpresarial()	+
				"\nPedir Empréstimo: " + this.getPedirEmprestimo() + 
				"\n";
	}

	public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Depósito realizado com sucesso!"); }
		else {
			System.out.println("Não foi possível realizar o depósito!"); }
		
		}
		
		
   public void sacar(Double valor) {
	   if(valor > 0 && this.getSaldo() >= valor) {
		   setSaldo(getSaldo() - valor);
		   System.out.println("Saque realizado com sucesso!");}
   else { 
		   System.out.println("Não foi possível realizar o saque");
	   
		   public void s 
		   
	   }
		
	   }
	   {
			
			
	{
		
	}
		
				
				
		
		
				

				
			
				
							
	}
	
	

	
	
	

}
