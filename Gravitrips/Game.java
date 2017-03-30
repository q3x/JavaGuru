import java.util.Scanner;

public class Game {
    private static final int PVP = 1;
    private static final int PVC = 2;
    private Board board;
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private boolean gameOver;

    public void startGame() {
        board = new Board();
        setGame();
        int move = 0;
        while (!gameOver) {
            move = currentPlayer.move();
            if (board.makeMove(move, currentPlayer.getSymbol())) {
                board.printBoard();
                checkWin(move);
                switchPlayer();
            }
        }
    }

    private void checkWin(int move) {
        if (board.checkWin(move, currentPlayer.getSymbol())) {
            gameOver = true;
            System.out.println(currentPlayer.getName() + " won! Game over!!!");
        }
    }

    private void setGame() {
        System.out.println("*** Welcome to GRAVITRIPS! ***");
        boolean exit = false;
        while (!exit) {
            System.out.println("Choose game mode:");
            System.out.println("1. Player vs Player");
            System.out.println("2. Player vs Computer");
            Scanner scanner = new Scanner(System.in);
            int mode = scanner.nextInt();
            if (mode == PVP) {
                setPVP();
                exit = true;
            } else if (mode == PVC) {
                setPVC();
                exit = true;
            } else {
                System.out.println("Choose: 1 or 2");
            }
        }
        System.out.println("\nOk, lets begin the game!\n");
    }

    private void setPVC() {
        p1 = new HumanPlayer();
        p2 = new AiPlayer();
        System.out.println("\n---[ Player vs Computer ]---");
        System.out.print("Please, enter your name: ");
        p1.setName(new Scanner(System.in).next());
        p1.setSymbol(Symbol.X);
        p2.setName("Computer");
        p2.setSymbol(Symbol.O);
        currentPlayer = p1;
    }

    private void setPVP() {
        p1 = new HumanPlayer();
        p2 = new HumanPlayer();
        System.out.println("\n---[ Player vs Player ]---");
        System.out.print("PLAYER 1, please, enter your name: ");
        p1.setName(new Scanner(System.in).next());
        p1.setSymbol(Symbol.X);
        System.out.print("PLAYER 2, please, enter your name: ");
        p2.setName(new Scanner(System.in).next());
        p2.setSymbol(Symbol.O);
        currentPlayer = p1;
    }

    private void switchPlayer() {
        if (currentPlayer == p1) {
            currentPlayer = p2;
        } else {
            currentPlayer = p1;
        }
    }
}
