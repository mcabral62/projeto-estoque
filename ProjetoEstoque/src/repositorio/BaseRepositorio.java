package repositorio;

import java.util.ArrayList;

public abstract class BaseRepositorio<T> {

    protected ArrayList<T> dados;

    public ArrayList<T> getTabela() {
        return dados;
    }

    public abstract T Read(int chave);

    public abstract T Edit(T instancia);

    public abstract T Add(T instancia);

    public abstract T Delete(int chave);
}
