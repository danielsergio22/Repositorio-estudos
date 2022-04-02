package Estudos.Java.LocadoraDeVeiculos;

import javax.swing.JOptionPane;

public class VeiculoPasseio extends Veiculo {
    private byte qtLugares, qtPortas;
    
    VeiculoPasseio(){
        EntradaDadosPasseio();
    }
    
    void calculaValor(double custosProd, double margemLucro, double ipi, double icms){
        setValorVenda(custosProd * (1+(margemLucro / 100)) * (1+(ipi / 100)) * (1+(icms / 100)) );
    }
    
    void EntradaDadosPasseio(){
        EntradaDadosVeiculos();
        setQtLugares(Byte.parseByte(JOptionPane.showInputDialog(null, "Informe a quantidade de lugares", "Cadastro", 3)));
        setQtPortas(Byte.parseByte(JOptionPane.showInputDialog(null, "Informe a quantidade de portas", "Cadastro", 3)));
    }

    @Override
    public String toString() {
        return dadosVeiculos() +
        "\nQuantidade de lugares: " + qtLugares +
        "\nQuantidade de portas: " + qtPortas + dadosValores();
    }
    
    public byte getQtLugares() {
        return qtLugares;
    }

    public void setQtLugares(byte qtLugares) {
        this.qtLugares = qtLugares;
    }
    
    public byte getQtPortas() {
        return qtPortas;
    }
    
    public void setQtPortas(byte qtPortas) {
        this.qtPortas = qtPortas;
    }
}
