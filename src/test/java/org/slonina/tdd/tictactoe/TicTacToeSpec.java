package org.slonina.tdd.tictactoe;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

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

    @Test
    public void whenNewGameThenPlayerX()
    {
        String nextPlayer = ticTacToe.nextPlayer();

        assertThat(nextPlayer, is(equalTo("X"))) ;
    }

    @Test
    public void whenLastPlayerWasXThenNextPlayerO()
    {
        ticTacToe.play(1,1);

        String nextPlayer = ticTacToe.nextPlayer();

        assertThat(nextPlayer, is(equalTo("O"))) ;
    }

    @Test
    public void whenPlayThenNoWinner()
    {
        String result = ticTacToe.play(1,1);

        assertThat(result, is(equalTo(null)));

    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner()
    {
        ticTacToe.play(1,1);
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 1);
        ticTacToe.play(2,2);
        String winner = ticTacToe.play(3, 1);

        assertThat(winner, is(equalTo("X")));
    }

    @Test
    public void whenPlayAndWholeVerticalLineThenWinner()
    {
        ticTacToe.play(1,1);
        ticTacToe.play(2, 1);
        ticTacToe.play(3, 1);
        ticTacToe.play(2,2);
        ticTacToe.play(3,2);
        String winner = ticTacToe.play(2,3);

        assertThat(winner, is(equalTo("O")));
    }

    @Test
    public void whenPlayAndWholeDiagonalLineThenWinner1()
    {
        ticTacToe.play(1,1);
        ticTacToe.play(2, 1);
        ticTacToe.play(2, 2);
        ticTacToe.play(3,1);
        String winner = ticTacToe.play(3, 3);

        assertThat(winner, is(equalTo("X")));
    }

    @Test
    public void whenPlayAndWholeDiagonalLineThenWinner2()
    {
        ticTacToe.play(3,1);
        ticTacToe.play(1, 1);
        ticTacToe.play(2, 2);
        ticTacToe.play(3,2);
        String winner = ticTacToe.play(1, 3);

        assertThat(winner, is(equalTo("X")));
    }

}
