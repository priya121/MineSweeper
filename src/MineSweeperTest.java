import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MineSweeperTest {
    @Test
    public void emptyCellIsZero() {
        ArrayList<String> grid = new ArrayList<>();
        ArrayList<String> expectedGrid = new ArrayList<>();
        expectedGrid.add("0");
        assertEquals(expectedGrid, MineSweeper.gridState(grid, "0", 1));
    }

    @Test
    public void cellWithMineIsSymbol() {
        ArrayList<String> grid = new ArrayList<>();
        ArrayList<String> expectedGrid = new ArrayList<>();
        expectedGrid.add("*");
        assertEquals(expectedGrid, MineSweeper.gridState(grid, "*", 1));
    }

    @Test
    public void emptyTwoByTwoGrid() {
        ArrayList<String> grid = new ArrayList<>();
        ArrayList<String> expectedGrid = new ArrayList<>();
        expectedGrid.add("0");
        expectedGrid.add("0");
        expectedGrid.add("0");
        expectedGrid.add("0");
        assertEquals(expectedGrid, MineSweeper.gridState(grid, "0 0 0 0", 4));
    }

    @Test
    public void twoByTwoGridWithAMine() {
        ArrayList<String> grid = new ArrayList<>();
        ArrayList<String> expectedGrid = new ArrayList<>();
        expectedGrid.add("*");
        expectedGrid.add("1");
        expectedGrid.add("1");
        expectedGrid.add("1");
        assertEquals(expectedGrid, MineSweeper.gridState(grid, "* 0 0 0", 4));
    }

    @Test
    @Ignore
    public void twoByTwoGridWithTwoMines() {
        ArrayList<String> grid = new ArrayList<>();
        ArrayList<String> expectedGrid = new ArrayList<>();
        expectedGrid.add("*");
        expectedGrid.add("*");
        expectedGrid.add("2");
        expectedGrid.add("2");
        assertEquals(expectedGrid, MineSweeper.gridState(grid, "* * 0 0", 4));
    }
}
