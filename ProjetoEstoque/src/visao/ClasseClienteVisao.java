package visao;

import java.util.ArrayList;

import dominio.ClasseCliente;
import fakedb.ClasseClienteFakeDB;

public class ClasseClienteVisao {

    public ClasseClienteVisao() {

    }

    public void Exibir() {
        ClasseClienteFakeDB db = new ClasseClienteFakeDB();
        ArrayList<ClasseCliente> lista = db.getTabela();
        for (ClasseCliente cc : lista) {
            System.out.println("Classe de Cliente:");
            System.out.println("Codigo: " + cc.getCodigo());
            System.out.println("Nome: " + cc.getNome());
            System.out.println("Email: " + cc.getEmail());
            System.out.println("Telefone: " + cc.getTelefone());
        }
    }
}
