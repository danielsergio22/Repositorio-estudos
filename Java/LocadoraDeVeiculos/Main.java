package Estudos.Java.LocadoraDeVeiculos;

import java.util.Scanner;

import javax.swing.JOptionPane;


public class Main {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char tipoVeiculo;
        boolean start;
        do{
            System.out.println("Deseja Utilizar a Locadora de Veiculos? S/N");
            if(sc.next().equalsIgnoreCase("S")){
                start = true;
            } else {
                start = false;
                break;
            }
            
            System.out.println("Escolha o tipo do veiculo: <P>asseio | <C>arga");
            tipoVeiculo = sc.next().toUpperCase().charAt(0);
            
            switch(tipoVeiculo){
                case 'P':
                    VeiculoPasseio vPasseio = new VeiculoPasseio();
                    vPasseio.calculaCustosProd(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o custo de produção", "Orçamento", 3)));
                    vPasseio.calculaValor(vPasseio.getCustosProd(), 25, 11, 14.5);
                    JOptionPane.showMessageDialog(null, vPasseio.toString(), "+++ Veiculo de Passeio +++", 1);
                break;

                case 'C':
                    VeiculoCarga vCarga = new VeiculoCarga();
                    vCarga.calculaCustosProd(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o custo de produção", "Orçamento", 3)));
                    vCarga.calculaValor(vCarga.getCustosProd(), 25, 11, 14.5, 6);
                    JOptionPane.showMessageDialog(null, vCarga.toString(), "+++ Veiculo de Carga +++", 1);
                break;
            }
        } while(start);
        sc.close();
    }
}
