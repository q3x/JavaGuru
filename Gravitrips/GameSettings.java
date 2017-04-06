import java.util.Scanner;

public class GameSettings {
    private static final int PVP = 1;
    private static final int PVC = 2;
    private static final int CVC = 3;
    private static final int CVP = 4;

    private Player p1;
    private Player p2;
    private Player currentPlayer;

    public void showGameSettings() {
        System.out.println("*** Welcome to GRAVITRIPS! ***");
        boolean exit = false;
        while (!exit) {
            System.out.println("Choose game mode:");
            System.out.println("1. Player vs Player");
            System.out.println("2. Player vs Computer");
            System.out.println("3. Computer vs Computer");
            System.out.println("4. Computer vs Player");
            Scanner scanner = new Scanner(System.in);
            int mode = scanner.nextInt();
            if (mode == PVP) {
                playerVsPlayerMode();
                exit = true;
            } else if (mode == PVC) {
                playerVsComputerMode();
                exit = true;
            } else if (mode == CVC) {
                computerVsComputerMode();
                exit = true;
            } else if (mode == CVP) {
                computerVsPlayerMode();
                exit = true;
            } else {
                System.out.println("Choose: 1, 2, 3 or 4");
            }
        }
        System.out.println("\nOk, lets begin the game!\n");
    }

    private void playerVsComputerMode() {
        System.out.println("\n---[ Player vs Computer ]---");
        System.out.print("Please, enter your name: ");
        p1 = new HumanPlayer(new Scanner(System.in).next(), Symbol.X);
        p2 = new AiPlayer("Computer", Symbol.O);
        currentPlayer = p1;
    }

    private void playerVsPlayerMode() {
        System.out.println("\n---[ Player vs Player ]---");
        System.out.print("PLAYER 1, please, enter your name: ");
        p1 = new HumanPlayer(new Scanner(System.in).next(), Symbol.X);
        System.out.print("PLAYER 2, please, enter your name: ");
        p2 = new HumanPlayer(new Scanner(System.in).next(), Symbol.O);
        currentPlayer = p1;
    }

    private void computerVsComputerMode() {
        System.out.println("\n---[ Computer vs Computer ]---");
        p1 = new AiPlayer("Computer 1", Symbol.X);
        p2 = new AiPlayer("Computer 2", Symbol.O);
        currentPlayer = p1;
    }

    private void computerVsPlayerMode() {
        System.out.println("\n---[ Computer vs Player ]---");
        System.out.print("Please, enter your name: ");
        p1 = new AiPlayer("Computer", Symbol.X);
        p2 = new HumanPlayer(new Scanner(System.in).next(), Symbol.O);
        currentPlayer = p1;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

}
