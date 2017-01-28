package org.slonina.tdd.tictactoe;

/**
 * @author Lukasz Slonina <lukasz.slonina@gmail.com>
 */
public class TicTacToe {
    private String[][] board = new String[3][3];
    private String lastPlayer = "O";

    public String play(int x, int y) {
        isWithinBounds(x, y);
        isBoxFree(board[x - 1][y - 1]);

        lastPlayer = nextPlayer();

        setBox(x, y);

        if (isWin(x, y)) {
            return lastPlayer;
        }

        return null;
    }

    private boolean isWin(int x, int y) {
        return isWholeHorizontalLine(y) || isWholeVerticalLine(x) || isWholeDiagonalLine1() || isWholeDiagonalLine2();

    }

    private boolean isWholeDiagonalLine2() {
        for (int i = 2; i >=0; i--) {
            String box = board[i][2-i];
            if (box == null || !box.equals(lastPlayer)) {
                return false;
            }
        }

        return true;
    }

    private boolean isWholeDiagonalLine1() {
        for (int i = 0; i < 3; i++) {
            String box = board[i][i];
            if (box == null || !box.equals(lastPlayer)) {
                return false;
            }
        }
        return true;
    }

    private boolean isWholeVerticalLine(int column) {
        for (int i = 0; i < 3; ++i) {
            String box = board[column - 1][i];
            if (box == null || !box.equals(lastPlayer))
                return false;
        }

        return true;
    }


    private boolean isWholeHorizontalLine(int row) {
        for (int i = 0; i < 3; ++i) {
            String box = board[i][row - 1];
            if (box == null || !box.equals(lastPlayer))
                return false;
        }

        return true;
    }

    public String nextPlayer() {
        return lastPlayer.equals("X") ? "O" : "X";
    }

    private void setBox(int x, int y) {
        board[x - 1][y - 1] = lastPlayer;
    }

    private void isBoxFree(Object o) {
        if (o != null) {
            throw new RuntimeException();
        }
    }

    private void isWithinBounds(int x, int y) {
        if (isWithinBounds(x)) {
            throw new RuntimeException();
        }

        if (isWithinBounds(y)) {
            throw new RuntimeException();
        }
    }

    private boolean isWithinBounds(int box) {
        return box < 1 || box > 3;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String value = board[j][i];
                System.out.print(value == null ? "-" : value);
            }
            System.out.println();
        }
    }
}
