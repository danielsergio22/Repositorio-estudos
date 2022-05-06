package Estudos.Java.Testes;

import java.io.IOException;

import javax.swing.JOptionPane;

public class TesteRuntimeEMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        int i;
        i = Integer.parseInt(JOptionPane.showInputDialog(null, "Abra um aplicativo \n\n [0] - Ferramenta de captura\n [1] - GeForceNOW\n [outros] Sair", "1"));
        if(i != 0 && i != 1) System.exit(0); 
        Process a = (i == 0 ? Runtime.getRuntime().exec("SnippingTool.exe") : Runtime.getRuntime().exec
        ("C:\\Users\\dsdan\\AppData\\Local\\NVIDIA Corporation\\GeForceNOW\\CEF\\GeForceNOW.exe"));
        a.waitFor();
        //if ternário exige que vc atribua seu valor para alguem
        TesteRuntimeEMain.main(null); //É possivel executar um main de outro programa chamando pelo nomeDaClasse.main(Args)
    }
}
