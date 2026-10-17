import java.util.Scanner;
import model.Computador;
import model.Dispositivo;
import model.Impressora;
import model.Roteador;
import repository.DispositivoRepository;
import repository.DispositivoRepositoryImpl;
import service.RelatorioService;
import util.LeitorConsole;

public class App {

    private final DispositivoRepository repository;
    private final LeitorConsole leitor;
    private final RelatorioService relatorioService;

    public App(DispositivoRepository repository, LeitorConsole leitor, RelatorioService relatorioService) {
        this.repository = repository;
        this.leitor = leitor;
        this.relatorioService = relatorioService;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        DispositivoRepository repository = new DispositivoRepositoryImpl();
        LeitorConsole leitor = new LeitorConsole(sc);
        RelatorioService relatorioService = new RelatorioService();

        App app = new App(repository, leitor, relatorioService);
        app.executar();
    }

    public void executar() {
        int opcao;
        do {
            exibirMenu();
            opcao = leitor.lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarComputador();
                    break;
                case 2: 
                    cadastrarImpressora();
                    break;
                case 3:
                    cadastrarRoteador();
                    break; 
                case 4:
                    listarDispositivos();
                    break;
                case 5:
                    ligarDispositivo();
                    break;
                case 6:
                    desligarDispositivo();
                    break;
                case 7:
                    buscarDispositivo();
                    break;
                case 8:
                    System.out.println("Saindo do Sistema...");
                    break;
                default:
                    System.out.println("Opção Indisponível, tente novamente!");
            }
        } while (opcao != 8);

        relatorioService.exibirRelatorio(repository.listarTodos());
    }

    public static void exibirMenu(){
        System.out.println("=== MENU DE OPÇÕES DA LOJA ===\n");
        System.out.println("1. Cadastrar Computador");
        System.out.println("2. Cadastrar Impressora");
        System.out.println("3. Cadastrar Roteador");
        System.out.println("4. Listar Dispositivos");
        System.out.println("5. Ligar Dispositivo");
        System.out.println("6. Desligar Dispositivo");
        System.out.println("7  Exibir detalhes de um Dispositivo");
        System.out.println("8. Sair");
    }

    private void cadastrarComputador(){
        System.out.println("== CADASTRO DE COMPUTADOR ==");
        String nomeComputador = leitor.lerTexto("Digite o nome: ");
        String codigoComputador = leitor.lerTexto("Digite o código: ");
        String fabricanteComputador = leitor.lerTexto("Digite o fabricante: ");
        int quantidadeRAM = leitor.lerInteiro("Digite a quantidade de RAM: ");
        String sistemaOperacional = leitor.lerTexto("Digite o Sistema Operacional: ");

        Computador computador = new Computador(nomeComputador, codigoComputador, fabricanteComputador, quantidadeRAM, sistemaOperacional);
        repository.salvar(computador);
        System.out.println("Computador cadastrado com sucesso");
    } 
    
    private void cadastrarImpressora(){
        System.out.println("== CADASTRO DE IMPRESSORA ==");
        String nomeImpressora = leitor.lerTexto("Digite o nome: ");
        String codigoImpressora = leitor.lerTexto("Digite o código: ");
        String fabricanteImpressora = leitor.lerTexto("Digite o fabricante: ");
        String tipoTinta = leitor.lerTexto("Tipo de tinta: ");
        int velocidadeImpressao = leitor.lerInteiro("Velocidade impressão: ");
        
        Impressora impressora = new Impressora(nomeImpressora, codigoImpressora, fabricanteImpressora, tipoTinta, velocidadeImpressao);
        repository.salvar(impressora);
        System.out.println("Impressora cadastrada com sucesso");
    }
    
    private void cadastrarRoteador(){
        System.out.println("== CADASTRO DE ROTEADOR ==");
        String nomeRoteador = leitor.lerTexto("Digite o nome: ");
        String codigoRoteador = leitor.lerTexto("Digite o código: ");
        String fabricanteRoteador = leitor.lerTexto("Digite o fabricante: ");
        int quantidadePortas = leitor.lerInteiro("Quantidade de portas: ");
        int velocidadeRede = leitor.lerInteiro("Velocidade da Rede: ");
        
        Roteador roteador = new Roteador(nomeRoteador, codigoRoteador, fabricanteRoteador, quantidadePortas, velocidadeRede);
        repository.salvar(roteador);
        System.out.println("Roteador cadastrado com sucesso");
    }
    
    private void listarDispositivos() {
        if (repository.estaVazio()) {
            System.out.println("Não existem dispositivos cadastrados.");
            return;
        }
        System.out.println("\n== LISTA DE DISPOSITIVOS ==");
        for (Dispositivo dispositivo : repository.listarTodos()) {
            dispositivo.exibirDispositivo();
        }
    }
    
    private void ligarDispositivo() {
        String codigo = leitor.lerTexto("Digite o código do dispositivo: ");
        repository.buscarPorCodigo(codigo).ifPresentOrElse(
            Dispositivo::ligar,
            () -> System.out.println("Dispositivo não encontrado")
        );
    }
    
    private void desligarDispositivo() {
        String codigo = leitor.lerTexto("Digite o código do dispositivo: ");
        repository.buscarPorCodigo(codigo).ifPresentOrElse(
            Dispositivo::desligar,
            () -> System.out.println("Dispositivo não encontrado")
        );
    }

    private void buscarDispositivo() {
        String codigo = leitor.lerTexto("Digite o código do dispositivo: ");
        repository.buscarPorCodigo(codigo).ifPresentOrElse(
            Dispositivo::exibirDispositivo,
            () -> System.out.println("Dispositivo não encontrado")
        );
    }
}
   
