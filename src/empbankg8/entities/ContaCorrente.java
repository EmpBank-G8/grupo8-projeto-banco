package empbankg8.entities;

import java.util.Scanner;

public class ContaCorrente extends ContaPrincipal {

    private int contadorTalao = 0;
    private final int LIMITE_TALAO = 3;
    public final double VALOR_TALAO = 30;

    public ContaCorrente(String cpf, String nome, String senha) {
        super(cpf, nome, senha, "CORRENTE");
    }

    public void solicitarTalao(){

        if (contadorTalao < LIMITE_TALAO && this.getSaldo() >= VALOR_TALAO){
            contadorTalao++;
            this.debitar(VALOR_TALAO);
        } else {
            System.out.println("Quantidade de talão solicitado alcançou o limite de "+ LIMITE_TALAO
                    + " ou saldo é menor que " + VALOR_TALAO);
        }
    }

    public void debitar(double valor) {
        if (this.getSaldo() > valor){
            setNumMovimentacao(getnumMovimentacao() - 1);
            this.debito(valor);
        } else{
            System.out.println("Saldo indisponível");
        }
    }

    public int getContadorTalao() {
        return contadorTalao;
    }


    public static boolean perguntaTalao(Scanner entrada) {
        System.out.print("Gostaria de solicitar um talão de cheque?\nObs: será debitado R$30,00 do saldo! (s/n): ");
        char resposta = entrada.next().charAt(0);
        if (resposta == 's' || resposta == 'S'){
            return true;
        }
        return false;
    }

    @Override
    public String getInformacaoEspecifica() {
        return "Limite de " + this.LIMITE_TALAO + " talões. Solicitados até o momento: " + this.getContadorTalao();
    }

    @Override
    public String toString() {
        return "\nNúmero: " + this.getNumero() + " \n" + "Nome: " + this.getNome() + " \n" + "Cpf: " + this.getCpf() + " \n" + "Saldo: " + this.getSaldo();
    }

}
