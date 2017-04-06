public class Game {

    private Board board;
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private boolean gameOver;

    public void startGame() {
        board = new Board();
        showGameSettings();
        int move = 0;
        while (!gameOver) {
            move = currentPlayer.move();
            if (board.makeMove(move, currentPlayer.getSymbol())) {
                board.printBoard();
                checkWin(move);
                switchPlayer();
            } else {
                System.out.println("Column is full, try another column!");
            }
        }
    }

    private void checkWin(int move) {
        if (board.checkWin(move, currentPlayer.getSymbol())) {
            gameOver = true;
            System.out.println(currentPlayer.getName() + " won! Game over!!!");
        }
    }

    private void switchPlayer() {
        if (currentPlayer == p1) {
            currentPlayer = p2;
        } else {
            currentPlayer = p1;
        }
    }

    public void showGameSettings() {
        GameSettings gameSettings = new GameSettings();
        gameSettings.showGameSettings();
        p1 = gameSettings.getP1();
        p2 = gameSettings.getP2();
        currentPlayer = gameSettings.getCurrentPlayer();
    }
}
