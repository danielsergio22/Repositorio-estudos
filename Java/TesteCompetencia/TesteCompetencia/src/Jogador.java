import java.util.ArrayList;

public class Jogador {
    int id;
    String nome;
    ArrayList<String> arrayOldNames = new ArrayList<>();
    int kills = 0;
    int score = 0;

    Jogador(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "{\n\t\t\t\"id\": " + id 
        + ",\n\t\t\t\"nome\": \"" + nome 
        + "\",\n\t\t\t\"kills\": " + score
        + ",\n\t\t\t\"old names\": " + arrayOldNames + "\n\t\t}";
    }

    
}
