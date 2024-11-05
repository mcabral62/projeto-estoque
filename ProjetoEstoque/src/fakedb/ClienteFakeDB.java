package fakedb;

import dominio.Cliente;
import java.util.ArrayList;

public class ClienteFakeDB extends BaseFakeDB<Cliente> {

    @Override
    protected void preencherDados() {
        this.tabela = new ArrayList<>();
        tabela.add(new Cliente(1, "João Silva", "joao@exemplo.com", "(11) 99999-9999"));
        tabela.add(new Cliente(2, "Maria Oliveira", "maria@exemplo.com", "(11) 98888-8888"));
    }
}
