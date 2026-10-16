package service;

import java.util.List;
import model.Dispositivo;
import model.Computador;
import model.Impressora;
import model.Roteador;


public class RelatorioService {
    public void exibirRelatorio(List<Dispositivo> dispositivos){
        System.out.println("== RELATÓRIO FINAL ==\n");

        if(dispositivos.isEmpty() || dispositivos == null) {
            System.out.println("Não existem dispositivos cadastrados no sistema");
            return;   
        }

        double total = dispositivos.size(); 

        //contagem dinâmica por tipo de dispositivos
        long qtdComputadores = dispositivos.stream().filter(d -> d instanceof Computador).count();
        long qtdImpressoras = dispositivos.stream().filter(d -> d instanceof Impressora).count();
        long qtdRoteadores = dispositivos.stream().filter(d -> d instanceof Roteador).count();

        System.out.println("Total de Dispositivos: " + (int) total);
        System.out.println("Total de Computadores: " + qtdComputadores);
        System.out.println("Total de Impressoras: " + qtdImpressoras);
        System.out.println("Total de Roteadores: " + qtdRoteadores);
    
        System.out.printf("Percentual de Computadores: %.2f%%%n", (qtdComputadores / total) * 100);
        System.out.printf("Percentual de Impressoras: %.2f%%%n", (qtdImpressoras / total) * 100);
        System.out.printf("Percentual de Roteadores: %.2f%%%n", (qtdRoteadores / total) * 100);
    }
}
