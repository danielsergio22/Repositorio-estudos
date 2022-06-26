package Estudos.Java.ProgramasSimples;

import java.util.Scanner;

public class LongestWord {
    public static String longestWord(String sen) {
        sen = sen.replaceAll("\\p{Punct}", "");
        String[] frase = sen.split(" ");
        sen = frase[0];
        for(String palavra : frase){
          
          if(palavra.length() > sen.length()){
            sen = palavra;
          }
        }
        return sen;
      }
    
      public static void main (String[] args) {  
        // keep this function call here     
        Scanner s = new Scanner(System.in);
        System.out.print(longestWord(s.nextLine())); 
        s.close();
      }
    
}