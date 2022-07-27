package empbankg8;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    private List<ContaPrincipal> listaContas = new ArrayList<>();
    private final ContaPrincipal gerente;

    public BancoDeDados() {
        gerente = new ContaPrincipal("543", "Gerente Geral", "123");
        listaContas.add(gerente);
    }

    public String adicionarConta(ContaPrincipal contaPrincipal) {
        this.listaContas.add(contaPrincipal);
        return "Cliente adicionado com sucesso";
    }

    public ContaPrincipal localizarConta(String documento){
        ContaPrincipal conta = new ContaPrincipal();
        for (ContaPrincipal contaIter : listaContas) {
            if (contaIter.getCpf() == documento){
                return conta;
            }
        }
        return null;
    }

    public List<ContaPrincipal> listarContas(String cpf, String senha) {
        if (ehGerente(cpf, senha)){
            return listaContas;
        }
        return null;
    }

    public boolean ehGerente(String cpf, String senha){
        if ((gerente.getCpf() == cpf) && (gerente.getSenha() == senha)){
            return true;
        }
        return false;
    }
}
