package visao;

import java.util.ArrayList;
import dominio.Cliente;
import servico.ClienteServico;

public class ClienteMenu extends BaseMenu {

    private ClienteServico srvc;

    public ClienteMenu() {
        super();
        this.srvc = new ClienteServico();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;
        while (opcao != 9) {
            Util.LimparConsole();
            System.out.println("Lista de clientes cadastrados");
            System.out.println("1 - Listar clientes");
            System.out.println("2 - Localizar cliente");
            System.out.println("3 - Adicionar cliente");
            System.out.println("4 - Atualizar cliente");
            System.out.println("5 - Remover cliente");
            System.out.println("9 - Sair");
            System.out.println("Selecione uma das opções:");
            opcao = this.scanner.nextInt();
            switch (opcao) {
                case 1:
                    this.Listar();
                    break;
                case 2:
                    this.Localizar();
                    break;
                case 3:
                    this.Adicionar();
                    break;
                case 4:
                    this.Atualizar();
                    break;
                case 5:
                    this.Remover();
                    break;
                case 9:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
    }

    @Override
    public void Listar() {
        Util.LimparConsole();
        System.out.println("Listando clientes");
        ArrayList<Cliente> lista = this.srvc.Navegar();
        for (Cliente cli : lista) {
            this.Imprimir(cli);
        }
        System.out.println("Aperte <ENTER> para continuar");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.LimparConsole();
        System.out.println("Localizando cliente");
        System.out.println("Informe o código do cliente que deseja localizar");
        int cod = this.scanner.nextInt();
        Cliente cli = this.srvc.Ler(cod);
        if (cli != null) {
            this.Imprimir(cli);
        } else {
            System.out.println("ERRO - Código de cliente não encontrado");
        }
        System.out.println("Aperte <ENTER> para continuar");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.LimparConsole();
        System.out.println("Adicionando cliente");
        System.out.println("Informe o nome do cliente:");
        String nome = this.scanner.next();
        System.out.println("Informe o e-mail do cliente:");
        String email = this.scanner.next();
        System.out.println("Informe o telefone do cliente:");
        String telefone = this.scanner.next();
        Cliente cli = new Cliente();
        cli.setNome(nome);
        cli.setEmail(email);
        cli.setTelefone(telefone);
        if (this.srvc.Adicionar(cli) != null) {
            System.out.println("-------------------------------");
            System.out.println("Informações do cliente adicionado abaixo");
            this.Imprimir(cli);
            System.out.println("CLIENTE ADICIONADO COM SUCESSO");
        } else {
            System.out.println("ERRO - Não foi possível adicionar o cliente");
        }
        System.out.println("Aperte <ENTER> para continuar");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.LimparConsole();
        System.out.println("Atualizando Cliente");
        System.out.println("Informe o código do cliente que deseja alterar");
        int cod = this.scanner.nextInt();
        Cliente cli = this.srvc.Ler(cod);
        if (cli != null) {
            System.out.println("-------------------------------");
            System.out.println("Cliente selecionado para alteração:");
            this.Imprimir(cli);
            System.out.println("Informe o novo nome");
            String novoNome = this.scanner.next();
            System.out.println("Informe o novo e-mail");
            String novoEmail = this.scanner.next();
            System.out.println("Informe o novo telefone");
            String novoTelefone = this.scanner.next();
            cli.setNome(novoNome);
            cli.setEmail(novoEmail);
            cli.setTelefone(novoTelefone);
            if (this.srvc.Editar(cli) != null) {
                this.Imprimir(cli);
                System.out.println("ALTERAÇÃO REALIZADA COM SUCESSO");
            } else {
                System.out.println("ERRO - Alteração não pode ser concluída");
            }
        } else {
            System.out.println("ERRO - Código do cliente não encontrado");
        }
        System.out.println("Aperte <ENTER> para continuar");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
        Util.LimparConsole();
        System.out.println("Removendo cliente");
        System.out.println("Informe o código do cliente que deseja remover");
        int cod = this.scanner.nextInt();
        Cliente cli = this.srvc.Ler(cod);
        if (cli != null) {
            if (this.srvc.Deletar(cod) != null) {
                System.out.println("-------------------------------");
                System.out.println("Informações do cliente removido abaixo");
                this.Imprimir(cli);
                System.out.println("CLIENTE REMOVIDO COM SUCESSO");
            } else {
                System.out.println("ERRO - Cliente não pode ser removido");
            }
        } else {
            System.out.println("ERRO - Código de cliente não encontrado");
        }
        System.out.println("Aperte <ENTER> para continuar");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    private void Imprimir(Cliente cli) {
        System.out.println("=================================================");
        System.out.println("Informações do cliente ");
        System.out.println("Código do cliente: " + cli.getCodigo());
        System.out.println("Nome do cliente: " + cli.getNome());
        System.out.println("E-mail do cliente: " + cli.getEmail());
        System.out.println("Telefone do cliente: " + cli.getTelefone());
        System.out.println("=================================================");
    }
}
