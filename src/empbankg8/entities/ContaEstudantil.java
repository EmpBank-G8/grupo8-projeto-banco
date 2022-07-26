package empbankg8.entities;

import empbankg8.ContaPrincipal;

public class ContaEstudantil extends ContaPrincipal {

	private double limiteEstudantil = 5000d;

	public ContaEstudantil(String cpf, String nome, String senha) {
		super(cpf, nome, senha);
	}

	public double getLimiteEstudantil() {
		return limiteEstudantil;
	}

	public void usarEstudantil(double valor) {
		if (valor <= limiteEstudantil) {
			credito(valor);
			this.limiteEstudantil = this.limiteEstudantil - valor;
		} else {
			System.out.println("Operação não autorizada. " + "Valor disponível: " + this.limiteEstudantil);

		}

	}

}