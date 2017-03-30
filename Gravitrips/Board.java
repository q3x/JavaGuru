public class Board {
    private static final int ROW = 6;
    private static final int COLUMN = 7;
    private static final Symbol EMPTY = Symbol.EMPTY;
    private Symbol[][] gameField = new Symbol[ROW][COLUMN];

    public Board() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                gameField[i][j] = EMPTY;
            }
        }
    }

    public void printBoard() {
        System.out.println(1 + " " + 2 + " " + 3 + " " + 4 + " " + 5 + " " + 6 + " " + 7);
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean makeMove(int playerMove, Symbol symbol) {
        for (int i = ROW - 1; i >= 0; i--) {
            if (gameField[i][playerMove] == EMPTY) {
                gameField[i][playerMove] = symbol;
                return true;
            }
        }
        System.out.println("Column is full, try another column!");
        return false;
    }

    public boolean checkWin(int playerMove, Symbol symbol) {
        int rowPosition = 0;

        for (int i = 0; i < ROW; i++) {
            if (gameField[i][playerMove] != EMPTY) {
                rowPosition = i;
                break;
            }
        }

            if (checkVertical(playerMove, symbol, rowPosition))
                return true;
            if (checkHorizontalLeft(playerMove, symbol, rowPosition))
                return true;
            if (checkHorizontalRight(playerMove, symbol, rowPosition))
                return true;
            if (checkMajorDiagonalUp(playerMove, symbol, rowPosition))
                return true;
            if (checkMajorDiagonalDown(playerMove, symbol, rowPosition))
                return true;
            if (checkMinorDiagonalDown(playerMove, symbol, rowPosition))
                return true;
            if (checkMinorDiagonalUp(playerMove, symbol, rowPosition))
                return true;

        return false;
    }

    private boolean checkMinorDiagonalDown(int playerMove, Symbol symbol, int rowPosition) {
        int counter = 1;

        for (int i = rowPosition + 1, j = playerMove - 1; i < ROW && j >= 0; i++, j--) {
            if (symbol == gameField[i][j]) {
                counter++;
            } else {
                break;
            }
        }

        if (counter >= 4) {
            return true;
        }

        return false;
    }

    private boolean checkMinorDiagonalUp(int playerMove, Symbol symbol, int rowPosition) {
        int counter = 1;

        for (int i = rowPosition - 1, j = playerMove + 1; i >= 0 && j < COLUMN; i--, j++) {
            if (gameField[i][j] == symbol) {
                counter++;
            } else {
                break;
            }
        }

        if (counter >= 4) {
            return true;
        }

        return false;
    }

    private boolean checkMajorDiagonalUp(int playerMove, Symbol symbol, int rowPosition) {
        int counter = 1;

        for (int i = rowPosition - 1, j = playerMove - 1; i >= 0 && j >= 0; i--, j--) {
            if (gameField[i][j] == symbol) {
                counter++;
            } else {
                break;
            }
        }

        if (counter == 4) {
            return true;
        }

        return false;
    }

    private boolean checkMajorDiagonalDown(int playerMove, Symbol symbol, int rowPosition) {
        int counter = 1;

        for (int i = rowPosition + 1, j = playerMove + 1; i < ROW && j < COLUMN; i++, j++) {
            if (gameField[i][j] == symbol) {
                counter++;
            } else {
                break;
            }
        }

        if (counter >= 4) {
            return true;
        }

        return false;
    }

    private boolean checkHorizontalLeft(int playerMove, Symbol symbol, int rowPosition) {
        int counter = 1;

        for (int i = playerMove - 1; i >= 0; i--) {
            if (gameField[rowPosition][i] == symbol) {
                counter++;
            } else {
                break;
            }
        }

        if (counter >= 4) {
            return true;
        }

        return false;
    }

    private boolean checkHorizontalRight(int playerMove, Symbol symbol, int rowPosition) {
        int counter = 1;

        for (int i = playerMove + 1; i < COLUMN; i++) {
            if (gameField[rowPosition][i] == symbol) {
                counter++;
            } else {
                break;
            }
        }

        if (counter >= 4) {
            return true;
        }

        return false;
    }

    private boolean checkVertical(int playerMove, Symbol symbol, int rowPosition) {
        int counter = 1;

        if ((rowPosition + 4) <= ROW) {
            for (int i = rowPosition + 1; i <= (rowPosition + 3); i++) {
                if (gameField[i][playerMove] == symbol) {
                    counter++;
                } else {
                    break;
                }
            }
        }

        if (counter == 4) {
            System.out.println("COUNTER: " + counter);
            return true;
        }

        return false;
    }
}
