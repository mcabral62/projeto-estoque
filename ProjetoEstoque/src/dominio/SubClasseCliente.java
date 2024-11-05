package dominio;

public class SubClasseCliente extends BaseCliente {
    private int codigoClasse;

    public int getCodigoClasse() {
        return codigoClasse;
    }

    public void setCodigoClasse(int codigoClasse) {
        this.codigoClasse = codigoClasse;
    }

    public SubClasseCliente() {
        super();
    }

    public SubClasseCliente(int codigo, String nome, String email, String telefone, int codigoClasse) {
        super(codigo, nome, email, telefone);
        this.codigoClasse = codigoClasse;
    }

}
