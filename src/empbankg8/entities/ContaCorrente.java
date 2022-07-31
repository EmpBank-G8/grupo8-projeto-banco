package empbankg8.entities;

public class ContaCorrente extends ContaPrincipal {

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

    @Override
    public String toString() {
        return "\nNúmero: " + this.getNumero() + " \n" + "Nome: " + this.getNome() + " \n" + "Cpf: " + this.getCpf() + " \n" + "Saldo: " + this.getSaldo();
    }
}
