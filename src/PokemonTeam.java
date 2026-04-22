public class PokemonTrainer
{
    // private constants
    private static final int MAX_POKEMON = 6;
    private String trainerName = name;
    private ArrayList<Pokemon> party;

    public PokemonTrainer(String name){
        this.trainerName = name;
        this.party = new ArrayList<Pokemon>();
    }

    public boolean addPokemon(Pokemon p){
        if (party.getSize() >= 6){
            party.add(p);
            return true;
        }
        else{
            return false;
        }
    }
}
