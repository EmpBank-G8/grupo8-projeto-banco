package empbankg8.entities;

import java.util.ArrayList;
import java.util.List;

public class ContaPoupanca extends ContaPrincipal {


    private int diaAniversarioPoupanca;
    private double rendimentos = 0;

    public ContaPoupanca(String cpf, String nome, String senha) {
        super(cpf, nome, senha, "POUPANÇA");
    }

    public void credito(double valor, int dataSistema) {
        credito(valor);
        this.diaAniversarioPoupanca = dataSistema;
    }

    public void correcao(int dataInformada){
        if (dataInformada >= diaAniversarioPoupanca){
            this.rendimentos = getSaldo() * 0.005;
        }
    }

    public void debitar(double valor, int dataDebito) {
        if (this.getSaldo() < valor){
            System.out.println("Não foi possível realizar o debito");
            return;
        }
        this.credito(this.rendimentos);
        this.rendimentos = 0;
        this.setNumMovimentacao(getnumMovimentacao() - 1);
        this.debito(valor);
    }


    public double getRendimentos() {
        return rendimentos;
    }

    @Override
	public String getInformacaoEspecifica() {
		// TODO Auto-generated method stub
		return "Rendimentos no mês: R$" + this.getRendimentos();
	}

    @Override
    public String toString() {
        return "\nNúmero: " + this.getNumero() + " \n" + "Nome: " + this.getNome() + " \n" + "Cpf: " + this.getCpf() + " \n" + "Saldo: " + this.getSaldo();
    }


}
