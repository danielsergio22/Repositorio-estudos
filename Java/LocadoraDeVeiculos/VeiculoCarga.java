package Estudos.Java.LocadoraDeVeiculos;

import javax.swing.JOptionPane;

public class VeiculoCarga extends Veiculo {
    
    private String tipoCarga;
    private char tamanho;
    
    private boolean tracaoDupla;
    private float capacidade;
    
    VeiculoCarga(){
        entradaDadosCarga();
    }
    
    void calculaValor(double custosProd, double margemLucro, double ipi, double icms, double cofins){
        setValorVenda(custosProd * (1+(margemLucro / 100)) * (1+(ipi / 100)) * (1+(icms / 100)) * (1+(cofins / 100)) );
    }
    
    void entradaDadosCarga(){
        EntradaDadosVeiculos();
        setTipoCarga(JOptionPane.showInputDialog(null, "Informe o tipo de carga","Cadastro", 3));
        setCapacidade(Float.parseFloat(JOptionPane.showInputDialog(null, "Informe a capacidade","Cadastro", 3)));
        setTamanho(JOptionPane.showInputDialog(null, "Informe o tamanho <P>equeno | <M>édio | <G>rande","Cadastro", 3).charAt(0));
        if(JOptionPane.showConfirmDialog(null, "Informe se o veiculo possue tração dupla","Cadastro", 0, 3) == 0){
            setTracaoDupla(true);
        } else setTracaoDupla(false);
    }

    @Override
    public String toString() {
        return dadosVeiculos() + "\nTipo de carga: " + tipoCarga +
        "\nCapacidade: " + capacidade + "\nTamanho: " + tamanho +
        "\nTracaoDupla: " + tracaoDupla + dadosValores();
    }


    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public void setTamanho(char tamanho) {
        this.tamanho = tamanho;
    }

    public void setTracaoDupla(boolean tracaoDupla) {
        this.tracaoDupla = tracaoDupla;
    }

    public void setCapacidade(float capacidade) {
        this.capacidade = capacidade;
    }
}