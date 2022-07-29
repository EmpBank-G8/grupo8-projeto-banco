package empbankg8;

public class ContaPoupanca extends ContaPrincipal{

    private int diaAniversarioPoupanca;

    public ContaPoupanca(String cpf, String nome, String senha) {
        super(cpf, nome, senha, "POUPANÇA");
    }

    public void correcao(int dataInformada){
        if (dataInformada > diaAniversarioPoupanca){
            this.credito(this.getSaldo() * (0.5 / 100));
        }
    }

    public int getDiaAniversarioPoupanca() {
        return diaAniversarioPoupanca;
    }

    public void setDiaAniversarioPoupanca(int diaAniversarioPoupanca) {
        this.diaAniversarioPoupanca = diaAniversarioPoupanca;
    }

	@Override
	public String getInformacaoEspecifica() {
		// TODO Auto-generated method stub
		return null;
	}
}
