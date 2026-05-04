public class Moves
{
    // Private constants
    private static final int MAX_DAMAGE = 150;

    private String moveName;
    private String type;
    private int damage;

    public Moves(String attackName, String attackType, int attackDamage){
        this.moveName = attackName;
        this.type = attackType;
        this.damage = attackDamage;
        if (attackDamage > MAX_DAMAGE){
            this.damage = 150;
        }
    }

    public Moves(String attackName, String attackType, String moveDescription){
        this.moveName = attackName;
        this.type = attackType;
        this.damage = 0;
    }

    public String getName(){
        return moveName;
    }

    public int getDamage(){
        return damage;
    }

    public String getType(){
        return type;
    }

    public String toString(){
        String toStringReturn = (moveName + " (" + damage + " damage)");
        return toStringReturn;
    }
}
