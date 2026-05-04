import java.util.ArrayList;
import java.util.Scanner;
public class PokemonTeam
{
    Scanner input = new Scanner(System.in);
    // private constants
    private static final int MAX_POKEMON = 6;
    private String partyName = "";
    private ArrayList<Pokemon> party;
    private String generalStrategy = "";

    public PokemonTeam(String name){
        this.partyName = name;
        this.party = new ArrayList<Pokemon>();
    }

    public boolean addPokemon(Pokemon p){
        if (party.size() >= 6){
            party.add(p);
            return true;
        }
        else{
            return false;
        }
    }

    public void addStrategy(){
        System.out.println("Input your team's general strategy.");
        generalStrategy = input.nextLine();
    }
}
