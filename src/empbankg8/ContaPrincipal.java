package empbankg8;

public abstract class ContaPrincipal {
	private int numero; //Numero da conta - Gerado automaticamente. Através da Classe GeradorNumConta.
	private String cpf; //Cpf do usuário.
	private double saldo; //Saldo do usuário.
	private boolean ativo; //Variável que indica se a conta está ativa ou não.
	private String nome; //Nome do usuário.
	private String senha; //Senha do usuário.
	private int numMovimentacao; //Variável para controlar o número de movimentações do usuário.
	private String tipoConta;
	
	//Construtor da classe principal.
	public ContaPrincipal(String cpf, String nome, String senha, String tipoConta) { 
		super();
		this.numero = GeradorNumConta.geraNumConta(); //Gerador do número da conta.
		this.cpf = cpf;
		this.saldo = 0; //Na criação da conta o saldo inicia-se com 0.
		this.ativo = true; //Na criação da conta a mesma encontra-se ativa.
		this.nome = nome;
		this.senha = senha;
		this.numMovimentacao = 0; //Na criação da conta não tem nenhuma movimentação.
		this.tipoConta = tipoConta;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	//Foi retirado o setsaldo devido a especificação do trabalho. Para que não possa ser mudado o saldo externamente.
	public double getSaldo() {
		return saldo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}
	//Foi apagado o set numMovimentação para não ficar acessível externamente.
	public int getnumMovimentacao() {
		return numMovimentacao;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void debito(double valor) {
		this.saldo = this.saldo - valor;
		this.numMovimentacao++;
	}
	public void credito(double valor) {
		this.saldo = this.saldo + valor;
		this.numMovimentacao++;
	}
	public void desativar() { //Método para desativar conta.
		this.ativo = false;	
	}

	public String getTipoConta() {	
		return tipoConta;
	}

	public abstract String getInformacaoEspecifica();
}

