package empbankg8;

public class ContaPoupanca extends ContaPrincipal{

    private int diaAniversarioPoupanca;

    public ContaPoupanca(String cpf, String nome, String senha) {
        super(cpf, nome, senha);
    }

    public double correcao(int dataInformada, double saldo){
        if (dataInformada>=diaAniversarioPoupanca){
            return (saldo*0.05) + saldo;
        }
        return saldo;
    }




}
