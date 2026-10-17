package model;
public class Roteador extends Dispositivo{
    private int quantidadePortas;
    private int velocidadeRede;
    
    public Roteador(String nome, String codigo, String fabricante, int quantidadePortas, int velocidadeRede) {
        super(nome, codigo, fabricante);
        this.quantidadePortas = quantidadePortas;
        this.velocidadeRede = velocidadeRede;
    }

@Override 
    public void exibirDispositivo(){
        System.out.println("\n== ROTEADOR ==");
        super.exibirDispositivo();
        System.out.println("Quantidade de Portas: " + quantidadePortas);
        System.out.println("Velocidade da Rede: " + velocidadeRede);
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public int getVelocidadeRede() {
        return velocidadeRede;
    }

    public void setVelocidadeRede(int velocidadeRede) {
        this.velocidadeRede = velocidadeRede;
    }

    
}
