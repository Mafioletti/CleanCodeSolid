import java.util.ArrayList;
import java.util.Scanner;

import model.Computador;
import model.Dispositivo;
import model.Impressora;
import model.Roteador;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList <Dispositivo> dispositivos = new ArrayList<>();
    public static void main(String[] args) {
        
        int opcao = 0;
        double qtdTotal = 0;
        double qtdComputadores = 0;
        double qtdImpressoras = 0;
        double qtdRoteadores = 0;

        do{
            exibirMenu();
            opcao = sc.nextInt();
            sc.nextLine();

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

        exibirRelatorio(qtdTotal, qtdComputadores, qtdImpressoras, qtdRoteadores);
    }

    public static void cadastrarComputador(){
        System.out.println("== CADASTRO DE COMPUTADOR ==");
        String nomeComputador = lerTexto("Digite o nome: ");
        String codigoComputador = lerTexto("Digite o código: ");
        String fabricanteComputador = lerTexto("Digite o fabricante: ");
        int quantidadeRAM = lerInteiro("Digite a quantidade de RAM: ");
        String sistemaOperacional = lerTexto("Digite o Sistema Operacional: ");

        Computador computador = new Computador(nomeComputador, codigoComputador, fabricanteComputador, quantidadeRAM, sistemaOperacional);
        dispositivos.add(computador);
    } 

    public static void cadastrarImpressora(){
        System.out.println("== CADASTRO DE IMPRESSORA ==");
        String nomeImpressora = lerTexto("Digite o nome: ");
        String codigoImpressora = lerTexto("Digite o código: ");
        String fabricanteImpressora = lerTexto("Digite o fabricante: ");
        String tipoTinta = lerTexto("Tipo de tinta: ");
        int velocidadeImpressao = lerInteiro("Velocidade impressão: ");

        Impressora impressora = new Impressora(nomeImpressora, codigoImpressora, fabricanteImpressora, tipoTinta, velocidadeImpressao);
        dispositivos.add(impressora);
    }

    public static void cadastrarRoteador(){
        System.out.println("== CADASTRO DE ROTEADOR ==");
        String nomeRoteador = lerTexto("Digite o nome: ");
        String codigoRoteador = lerTexto("Digite o código: ");
        String fabricanteRoteador = lerTexto("Digite o fabricante: ");
        int quantidadePortas = lerInteiro("Quantidade de portas: ");
        int velocidadeRede = lerInteiro("Velocidade da Rede: ");

        Roteador roteador = new Roteador(nomeRoteador, codigoRoteador, fabricanteRoteador, quantidadePortas, velocidadeRede);
        dispositivos.add(roteador);
    }
    
    public static void listarDispositivos(){
        if(dispositivos.isEmpty()){
            System.out.println("Não existem dispotitivos cadastrados");
        }
        for (Dispositivo dispositivo : dispositivos) {
                dispositivo.exibirDispositivo();
        }
    }
    
    public static void ligarDispositivo(){
        String codigoLigar = lerTexto("Digite o código do dispositivo: ");
            for (Dispositivo dispositivo : dispositivos) {
                if (dispositivo.getCodigo().equals(codigoLigar)){
                    dispositivo.ligar();
                    return;
                }
            }
            System.out.println("Dispositivo não encontrado");
    }
    
    public static void desligarDispositivo(){
        String codigoDesligar = lerTexto("Digite o código do dispositivo: ");
            for (Dispositivo dispositivo : dispositivos) {
                if (dispositivo.getCodigo().equals(codigoDesligar)){
                    dispositivo.desligar();
                    return;
                }
            }
            System.out.println("Dispositivo não encontrado");
    }
    
    public static void buscarDispositivo(){
        String codigoBusca = lerTexto("Digite o código do dispositivo: ");
            for (Dispositivo dispositivo : dispositivos) {
                if (dispositivo.getCodigo().equals(codigoBusca)){
                    dispositivo.exibirDispositivo();
                    return;
                }
            }
            System.out.println("Dispositivo não encontrado");
    }
    
    //////////////////////////////////////////////////////////////////////////////////
    private static String lerTexto(String mensagem){
        System.out.println(mensagem);
        return sc.nextLine();
    }

    private static int lerInteiro(String mensagem){
        System.out.print(mensagem);
        while (!sc.hasNextInt()) { //isso aqui vai validar a entrada até que o proximo caracter nn seja um numero
            System.out.println("Entrada inválida! Digite um número inteiro.");
            sc.next();
            System.out.print(mensagem);
        }
        int valor = sc.nextInt();
        sc.nextLine(); 
        return valor;
    }
    //////////////////////////////////////////////////////////////////////////////////////
    
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

    public static void exibirRelatorio(double qtdTotal,double qtdComputadores,double qtdImpressoras,double qtdRoteadores){

        System.out.println("== RELATÓRIO FINAL ==\n");
        double percentualComputadores = (qtdComputadores/qtdTotal) * 100;
        double percentualImpressoras = (qtdImpressoras/qtdTotal) * 100;
        double percentualRoteadores = (qtdRoteadores/qtdTotal) * 100;

            System.out.println("Total dispositivos: " + qtdTotal);
            System.out.println("Total Computadores: " + qtdComputadores);
            System.out.println("Total Impressoras: " + qtdImpressoras);
            System.out.println("Total Roteadores: " + qtdRoteadores);

            System.out.println("Percentual de Computadores: " + percentualComputadores + "%");
            System.out.println("Percentual de Impressoras: " + percentualImpressoras + "%");
            System.out.println("Percentual de Roteadores: " + percentualRoteadores + "%");
    }
}
