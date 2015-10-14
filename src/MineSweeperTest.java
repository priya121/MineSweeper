import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MineSweeperTest {

    private ArrayList<Integer> mineLocations;

    @Before
    public void setUp() throws Exception {
        mineLocations = new ArrayList<>();
    }

    @Test
    public void oneByOneGridIsEmpty() {
        MineSweeper game = new MineSweeper(1, mineLocations);
        assertTrue(game.isEmpty(0));
    }

    @Test
    public void oneByOneGridWithMine() {
        mineLocations.add(0);
        MineSweeper game = new MineSweeper(1, mineLocations);
        assertFalse(game.isEmpty(0));
    }

    @Test
    public void twoByTwoGridWithOneMine() {
        mineLocations.add(0);
        MineSweeper game = new MineSweeper(2, mineLocations);
        assertFalse(game.isEmpty(0));
    }

    @Test
    public void twoByTwoGridWithTwoMines() {
        mineLocations.add(0);
        mineLocations.add(1);
        MineSweeper game = new MineSweeper(2, mineLocations);
        assertFalse(game.isEmpty(0));
        assertFalse(game.isEmpty(1));
    }

    @Test
    public void twoByTWoGridWithTwoMinesNotAdjacent() {
        mineLocations.add(0);
        mineLocations.add(2);
        MineSweeper game = new MineSweeper(4, mineLocations);
        assertFalse(game.isEmpty(0));
        assertFalse(game.isEmpty(2));
    }

    @Test
    public void numberOfMinesAroundEmptyCell() {
        MineSweeper game = new MineSweeper(4, mineLocations);
        assertEquals(0, game.numberOfMinesAround(0));
        assertEquals(0, game.numberOfMinesAround(1));
        assertEquals(0, game.numberOfMinesAround(2));
        assertEquals(0, game.numberOfMinesAround(3));
    }

    @Test
    @Ignore
    public void numberOfMinesAroundOneMine() {
        mineLocations.add(0);
        MineSweeper game = new MineSweeper(4, mineLocations);
        assertEquals(0, game.numberOfMinesAround(0));
        assertEquals(1, game.numberOfMinesAround(1));
        assertEquals(1, game.numberOfMinesAround(2));
        assertEquals(1, game.numberOfMinesAround(3));
    }

    @Test
    @Ignore
    public void numberOfMinesAroundOneMineAtIndex1() {
        MineSweeper game = new MineSweeper(4, mineLocations);
        mineLocations.add(1);
        assertEquals(1, game.numberOfMinesAround(0));
        assertEquals(0, game.numberOfMinesAround(1));
        assertEquals(1, game.numberOfMinesAround(2));
        assertEquals(1, game.numberOfMinesAround(3));
    }

    @Test
    public void allCoordinatesInTwoByTwoWithMine() {
        ArrayList<Integer> indicesAroundMine = new ArrayList<>();
        indicesAroundMine.add(1);
        indicesAroundMine.add(2);
        indicesAroundMine.add(3);
        MineSweeper game = new MineSweeper(4, mineLocations);
        mineLocations.add(0);
        assertEquals(indicesAroundMine, game.indicesAroundMine());
    }

    @Test
    public void numbersAroundMineAtLocation1() {
        ArrayList<Integer> indicesAroundMine = new ArrayList<>();
        indicesAroundMine.add(0);
        indicesAroundMine.add(2);
        indicesAroundMine.add(3);
        MineSweeper game = new MineSweeper(4, mineLocations);
        mineLocations.add(1);
        assertEquals(indicesAroundMine, game.indicesAroundMine());
    }

    @Test
    public void numbersAroundMineAtLocation2() {
        ArrayList<Integer> mineLocations = new ArrayList<>();
        ArrayList<Integer> indicesAroundMine = new ArrayList<>();
        indicesAroundMine.add(0);
        indicesAroundMine.add(1);
        indicesAroundMine.add(3);
        MineSweeper game = new MineSweeper(4, mineLocations);
        mineLocations.add(2);
        assertEquals(indicesAroundMine, game.indicesAroundMine());
    }

    @Test
    public void numbersAroundMineAtLocation3() {
        ArrayList<Integer> mineLocations = new ArrayList<>();
        ArrayList<Integer> indicesAroundMine = new ArrayList<>();
        indicesAroundMine.add(0);
        indicesAroundMine.add(1);
        indicesAroundMine.add(2);
        MineSweeper game = new MineSweeper(4, mineLocations);
        mineLocations.add(3);
        assertEquals(indicesAroundMine, game.indicesAroundMine());
    }

    @Test
    public void indicesAroundTwoMines() {
        ArrayList<Integer> mineLocations = new ArrayList<>();
        MineSweeper game = new MineSweeper(4, mineLocations);
        ArrayList<Integer> indicesAroundMine = new ArrayList<>();
        indicesAroundMine.add(2);
        indicesAroundMine.add(3);
        indicesAroundMine.add(2);
        indicesAroundMine.add(3);
        mineLocations.add(0);
        mineLocations.add(1);
        ArrayList<Integer> indicesAroundIndividualMines = game.indicesAroundMine();
        assertEquals(indicesAroundMine, game.removeIndicesWithMines(4, indicesAroundIndividualMines));
    }

    @Test
    public void indicesAroundTwoMinesNotAdjacent() {
        ArrayList<Integer> mineLocations = new ArrayList<>();
        MineSweeper game = new MineSweeper(4, mineLocations);
        ArrayList<Integer> indicesAroundMine = new ArrayList<>();
        indicesAroundMine.add(0);
        indicesAroundMine.add(3);
        indicesAroundMine.add(0);
        indicesAroundMine.add(3);
        mineLocations.add(1);
        mineLocations.add(2);
        ArrayList<Integer> indicesAroundIndividualMines = game.indicesAroundMine();
        assertEquals(indicesAroundMine, game.removeIndicesWithMines(4, indicesAroundIndividualMines));
    }

    @Test
    public void indicesAroundThreeMines() {
        ArrayList<Integer> indicesAroundMine = new ArrayList<>();
        indicesAroundMine.add(3);
        indicesAroundMine.add(3);
        indicesAroundMine.add(3);
        MineSweeper game = new MineSweeper(4, mineLocations);
        mineLocations.add(0);
        mineLocations.add(1);
        mineLocations.add(2);
        ArrayList<Integer> indicesAroundIndividualMines = game.indicesAroundMine();
        assertEquals(indicesAroundMine, game.removeIndicesWithMines(4, indicesAroundIndividualMines));
    }

    @Test
    public void indicesAroundFourMines() {
        ArrayList<Integer> indicesAroundMine = new ArrayList<>();
        MineSweeper game = new MineSweeper(4, mineLocations);
        mineLocations.add(0);
        mineLocations.add(1);
        mineLocations.add(2);
        mineLocations.add(3);
        ArrayList<Integer> indicesAroundIndividualMines = game.indicesAroundMine();
        assertEquals(indicesAroundMine, game.removeIndicesWithMines(4, indicesAroundIndividualMines));
    }

    @Test
    public void allCoordinatesForThreeByThree() {
        MineSweeper game = new MineSweeper(9, mineLocations);
        assertTrue(game.isEmpty(0));
    }

    @Test
    public void threeByThreeWithAMine() {
        MineSweeper game = new MineSweeper(9, mineLocations);
        assertTrue(game.isEmpty(0));
        mineLocations.add(0);
        assertEquals(0, game.numberOfMinesAround(0));
        assertEquals(1, game.numberOfMinesAround(1));
        assertEquals(0, game.numberOfMinesAround(2));
        assertEquals(1, game.numberOfMinesAround(3));
        assertEquals(1, game.numberOfMinesAround(4));
        assertEquals(1, game.numberOfMinesAround(5));
        assertEquals(0, game.numberOfMinesAround(6));
    }

    @Test
    public void calculatesNeighbouringCellsForFour() {
        MineSweeper game = new MineSweeper(9, mineLocations);
        assertTrue(game.isEmpty(0));
        mineLocations.add(4);
        ArrayList<Integer> neighbours = new ArrayList<>();
        neighbours.add(0);
        neighbours.add(1);
        neighbours.add(2);
        neighbours.add(3);
        neighbours.add(5);
        neighbours.add(6);
        neighbours.add(7);
        neighbours.add(8);
        assertEquals(neighbours, game.neighbourCells(4));
    }

    @Test
    public void calculatesNeighbouringCellsForFive() {
        MineSweeper game = new MineSweeper(9, mineLocations);
        assertTrue(game.isEmpty(0));
        mineLocations.add(5);
        ArrayList<Integer> neighbours = new ArrayList<>();
        neighbours.add(1);
        neighbours.add(2);
        neighbours.add(4);
        neighbours.add(7);
        neighbours.add(8);
        assertEquals(neighbours, game.neighbourCells(5));
    }

    @Test
    public void calculatesNeighbouringCellsForSix() {
        MineSweeper game = new MineSweeper(9, mineLocations);
        assertTrue(game.isEmpty(0));
        mineLocations.add(6);
        ArrayList<Integer> neighbours = new ArrayList<>();
        neighbours.add(3);
        neighbours.add(4);
        neighbours.add(7);
        assertEquals(neighbours, game.neighbourCells(6));
    }
}

