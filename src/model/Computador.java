package model;
public class Computador extends Dispositivo{
    private int qtdRAM;
    private String sistemaOperacional;
    
    public Computador(String nome, String codigo, String fabricante, int qtdRAM, String sistemaOperacional) {
        super(nome, codigo, fabricante);
        this.qtdRAM = qtdRAM;
        this.sistemaOperacional = sistemaOperacional;
    }

    @Override 
    public void exibirDispositivo(){
        System.out.println("\n== COMPUTADOR ==");
        super.exibirDispositivo();
        System.out.println("Quantidade de Memória RAM: " + qtdRAM);
        System.out.println("Sistema Operacional: " + sistemaOperacional);
    }
    public int getQtdRAM() {
        return qtdRAM;
    }

    public void setQtdRAM(int qtdRAM) {
        this.qtdRAM = qtdRAM;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }
}