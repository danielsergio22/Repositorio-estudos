package Estudos.Java.ProgramasSimples;

import java.util.Scanner;

public class CamelCase {
    public static String camelCase(String str) {
        str = str.replaceAll("\\p{Punct}", " ");
        String[] frase = str.split(" ");
        str = "";

        for(String palavra : frase){
            if(str.equals("")){
                str += palavra.toLowerCase();
            } else {
                str += palavra.toUpperCase().charAt(0) 
                + palavra.substring(1).toLowerCase();
            }
        }
        return str;
    }
    
      public static void main (String[] args) {  
        // keep this function call here     
        Scanner s = new Scanner(System.in);
        System.out.print(camelCase(s.nextLine())); 
        s.close();
      }
}
