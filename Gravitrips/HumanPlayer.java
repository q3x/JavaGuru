import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, Symbol symbol) {
        super(name, symbol);
    }

    @Override
    int move() {
        System.out.println("Your turn, " + getName() + "!");
        System.out.println("Make choice from 1 to 7:");
        Scanner scanner = new Scanner(System.in);
        int playerChoice = scanner.nextInt() - 1;
        while (playerChoice < 0 || playerChoice > 6) {
            System.out.println("Your choice must be from 1 to 7:");
            playerChoice = scanner.nextInt() - 1;
        }
        return playerChoice;
    }
}
