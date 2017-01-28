package org.slonina.tdd.tictactoe;

/**
 * @author Lukasz Slonina <lukasz.slonina@gmail.com>
 */
public class TicTacToe {
    private Object[][] board = new Object[3][3];
    private String lastPlayer = "O";

    public void play(int x, int y) {
        isWithinBounds(x, y);
        isBoxFree(board[x - 1][y - 1]);

        setBox(x, y);

        lastPlayer = nextPlayer();
    }

    public String nextPlayer() {
        return lastPlayer.equals("X") ? "O" : "X";
    }

    private void setBox(int x, int y) {
        board[x-1][y-1] = new Object();
    }

    private void isBoxFree(Object o) {
        if(o != null)
        {
            throw new RuntimeException();
        }
    }

    private void isWithinBounds(int x, int y) {
        if(isWithinBounds(x)) {
            throw new RuntimeException();
        }

        if(isWithinBounds(y)) {
            throw new RuntimeException();
        }
    }

    private boolean isWithinBounds(int box) {
        return box < 1 || box > 3;
    }
}
