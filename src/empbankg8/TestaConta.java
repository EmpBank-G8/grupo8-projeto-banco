package empbankg8;

public class TestaConta {

    public static void main(String[] args) {

        ContaCorrente joaquim = new ContaCorrente("123", "Joaquim", "123");

        System.out.println("Saldo");
        joaquim.credito(1000);

        System.out.println(joaquim.getSaldo());

        joaquim.solicitarTalao();
        System.out.println("Solicitações Faltantes: " + joaquim.getContadorTalao());

        joaquim.solicitarTalao();
        joaquim.solicitarTalao();
        joaquim.solicitarTalao();

        System.out.println("Movimentações: " + joaquim.getnumMovimentacao());

        System.out.println("---Maria---");
        ContaPoupanca maria = new ContaPoupanca("234", "Maria", "abc");

        System.out.println(maria.getSaldo());
        maria.credito(100);

        maria.setDiaAniversarioPoupanca(15);

        maria.correcao(10);
        System.out.println(maria.getSaldo());

        maria.correcao(15);
        System.out.println(maria.getSaldo());

        //Acho que é isso, porem se for informado + de 1 data o numero de movimentações continua incrementando..
        maria.correcao(16);
        System.out.println(maria.getSaldo());

        System.out.println(maria.getnumMovimentacao());

    }

}
