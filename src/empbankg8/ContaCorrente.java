package empbankg8;

public class ContaCorrente extends ContaPrincipal{

    private int contadorTalao = 3;

    public ContaCorrente(String cpf, String nome, String senha) {
        super(cpf, nome, senha);
    }

    public void pedirTalao(){
        contadorTalao--;
    }






}
