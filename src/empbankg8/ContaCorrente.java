package empbankg8;

public class ContaCorrente extends ContaPrincipal{

    private int contadorTalao = 3;

    public ContaCorrente(String cpf, String nome, String senha) {
        super(cpf, nome, senha, "CORRENTE");
    }

    public void solicitarTalao(){

        if (contadorTalao > 0){
            contadorTalao--;
            this.debito(30);
        } else {
            System.out.println("Quantidade de talão solicitado alcançou o limite de 3");
        }
    }

    public int getContadorTalao() {
        return contadorTalao;
    }

	@Override
	public String getInformacaoEspecifica() {
		// TODO Auto-generated method stub
		return null;
	}
}
