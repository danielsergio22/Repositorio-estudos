package Estudos.Java.LocadoraDeVeiculos;

import javax.swing.JOptionPane;

public abstract class Veiculo {

    private int id,km,ano;
    private String marca,modelo,cor;
    private long chassi;
    private double valorVenda,custosProd;

    void calculaCustosProd(double custosProd){
        this.custosProd = custosProd + (custosProd * 0.25);
    }
    
    void calculaValor(double custosProd, double margemLucro){
        valorVenda = custosProd + custosProd * (margemLucro / 100);
    }
    
    void EntradaDadosVeiculos(){
        setId(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ID", "Cadastro", 3)));
        setMarca(JOptionPane.showInputDialog(null, "Informe a marca", "Cadastro", 3));
        setModelo(JOptionPane.showInputDialog(null, "Informe o modelo", "Cadastro", 3));
        setCor(JOptionPane.showInputDialog(null, "Informe a cor", "Cadastro", 3));
        setChassi(Long.parseLong(JOptionPane.showInputDialog(null, "Informe o número do chassi", "Cadastro", 3)));
        setAno(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ano", "Cadastro", 3)));
        setKm(Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a kilometragem", "Cadastro", 3)));
    }

    public String dadosVeiculos() {
        return "\nID: " + id + "\nMarca: " + marca   + "\nModelo: " + modelo + "\nCor: " + cor +
        "\nChassi: " + chassi +"\nAno: " + ano + "\nQuilometragem: " + String.format("%d km",km);
    }

    public String dadosValores(){
        return "\nCustosProd: " + String.format("R$ %.2f", custosProd)
        + "\nValor de venda: " + String.format("R$ %.2f", valorVenda);
    }

    public double getCustosProd() {
        return custosProd;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setChassi(long chassi) {
        this.chassi = chassi;
    }
}
