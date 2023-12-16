public class Contato {

    public String nome, email;
    public long telefone;
    public int id;

    public Contato(String nome, String email, long telefone, int id) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Email: " + email + ", Telefone: " + telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public int getId() {
        return id;
    }

    public void mostrarContato() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
    }

    public void mostrarID() {
        System.out.println("Id: " + id);
    }
}