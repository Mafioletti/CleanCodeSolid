package model;
public class Impressora extends Dispositivo{
    private String tipoImpressao;
    private int velocidadeImpressao;
    
    public Impressora(String nome, String codigo, String fabricante, String tipoImpressao, int velocidadeImpressao) {
        super(nome, codigo, fabricante);
        this.tipoImpressao = tipoImpressao;
        this.velocidadeImpressao = velocidadeImpressao;
    }
    
@Override 
    public void exibirDispositivo(){
        System.out.println("\n== IMPRESSORA ==");
        super.exibirDispositivo();
        System.out.println("Tipo de Impressão: " + tipoImpressao);
        System.out.println("Velocidade de Impressão: " + velocidadeImpressao);
    }

    public String getTipoImpressao() {
        return tipoImpressao;
    }

    public void setTipoImpressao(String tipoImpressao) {
        this.tipoImpressao = tipoImpressao;
    }

    public int getVelocidadeImpressao() {
        return velocidadeImpressao;
    }

    public void setVelocidadeImpressao(int velocidadeImpressao) {
        this.velocidadeImpressao = velocidadeImpressao;
    }
}