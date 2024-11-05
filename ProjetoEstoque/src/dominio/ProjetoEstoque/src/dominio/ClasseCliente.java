package dominio;

public class ClasseCliente extends Cliente {
    public String getTelefone;

    public ClasseCliente() {
        super();
    }

    public ClasseCliente(int codigo, String nome, String email, String telefone) {
        super(codigo, nome, email, telefone);
    }

}
