import java.util.ArrayList;
import java.util.Scanner;

public class PokemonTeam {
    Scanner input = new Scanner(System.in);
    private static final int MAX_POKEMON = 6;
    private static ArrayList<PokemonTeam> teams = new ArrayList<>();
    private static int numberOfTeams = 0;

    private String partyName = "";
    private ArrayList<Pokemon> party;
    private String generalStrategy = "";
    private int teamNumber = 0;

    public PokemonTeam(String name) {
        this.partyName = name;
        this.party = new ArrayList<Pokemon>();
        PokemonTeam.numberOfTeams += 1;
        this.teamNumber = PokemonTeam.numberOfTeams;
        PokemonTeam.teams.add(this);
    }

    public static PokemonTeam getTeamByNumber(int number) {
        for (PokemonTeam team : teams) {
            if (team.getTeamNumber() == number) {
                return team;
            }
        }
        return null;
    }

    public static void printAllTeams() {
        System.out.println("Existing teams:");
        for (PokemonTeam team : teams) {
            System.out.println("Team " + team.getTeamNumber() + ": " + team.partyName);
        }
    }

    public boolean addPokemon(Pokemon p) {
        if (party.size() < MAX_POKEMON) {
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
                + " Pokemon inside it, and the general strategy is: " + generalStrategy);
    }

    public void pokemonList() {
        for (int i = 0; i < party.size(); i++) {
            System.out.println("Name: " + party.get(i).getName() + ", types: " + party.get(i).getTypes() + ".");
        }
    }

    public int getTeamNumber() {
        return teamNumber;
    }
}
