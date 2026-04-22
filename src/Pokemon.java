import java.util.ArrayList;
import java.util.Scanner;
public class Pokemon
{
    // Private constants
    Scanner input = new Scanner(System.in);
    private static final int MAX_HEALTH = 500;
    private static final int MAX_MOVES = 4;

    private String name;
    private String type;
    private int hp;
    private int atk;
    private int def;
    private int spa;
    private int spd;
    private int spe;
    private String image;
    private ArrayList<Move> movesList;

    public Pokemon(String pokemonName, String type1, String type2, int hp, int atk, int def, int spa, int spd, int spe){
        this.name = pokemonName;
        this.health = hp;
        this.atk = atk;
        this.def = def;
        this.spa = spa;
        this.spd = spd;
        this.spe = spe;
        this.movesList = new ArrayList<Move>();
    }

    public Pokemon(String pokemonName, String type1, String type2, int hp, int atk, int def, int spa, int spd, int spe, String image){
        this.name = pokemonName;
        this.health = hp;
        this.atk = atk;
        this.def = def;
        this.spa = spa;
        this.spd = spd;
        this.spe = spe;
        this.movesList = new ArrayList<Move>();
        this.image = image;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return hp;
    }

    public boolean hasFainted(){
        if (hp <= 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean learnMove(){
        System.out.print("What will be the move's name? ");
        String moveName = scanner.nextLine();
        System.out.println();
        System.out.print("What will be the move's type? ");
        String moveType = scanner.nextLine();
        System.out.println();
        System.out.print("How much damage does it do? ");
        int moveDamage = scanner.nextInt();
        if (moveDamage == 0){
            System.out.println("What does the move do?");
            String moveDesc = scanner.nextLine();
            System.out.println("It will be named " + moveName + ", be " + moveType + "type, and it will " + moveDesc + ".")
            if (movesList.size() >= 4){
                return false;
            }
            else{
                movesList.add(moveName, moveType, moveDesc);
            }
        }
        else{
            System.out.println();
            System.out.println("It will be named " + moveName + ", be " + moveType + " type, and deal " + moveDamage + " damage.");
            if (movesList.size() >= 4){
                return false;
            }
            else{
                movesList.add(moveName, moveType, moveDamage);
                return true;
            }
        }
    }

    public boolean canLearnMoreMoves(){
        if (movesList.size() >= 4){
            return false;
        }
        else{
            return true;
        }
    }

    public void forgetMove(int i){
        movesList.remove(i);
    }

    public String toString(){
        if (image != null){
            return (getName() + " (Health: " + hp + " / " + MAX_HEALTH + ") /n" + image);
        }
        else{
            return (getName() + " (Health: " + hp + " / " + MAX_HEALTH + ")");
        }
    }

    public void setImage(String image){
        this.image = image;
    }

    public String getImage(){
        return image;
    }

    public ArrayList<Move> getMoves(){
        return movesList;
    }

    public boolean knowsMove(Move move){
        return movesList.contains(move);
    }

    public boolean knowsMove(String moveName){
        for (int i = 0; i < movesList.size(); i++){
            if (item.equals(moveName)){
                return true;
            }
        }
        return false;
    }

    public boolean attack(Pokemon opponent, Move move){
        if (knowsMove(move) == true){
            opponent.hp -= move.getDamage();
            return true;
        }
        else{
            return false;
        }
    }

    public boolean attack(Pokemon opponent, String moveName){
        if(this.knowsMove(moveName)){
            for (int i = 0; i < movesList.size(); i++){
                if (moveName.equals(movesList.get(i).getName())){
                    return attack(opponent, movesList.get(i));
                }
            }
        }
        return false;
    }
}
