package org.slonina.tdd.tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Lukasz Slonina <lukasz.slonina@gmail.com>
 */
public class TicTacToeSpec {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private TicTacToe ticTacToe;

    @Before
    public void setUp() throws Exception {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideTheBoardThenException()
    {
        exception.expect(RuntimeException.class);

        ticTacToe.play(5, 2);
    }

    @Test
    public void whenXInsideTheBoardThenNoException()
    {
        ticTacToe.play(3, 2);
    }

    @Test
    public void whenYOutsideTheBoardThenException()
    {
        exception.expect(RuntimeException.class);

        ticTacToe.play(2, 5);
    }

    @Test
    public void whenYInsideTheBoardThenNoException()
    {
        ticTacToe.play(2, 3);
    }

    @Test
    public void whenOcupiedTheException()
    {
        ticTacToe.play(1, 1);
        exception.expect(RuntimeException.class);
        ticTacToe.play(1, 1);
    }

}
