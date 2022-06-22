import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        File arquivo = new File("lib/Quake.txt");
        Scanner scan = new Scanner(arquivo);
        ArrayList<ArrayList<Jogador>> jogos = new ArrayList<>();
        ArrayList<Jogador> jogo = new ArrayList<>();

        while(scan.hasNextLine()){

            String linha = scan.nextLine();

            // Comando de inicio de um jogo

            if(linha.contains("InitGame:")){

                jogo = new ArrayList<>();
                jogo.add(new Jogador(1022, "<world>"));
                jogos.add(jogo);
                

            // Comando que cria client ou muda seu nome

            }else if(linha.contains("ClientUserinfoChanged:")){

                linha = linha.substring(linha.lastIndexOf("ClientUserinfoChanged:"), linha.indexOf("\\t"));
                String[] arrayLinha = linha.split(" ");
                int id = Integer.parseInt(arrayLinha[1]);
                String nome = linha.substring(linha.lastIndexOf("\\")+1, linha.length());


                for(Jogador player : jogo){
                    if(id == player.id){ //Modifica nome se player ja existe
                        if(!player.nome.equals(nome)){
                            player.arrayOldNames.add("\""+ player.nome +"\"");
                            player.nome = nome;
                        }
                        break;
                    } 
                    else if(player.equals(jogo.get(jogo.size()-1))) { //Cria player se nao existe
                        jogo.add(new Jogador(id,nome));
                        break;
                    }
                }


            // Comando Kill

            }else if(linha.contains("Kill:")){

                linha = linha.substring(linha.lastIndexOf("Kill:"), linha.length());
                
                String[] arrayLinha = linha.split(" ");
                int id1 = Integer.parseInt(arrayLinha[1]);
                int id2 = Integer.parseInt(arrayLinha[2]);

                for(Jogador player : jogo){
                    if(player.id == id1){
                        player.kills++;
                        player.score = id1==id2 ? player.score-1 : player.score+1;
                        continue;
                    } else if(player.id == id2) player.score--;
                }
            }
        }
        scan.close();


        // Organização dos dados de saída

        jogos.forEach(game -> {

            int totalKills = 0;
            String textoPlayer ="";
            
            for(Jogador player: game){

                totalKills += player.kills;

                if(player.id != 1022){
                    if((game.size()) == player.id){
                        textoPlayer += ",\n\t\t" + player.toString();
                    } else if(textoPlayer == ""){
                        textoPlayer += player.toString();
                    } else {
                        textoPlayer += ",\n\t\t" + player.toString();
                    }
                }
            }


        // Saída

            System.out.println("[{\n\n"
                +"  \"game\": " + contGames() + ",\n"
                +"  \"status\": {\n"
                +"\t\"total_kills\": "+ (String.valueOf(totalKills)) +",\n"
                +"\t\"players\": [\n\t\t"
                + textoPlayer 
                +"\n\t]\n"
            +"  }\n}]");
        });

    }

    static int contGames = 0;

    public static String contGames() {
        contGames++;
        return String.valueOf(contGames);
    }
}
