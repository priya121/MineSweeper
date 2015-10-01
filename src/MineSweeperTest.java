import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MineSweeperTest {

    @Test
    public void oneByOneGridIsEmpty() {
        MineSweeper game = new MineSweeper(1);
        assertTrue(game.checkEmpty(0));
    }

    @Test
    public void oneByOneGridWithMine() {
        ArrayList<Integer> mineLocations = new ArrayList<>();
        mineLocations.add(0);
        MineSweeper game = new MineSweeper(1, mineLocations);
        assertFalse(game.checkEmpty(0));
    }

    @Test
    public void twoByTwoGridWithOneMine() {
        ArrayList<Integer> mineLocations = new ArrayList<>();
        mineLocations.add(0);
        MineSweeper game = new MineSweeper(2,mineLocations);
        assertFalse(game.checkEmpty(0));
    }

    @Test
    public void twoByTwoGridWithTwoMines() {
        ArrayList<Integer> mineLocations = new ArrayList<>();
        mineLocations.add(0);
        mineLocations.add(1);
        MineSweeper game = new MineSweeper(2,mineLocations);
        assertFalse(game.checkEmpty(0));
        assertFalse(game.checkEmpty(1));
    }

    @Test
    public void twoByTWoGridWithTwoMinesNotAdjacent() {
        ArrayList<Integer> mineLocations = new ArrayList<>();
        mineLocations.add(0);
        mineLocations.add(2);
        MineSweeper game = new MineSweeper(2,mineLocations);
        assertFalse(game.checkEmpty(0));
        assertFalse(game.checkEmpty(2));
    }
}

