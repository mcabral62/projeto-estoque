package dominio;

public class Cliente extends BaseCliente {
    private int codigoSubClasse;
    private double valor;

    public int getCodigoSubClasse() {
        return codigoSubClasse;
    }

    public void setCodigoSubClasse(int codigoSubClasse) {
        this.codigoSubClasse = codigoSubClasse;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente() {
        super();
    }

    public Cliente(int codigo, String nome, String email, String telefone, int codigoSubClasse, double valor) {
        super(codigo, nome, email, telefone);
        this.codigoSubClasse = codigoSubClasse;
        this.valor = valor;
    }

}
