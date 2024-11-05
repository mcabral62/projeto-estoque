package repositorio;

import dominio.Cliente;
import fakedb.ClienteFakeDB;

public class ClienteRepositorio extends BaseRepositorio<Cliente> {

    private ClienteFakeDB db;

    public ClienteRepositorio() {
        this.db = new ClienteFakeDB();
        this.dados = this.db.getTabela(); // Atribui a lista de clientes da fake DB
    }

    @Override
    public Cliente Read(int chave) {
        for (Cliente cli : this.dados) {
            if (cli.getCodigo() == chave) {
                return cli;
            }
        }
        return null;
    }

    @Override
    public Cliente Edit(Cliente instancia) {
        Cliente cliente = this.Read(instancia.getCodigo());
        if (cliente != null) {
            cliente.setNome(instancia.getNome());
            cliente.setEmail(instancia.getEmail());
            cliente.setTelefone(instancia.getTelefone());
            return cliente;
        }
        return null;
    }

    @Override
    public Cliente Add(Cliente instancia) {
        int proxChave = this.dados.isEmpty() ? 1 : this.dados.get(this.dados.size() - 1).getCodigo() + 1;
        instancia.setCodigo(proxChave);
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public Cliente Delete(int chave) {
        Cliente cliente = this.Read(chave);
        if (cliente != null) {
            this.dados.remove(cliente);
            return cliente;
        }
        return null;
    }
}
