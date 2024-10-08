import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.text.DecimalFormat;

public class ContaTerminal {
    public static void main(String[] args) throws IOException, InterruptedException {
        int idMenu;
        int numeroContaBanco = 1020;
        String agenciaBanco = "067-8";
        String nomeCliente = "";
        Double saldo = 237.48;
        boolean verificarLogin = false;

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        DecimalFormat formatarDecimal = new DecimalFormat("0.00");

        interfaceInicialBanco();

        idMenu = scanner.nextInt();
        do {
            switch (idMenu) {
                case 1:
                    System.out.println(" ");
                    System.out.println("╔═════════════ BankDigitalBank ═════════════");
                    System.out.println("║ Sua agencia.: " + agenciaBanco);
                    System.out.println("║ Seu numero da conta do banco..: " + (numeroContaBanco));
                    System.out.print("║ Digite seu primeiro nome.: ");
                    nomeCliente = scanner.next();
                    System.out.println("╚════════════════════════════════════════════");

                    carregando();
                    TimeUnit.SECONDS.sleep(2);

                    System.out.println(" ");
                    System.out.println("╔═════════════ BankDigitalBank ══════════════╗");
                    System.out.println("║ Para iniciar um novo cadastro digite...: 1 ║");
                    System.out.println("║ Para fazer login digite................: 2 ║");
                    System.out.println("║ Para sair..............................: 0 ║");
                    System.out.println("╚════════════════════════════════════════════╝");
                    idMenu = scanner.nextInt();
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println("╔═════════════ BankDigitalBank ═════════════");
                    System.out.println("║ Sua agencia.: " + agenciaBanco);
                    System.out.print("║ Digite seu numero da conta do banco..: ");
                    int inputNumeroContaBanco = scanner.nextInt();
                    System.out.print("║ Digite seu nome.: ");
                    String inputNomeCliente = scanner.next();
                    System.out.println("╚════════════════════════════════════════════");

                    carregando();
                    TimeUnit.SECONDS.sleep(2);

                    if (numeroContaBanco != inputNumeroContaBanco && nomeCliente != inputNomeCliente) {
                        limpaConsole();
                        System.out.println("* Usuario ou senha incorretos *");
                        idMenu = 2;
                    }

                    verificarLogin = true;

                    interfaceUsuarioBanco(idMenu, agenciaBanco, numeroContaBanco, saldo, nomeCliente, scanner,
                            formatarDecimal);

                    idMenu = scanner.nextInt();
                    System.out.println(" ");

                    break;
                case 3:
                    if (verificarLogin != true) {
                        idMenu = -1;
                        break;
                    }
                    System.out.println("╔═════════════ BankDigitalBank ═════════════╗");
                    System.out.println("║ Digite o valor que voce deseja adicinar.: ║");
                    System.out.print("║ valor.: ");
                    System.out.println("╚═══════════════════════════════════════════╝");
                    saldo = saldo + scanner.nextInt();

                    interfaceUsuarioBanco(idMenu, agenciaBanco, numeroContaBanco, saldo, nomeCliente, scanner,
                            formatarDecimal);
                    idMenu = scanner.nextInt();
                    System.out.println(" ");
                    break;
                case 4:
                    if (verificarLogin != true) {
                        idMenu = -1;
                        break;
                    }
                    System.out.println("╔═════════════ BankDigitalBank ═════════════╗");
                    System.out.println("║ Digite o valor que voce deseja sacar....: ║");
                    System.out.print("║ valor.: ");

                    int valorSolicitado = scanner.nextInt();

                    carregando();
                    TimeUnit.SECONDS.sleep(2);

                    if (valorSolicitado < saldo) {
                        saldo = saldo - valorSolicitado;
                    } else {
                        System.out.println(" ");
                        System.out.println("║ Não foi possivel sacar,  ");
                        System.out.println("║ valor superior ao saldo na conta, ");
                    }

                    System.out.println("╚═══════════════════════════════════════════╝");
                    TimeUnit.SECONDS.sleep(4);

                    interfaceUsuarioBanco(idMenu, agenciaBanco, numeroContaBanco, saldo, nomeCliente, scanner,
                            formatarDecimal);
                    idMenu = scanner.nextInt();
                    System.out.println(" ");
                    break;
                default:
                    if (idMenu != 0) {
                        limpaConsole();
                        System.out.println("esta opcao nao existe");
                        interfaceInicialBanco();
                        idMenu = scanner.nextInt();
                        break;
                    }
            }

        } while (idMenu != 0);

    }

    public static void interfaceInicialBanco() {
        System.out.println(" ");
        System.out.println("╔════════ BankDigitalBank ═══════╗");
        System.out.println("║ Para cadastrar-se digite...: 1 ║");
        System.out.println("║ Para fazer login...........: 2 ║");
        System.out.println("║ Para sair..................: 0 ║");
        System.out.println("╚════════════════════════════════╝");
    }

    public static void interfaceUsuarioBanco(int idMenu, String agenciaBanco, int numeroContaBanco, Double saldo,
            String nomeCliente, Scanner scanner, DecimalFormat formatarDecimal) {
        System.out.println(" ");
        System.out.println("╔═ Bem vindo Sr." + nomeCliente);
        System.out.println("║ Agencia.: " + agenciaBanco + "   Conta.: " + numeroContaBanco);
        System.out.println("║ Seu saldo.: " + formatarDecimal.format(saldo));
        System.out.println("╚════════════════════════════════");
        System.out.println(" ");
        System.out.println("╔═════════════ BankDigitalBank ════════════╗");
        System.out.println("║ Para adicionar saldo digite..........: 3 ║");
        System.out.println("║ Para remover saldo digite............: 4 ║");
        System.out.println("║ Para sair............................: 0 ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }

    public static void limpaConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void carregando() {
        System.out.println(" ");
        System.out.println("  Aguarde .....");
    }
}
