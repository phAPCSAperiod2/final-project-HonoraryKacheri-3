import java.util.ArrayList;
import java.util.Scanner;

public class Pokemon {
    // Private constants
    Scanner input = new Scanner(System.in);
    private static final int MAX_HEALTH = 500;
    private static final int MAX_MOVES = 4;

    private String name;
    private String type1;
    private String type2;
    private int hp;
    private int atk;
    private int def;
    private int spa;
    private int spd;
    private int spe;
    private ArrayList<Moves> movesList;
    private String roleDesc;
    private String strategyDesc;
    private String item;
    private String itemDesc;

    public Pokemon(String pokemonName, String type1, String type2, int hp, int atk, int def, int spa, int spd,
            int spe) {
        this.name = pokemonName;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spa = spa;
        this.spd = spd;
        this.spe = spe;
        this.movesList = new ArrayList<Moves>();
        String strategy = "";
        this.strategyDesc = strategy;
        this.type1 = type1;
        this.type2 = type2;
        this.item = "";
        this.itemDesc = "";
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return hp;
    }

    public boolean learnMove() {
        System.out.print("What will be the move's name? ");
        String moveName = input.nextLine();
        System.out.println();
        System.out.print("What will be the move's type? ");
        String moveType = input.nextLine();
        System.out.println();
        System.out.print("How much damage does it do? ");
        int moveDamage = input.nextInt();
        if (moveDamage == 0) {
            System.out.println("What does the move do?");
            String moveDesc = input.nextLine();
            System.out.println(
                    "It will be named " + moveName + ", be " + moveType + "type, and it will " + moveDesc + ".");
            if (movesList.size() >= MAX_MOVES) {
                return false;
            } else {
                movesList.add(Moves(moveName, moveType, moveDesc));
                return true;
            }
        } else {
            System.out.println();
            System.out.println(
                    "It will be named " + moveName + ", be " + moveType + " type, and deal " + moveDamage + " damage.");
            if (movesList.size() >= 4) {
                return false;
            } else {
                movesList.add(Moves(moveName, moveType, moveDamage));
                return true;
            }
        }
    }

    private Moves Moves(String moveName, String moveType, int moveDamage) {
        throw new UnsupportedOperationException("Unimplemented method 'Moves'");
    }

    private Moves Moves(String moveName, String moveType, String moveDesc) {
        throw new UnsupportedOperationException("Unimplemented method 'Moves'");
    }

    public void setItem(String itemName, String itemDesc) {
        this.item = itemName;
        this.itemDesc = itemDesc;
    }

    public String getItem() {
        return ("The name is " + this.item + ", and it's description is: " + this.itemDesc);
    }

    public int getHP() {
        return this.hp;
    }

    public int getATK() {
        return this.atk;
    }

    public int getDEF() {
        return this.def;
    }

    public int getSPA() {
        return this.spa;
    }

    public int getSPD() {
        return this.spd;
    }

    public int getSPE() {
        return this.spe;
    }

    public String getRole() {
        return this.roleDesc;
    }

    public String getStrategy() {
        return this.strategyDesc;
    }

    public String getTypes() {
        return ("This Pokemon is a " + type1 + " type, and a " + type2 + " type.");
    }

    public boolean canLearnMoreMoves() {
        if (movesList.size() >= 4) {
            return false;
        } else {
            return true;
        }
    }

    public void forgetMove(int i) {
        movesList.remove(i);
    }

    public void addDescription() {
        System.out.println("Describe what your Pokemon should do, what role it should fill.");
        String roleDesc = input.nextLine();
        System.out.println(
                "Describe what strategies your Pokemon would do, such as move sequences or synergies/counters with other Pokemon.");
        String strategyDesc = input.nextLine();
        this.roleDesc = roleDesc;
        this.strategyDesc = strategyDesc;
    }

    public String toString() {
        return (getName() + " (Health: " + hp + " / " + MAX_HEALTH + ")");
    }

    public ArrayList<Moves> getMoves() {
        return movesList;
    }

    public boolean knowsMove(Moves move) {
        return movesList.contains(move);
    }
}
