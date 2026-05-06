import java.util.ArrayList;
import java.util.Scanner;

public class PokemonTeam {
    Scanner input = new Scanner(System.in);
    // private constants
    private static final int MAX_POKEMON = 6;
    private String partyName = "";
    private ArrayList<Pokemon> party;
    private String generalStrategy = "";

    public PokemonTeam(String name) {
        this.partyName = name;
        this.party = new ArrayList<Pokemon>();
    }

    public boolean addPokemon(Pokemon p) {
        if (party.size() >= MAX_POKEMON) {
            party.add(p);
            return true;
        } else {
            return false;
        }
    }

    public void addStrategy() {
        System.out.println("Input your team's general strategy.");
        generalStrategy = input.nextLine();
    }

    public String toString() {
        return ("The team is named " + partyName + ", has " + party.size()
                + " Pokemon inside it, and the general strategy is " + generalStrategy);
    }

    public void pokemonList() {
        for (int i = 0; i <= party.size(); i++) {
            System.out.println("Name: " + party.get(i).getName() + ", types: " + party.get(i).getTypes() + ".");
        }
    }
}
