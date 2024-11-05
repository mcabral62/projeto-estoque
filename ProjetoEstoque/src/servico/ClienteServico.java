package servico;

import java.util.ArrayList;
import repositorio.ClienteRepositorio;
import dominio.Cliente;

public class ClienteServico extends BaseServico<Cliente> {

    private ClienteRepositorio repositorio;

    public ClienteServico() {
        this.repositorio = new ClienteRepositorio();
    }

    @Override
    public ArrayList<Cliente> Navegar() {
        return new ArrayList<>(this.repositorio.getTabela());
    }

    @Override
    public Cliente Ler(int chave) {
        return this.repositorio.Read(chave);
    }

    @Override
    public Cliente Editar(Cliente obj) {
        return this.repositorio.Edit(obj);
    }

    @Override
    public Cliente Adicionar(Cliente obj) {
        return this.repositorio.Add(obj);
    }

    @Override
    public Cliente Deletar(int chave) {
        return this.repositorio.Delete(chave);
    }
}
