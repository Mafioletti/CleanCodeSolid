package model;
public class Dispositivo implements Operavel{
    private String nome;
    private String codigo;
    private String fabricante;
    private boolean ligado = false;

    public Dispositivo(String nome, String codigo, String fabricante) {
        this.nome = nome;
        this.codigo = codigo;
        this.fabricante = fabricante;
    }

    public void exibirDispositivo(){
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Fabricante: " + fabricante);
        exibirStatus();
    }
    @Override
    public void ligar(){
        if(isLigado()){
            System.out.println(getNome() + " já está ligado");
        } else {
            System.out.println(getNome() + " foi ligado");
            setLigado(true);
        }
    }
    @Override
    public void desligar(){
        if(!isLigado()){
            System.out.println(getNome() + " já está desligado");
        } else {
            System.out.println(getNome() + " foi desligado");
            setLigado(false);
        }
    }
    @Override
    public void exibirStatus(){
        System.out.println("Status: " + (isLigado() ? "LIGADO" : "DESLIGADO"));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

}