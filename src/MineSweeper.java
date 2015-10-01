import java.util.ArrayList;

public class MineSweeper {
    public static ArrayList<String> gridState(ArrayList<String> grid, String state, int size) {
        for (int i = 0; i <= size - 1; i++) {
            String individualCellState = state.split(" ")[i];
            if (individualCellState.equals("*") && (i < size -1)) {
                grid.add(individualCellState);
                grid.add(i + 1, "1");
                grid.add(i + 2, "1");
                grid.add(i + 3, "1");
                return grid;
            }
            else {
                grid.add(individualCellState);
            }
        }
        return grid;
    }
}
