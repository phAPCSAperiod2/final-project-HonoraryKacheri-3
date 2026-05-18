import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        PokemonTeam defaultTeam = new PokemonTeam("Gabagool");

        System.out.println("Hello! What is your name? ");
        String userName = input.nextLine();
        System.out.println("Ah, " + userName + "! Now, what shall you do next?");
        System.out.println("1: Add Pokemon to your team. \n2: Create a new team.");
        int action = input.nextInt();
        input.nextLine();

        if (action == 1) {
            PokemonTeam.printAllTeams();
            System.out.print("Enter the team number to add this Pokemon to: ");
            int teamNumber = input.nextInt();
            input.nextLine();
            PokemonTeam selectedTeam = PokemonTeam.getTeamByNumber(teamNumber);
            if (selectedTeam == null) {
                System.out.println("No team found with number " + teamNumber + ". Adding to the default team instead.");
                selectedTeam = defaultTeam;
            }

            for (int i = 0; i < 6; i++) {
                System.out.println("Create your Pokemon!");
                System.out.print("What is its name? ");
                String newPokemonName = input.nextLine();
                System.out.println();
                System.out.print("What is its first type? ");
                String newType1 = input.nextLine();
                System.out.print("What is its second type? ");
                String newType2 = input.nextLine();
                System.out.println();
                System.out.println("Now, rapid fire the stats!");
                System.out.print("HP! ");
                int newHP = input.nextInt();
                System.out.print("Attack! ");
                int newATK = input.nextInt();
                System.out.print("Defense! ");
                int newDEF = input.nextInt();
                System.out.print("Special Attack! ");
                int newSPA = input.nextInt();
                System.out.print("Special Defense! ");
                int newSPD = input.nextInt();
                System.out.print("Speed! ");
                int newSPE = input.nextInt();
                input.nextLine();
                System.out.println();
                System.out.println("Congrats, you have made a new Pokemon!");
                Pokemon newPokemon = new Pokemon(newPokemonName, newType1, newType2, newHP, newATK, newDEF, newSPA,
                        newSPD,
                        newSPE);
                System.out.println();
                System.out.println("Now for the moves!");
                boolean keepGoing = true;
                while (keepGoing) {
                    keepGoing = newPokemon.learnMove();
                }
                System.out.println();
                System.out.println("Great, now it has its moves!");
                System.out.println("Now for its item!");
                System.out.print("What is the item's name? ");
                String newItemName = input.nextLine();
                System.out.print("What does it do? ");
                String newItemDesc = input.nextLine();
                newPokemon.setItem(newItemName, newItemDesc);
                System.out.println();
                System.out.println("Finally, for its description!");
                newPokemon.addDescription();
                System.out.println();
                System.out.println("You're done with this one!");

                if (!selectedTeam.addPokemon(newPokemon)) {
                    System.out.println("That team is full. Stopping additions.");
                    break;
                }
            }
        }

        if (action == 2) {
            System.out.println("What will be the team's name?");
            String teamName = input.nextLine();
            PokemonTeam newTeam = new PokemonTeam(teamName);
            System.out.println("Created team " + newTeam.getTeamNumber() + ": " + teamName);
        }
    }
}
