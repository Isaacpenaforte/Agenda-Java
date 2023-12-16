import java.util.Scanner;

public class App {
    static int escolhaModoPrimeiro = 1;
    static int entrada;
    static Scanner ler = new Scanner(System.in);

    public static int lerInt(Scanner ler) {
        int numero;

        while (true) {

            if (ler.hasNextInt()) {
                numero = ler.nextInt();
                break;
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro válido.");
                ler.nextLine();
            }
        }

        return numero;
    }

    public static Long lerLong(Scanner ler) {
        Long numero;

        while (true) {

            if (ler.hasNextLong()) {
                numero = ler.nextLong();
                break;
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número válido.");
                ler.nextLine();
            }
        }

        return numero;
    }

    public static void main(String[] args) throws Exception {

        int escolha, decisao = 1;
        Scanner ler = new Scanner(System.in);

        System.out.println("Bem vindo a sua Agenda!");
        System.out.println("O que deseja fazer?");

        while (decisao == 1) { // Variavel decisao = 1 mantem o usuario no menu de opções caso decida em
                               // continuar a utilizar o programa após finalizar alguma ação
            while (escolhaModoPrimeiro == 1) {// Variavel escolhaModoPrimeiro = 1 mantem o usuario no menu de opções
                                              // enquanto não selecionar uma das opções disponiveis

                System.out.println("1- Buscar Contato");
                System.out.println("2- Adicionar Contato");
                System.out.println("3- Remover Contato");
                System.out.println("4- Contatos");
                System.out.println("5- Finalizar");

                escolha = lerInt(ler);
                ler.nextLine();

                switch (escolha) {

                    case 1:
                        int escolhaModo = 1;
                        while (escolhaModo == 1) {// Variavel escolhaModo = 1 mantem o usuario no menu de opções
                                                  // enquanto não selecionar uma das opções disponiveis
                            System.out.println("1- Por Nome");
                            System.out.println("2- Por Telefone");
                            System.out.println("3- Por Email");
                            System.out.println("4- Voltar");
                            escolha = ler.nextInt();

                            switch (escolha) {
                                case 1:
                                    Agenda.procurarNome();
                                    escolhaModo++;
                                    escolhaModoPrimeiro++;
                                    break;
                                case 2:
                                    Agenda.procurarNumero();
                                    escolhaModo++;
                                    escolhaModoPrimeiro++;
                                    break;
                                case 3:
                                    Agenda.procurarEmail();
                                    escolhaModo++;
                                    escolhaModoPrimeiro++;
                                    break;
                                case 4:
                                    escolhaModo++;
                                    escolhaModoPrimeiro++;
                                    break;
                                default:
                                    System.out.println("Escolha uma opcao disponivel!");
                            }
                        }
                        break;

                    case 2:// Adicionar Contato
                        Agenda.adicionarContato();
                        escolhaModoPrimeiro++;
                        break;

                    case 3:// Remover Contato
                        Agenda.removerContato();
                        escolhaModoPrimeiro++;
                        break;

                    case 4:// Quantidade Contato
                        Agenda.quantidadeContatos();
                        System.out.println();
                        escolhaModoPrimeiro++;
                        break;

                    case 5:// Sair
                        System.exit(0);
                        escolhaModoPrimeiro++;
                        break;

                    default:
                        System.out.println("Escolha uma opcao disponivel!");
                        break;
                }
            }

            System.out.println("Deseja realizar mais alguma acao?");
            System.out.println("1-Sim, voltar ao menu.");
            System.out.println("2-Nao, sair do programa.");

            decisao = App.lerInt(ler);
            if (decisao != 2) {
                decisao = 1;
                escolhaModoPrimeiro = 1;
            }
        }
        System.out.println("Programa finalizado!");
    }
}