import java.util.Scanner;
public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ola! bem vindo a nubank!\n\n Deseja Criar uma conta? S/N");
        String start = scan.nextLine();

        while (start.equalsIgnoreCase("S")) {
            Cliente cliente = new Cliente();
            System.out.println("Digite seu nome completo");
            cliente.setNome(scan.nextLine());
            System.out.println("Escolhar o tipo de conta: (C)orrente/(P)oupança");
            switch (scan.nextLine().toUpperCase()) {
                case "C":
                    Conta cc = new ContaCorrente(cliente);
                    do {
                        System.out.println("Escolha uma operação: (S)acar/(D)epositar/(T)ransferir");
                        switch (scan.nextLine().toUpperCase()) {

                            case "S":
                                System.out.println("Digite o valor que deseja sacar");
                                cc.sacar(scan.nextDouble());
                                cc.imprimirExtrato();
                                break;

                            case "D":
                                System.out.println("Digite o valor que deseja Depositar");
                                cc.depositar(scan.nextDouble());
                                cc.imprimirExtrato();
                                break;

                            case "T":
                                System.out.println("Digite o valor que deseja Transferir para poupança");
                                Conta poupanca = new ContaPoupanca(cliente);
                                cc.transferir(scan.nextDouble(), poupanca);
                                poupanca.imprimirExtrato();
                                break;

                            default:
                                System.out.println("Opção invalida!");

                        }
                        System.out.println("Deseja fazer outra operação? S/N");
                        scan.nextLine();
                        start = scan.nextLine();
                    } while (start.equalsIgnoreCase("S"));

                    break;

                case "P":
                    Conta poupanca = new ContaPoupanca(cliente);
                    do {
                        System.out.println("Escolha uma operação: (S)acar/(D)epositar/(T)ransferir");
                        switch (scan.nextLine().toUpperCase()) {

                            case "S":
                                System.out.println("Digite o valor que deseja sacar");
                                poupanca.sacar(scan.nextDouble());
                                poupanca.imprimirExtrato();
                                break;

                            case "D":
                                System.out.println("Digite o valor que deseja Depositar");
                                poupanca.depositar(scan.nextDouble());
                                poupanca.imprimirExtrato();
                                break;

                            case "T":
                                System.out.println("Digite o valor que deseja Transferir para conta corrente");
                                cc = new ContaCorrente(cliente);
                                poupanca.transferir(scan.nextDouble(), cc);
                                cc.imprimirExtrato();
                                break;

                            default:
                                System.out.println("Opção invalida");

                        }
                        System.out.println("Deseja fazer outra operação? S/N");
                        scan.nextLine();
                        start = scan.nextLine();
                    } while (start.equalsIgnoreCase("S"));
                    break;

                default:
                    System.out.println("Opção invalida");
            }
            System.out.println("quer fazer outra conta? S/N");
            start = scan.nextLine();
        }
        scan.close();
    }
}