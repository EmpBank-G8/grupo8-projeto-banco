package empbankg8;

public class ContaCorrente extends ContaPrincipal{

    private int contadorTalao = 3;

    public ContaCorrente(String cpf, String nome, String senha) {
        super(cpf, nome, senha);
    }

    public double solicitarTalao(double saldo){

        if (contadorTalao > 0){
            contadorTalao--;
            saldo -= 30;
            return saldo;
        } else {
            System.out.println("Quantidade de talão solicitado alcançou o limite de 3");
        }
        return saldo;
    }






}
