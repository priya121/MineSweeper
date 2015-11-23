package test;

import main.GameState;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameStateTest {
    ArrayList<Integer> mineLocations = new ArrayList<>();
    ArrayList<Integer> userGuesses = new ArrayList<>();
    String[] intermediateGrid = new String[]{"•", "1", "•", "•"};
    GameState newGame = new GameState(4, mineLocations, intermediateGrid);


    @Test
    public void checksGameOver() {
        String[] intermediateGrid = new String[]{"•", "*", "•", "•"};
        assertTrue(newGame.checkGameOver(intermediateGrid));
    }

    @Test
    public void returnsFalseIfGameNotOver() {
        String[] intermediateGrid = new String[]{"•", "1", "•", "•"};
        assertFalse(newGame.checkGameOver(intermediateGrid));
    }

    @Test
    public void revealsMineGridIfHit() {
        String[] intermediateGrid = new String[]{"•", "•", "•", "•"};
        String[] expected = new String[]{"•", "*", "•", "•"};
        mineLocations.add(1);
        GameState newGame = new GameState(4, mineLocations, intermediateGrid);
        assertEquals(expected, newGame.addMineSymbol(mineLocations));
    }

    @Test
    public void revealsMineHit() {
        String[] intermediateGrid = new String[]{"•", "•", "•", "•"};
        String[] expected = new String[]{"•", "*", "•", "•"};
        mineLocations.add(1);
        GameState newGame = new GameState(4, mineLocations, intermediateGrid);
        newGame.revealNeighbours(1);
        assertEquals(expected, intermediateGrid);
    }

    @Test
    public void revealsIntermediateBoardWithGuesses() {
        String[] intermediateGrid = new String[]{"•", "•", "1", "•"};
        String[] expected = new String[]{"•", "•", "1", "•"};
        mineLocations.add(1);
        GameState newGame = new GameState(4, mineLocations, intermediateGrid);
        newGame.revealNeighbours(2);
        assertEquals(expected, intermediateGrid);
    }

    @Test
    public void addsMines() {
        GameState newGame = new GameState(4, mineLocations, intermediateGrid);
        ArrayList<Integer> mineAdditions = new ArrayList<>();
        mineLocations.add(1);
        mineLocations.add(2);
        mineAdditions.add(1);
        mineAdditions.add(2);
        assertEquals(mineLocations, newGame.addMines(mineAdditions));
    }
}