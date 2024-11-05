package fakedb;

import java.util.ArrayList;

import dominio.ClasseCliente;

public class ClasseClienteFakeDB extends BaseFakeDB<ClasseCliente> {

    @Override
    protected void preencherDados() {
        this.tabela = new ArrayList<ClasseCliente>();
        this.tabela.add(new ClasseCliente(1, "Nome", "Email", "(xxxxxxxxx)"));
    }

    public ClasseClienteFakeDB() {
        super();
    }
}
