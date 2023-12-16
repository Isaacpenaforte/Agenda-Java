import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

    static String nome, email;
    static long telefone;
    static int numLista, id = 0;
    static Scanner ler = new Scanner(System.in);

    static ArrayList<Contato> listaContatos = new ArrayList<>();

    public static ArrayList<Contato> getArrayList() {
        return listaContatos;
    }

    public static void procurarNome() {

        System.out.println("Nome do contato: ");
        nome = ler.nextLine();
        int numContatos = 0;
        for (Contato contato : listaContatos) {
            if (contato.getNome().equals(nome)) {
                numContatos++;
                System.out.println("Contato: " + numContatos);
                System.out.println("Contato: '" + nome + "':");
                contato.mostrarContato();
                System.out.println("-----------------------------------------");
            }
        }
        if (numContatos == 0) {
            System.out.println("Contato com nome '" + nome + "' não encontrado.");
        }
    }

    public static void procurarEmail() {

        System.out.println("Email do contato: ");
        email = ler.nextLine();
        int numContatos = 0;
        for (Contato contato : listaContatos) {
            if (contato.getEmail().equals(email)) {
                numContatos++;
                System.out.println("Contato " + numContatos + ": '" + email + "'");
                contato.mostrarContato();
                System.out.println("-----------------------------------------");
            }
        }
        if (numContatos == 0) {
            System.out.println("Contato com email '" + email + "' não encontrada.");
        }
    }

    public static void procurarNumero() {
        System.out.println("Telefone do contato: ");
        telefone = App.lerLong(ler);
        int numContatos = 0;
        for (Contato contato : listaContatos) {
            if (contato.getTelefone() == telefone) {
                numContatos++;
                System.out.println("Contato: " + numContatos);
                System.out.println("Contato: '" + telefone + "'");
                contato.mostrarContato();
                System.out.println("-----------------------------------------");
            }
        }
        if (numContatos == 0) {
            System.out.println("Contato com telefone '" + telefone + "' não encontrado.");
        }
    }

    public static void adicionarContato() {

        System.out.println("Digite o nome do contato:");
        nome = ler.nextLine();
        System.out.println("Digite o email do contato:");
        email = ler.nextLine();
        System.out.println("Digite o telefone do contato:");
        telefone = App.lerLong(ler);
        ler.nextLine();
        id++;
        listaContatos.add(new Contato(nome, email, telefone, id));
    }

    public static void removerContato() {

        System.out.println("Nome do contato: ");
        nome = ler.nextLine();
        int numContatos = 0;
        ArrayList<Contato> listaContatosRep = new ArrayList<>();

        for (Contato contato : listaContatos) {
            if (contato.getNome().equals(nome)) {
                numContatos++;
                id++;
                listaContatosRep.add(contato);
            }
        }
        if (numContatos == 0) {
            System.out.println("Contato com nome '" + nome + "' não encontrado.");
        } else if (listaContatosRep.size() > 1) {
            System.out.println("Foram encontrados " + numContatos + " com esse nome!");
            for (Contato contato : listaContatosRep) {
                System.out.println("Contato: " + contato);
                contato.mostrarContato();
                contato.mostrarID();
            }
            System.out.println("Escolha o ID do contato a ser removido:");
            int idEscolha = ler.nextInt();

            for (Contato contato : listaContatosRep) {
                if (contato.getId() == idEscolha) {
                    listaContatos.remove(contato);
                    System.out.println("Contato com nome de '" + contato.getNome() + "' foi removido com sucesso.");
                }
            }
        } else {
            for (Contato contato : listaContatos) {
                if (contato.getNome().equals(nome)) {
                    listaContatos.remove(contato);
                    System.out.println("Contato com nome de '" + nome + "' foi removido comsucesso.");
                    break;
                }
            }
        }
    }

    // Quantidade de contatos e mostra dados cadastrados
    public static void quantidadeContatos() {
        if (listaContatos.size() != 0) {
            System.out.println("Numero de contatos " + listaContatos.size());
            for (int i = 0; i < listaContatos.size(); i++) {
                Contato nomeContato = listaContatos.get(i);
                System.out.println(nomeContato);
            }
        } else {
            System.out.println("Nenhum contato registrado!");
        }
    }

}