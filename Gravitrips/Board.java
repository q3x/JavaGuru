public class Board {
    private static final int ROW = 6;
    private static final int COLUMN = 7;
    private static final int DEFAULT_COUNTER_VALUE = 1;
    private Symbol[][] gameField = new Symbol[ROW][COLUMN];

    public Board() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                gameField[i][j] = Symbol.EMPTY;
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
            if (gameField[i][playerMove] == Symbol.EMPTY) {
                gameField[i][playerMove] = symbol;
                return true;
            }
        }
        return false;
    }

    public boolean checkWin(int playerMove, Symbol symbol) {
        int rowPosition = 0;

        for (int i = 0; i < ROW; i++) {
            if (gameField[i][playerMove] != Symbol.EMPTY) {
                rowPosition = i;
                break;
            }
        }

        if ((checkVertical(playerMove, symbol, rowPosition)) ||
                (checkHorizontalLeft(playerMove, symbol, rowPosition)) ||
                (checkHorizontalRight(playerMove, symbol, rowPosition)) ||
                (checkMajorDiagonalUp(playerMove, symbol, rowPosition)) ||
                (checkMajorDiagonalDown(playerMove, symbol, rowPosition)) ||
                (checkMinorDiagonalDown(playerMove, symbol, rowPosition)) ||
                (checkMinorDiagonalUp(playerMove, symbol, rowPosition))) {
            return true;
        }
        return false;
    }

    private boolean checkMinorDiagonalDown(int playerMove, Symbol symbol, int rowPosition) {
        int counter = DEFAULT_COUNTER_VALUE;

        for (int i = rowPosition + 1, j = playerMove - 1; i < ROW && j >= 0; i++, j--) {
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

    private boolean checkMinorDiagonalUp(int playerMove, Symbol symbol, int rowPosition) {
        int counter = DEFAULT_COUNTER_VALUE;

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
        int counter = DEFAULT_COUNTER_VALUE;

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
        int counter = DEFAULT_COUNTER_VALUE;

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
        int counter = DEFAULT_COUNTER_VALUE;

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
        int counter = DEFAULT_COUNTER_VALUE;

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
        int counter = DEFAULT_COUNTER_VALUE;

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
            return true;
        }

        return false;
    }
}
