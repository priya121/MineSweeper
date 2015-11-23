package main;

import java.util.ArrayList;
import java.util.List;

public class Display {
    private final IO guesses;
    private ArrayList<Integer> mineLocations;
    private int size;
    private String[] gridArray;
    private IO io;
    private String[] columnNumber = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private String[] rowLetter = new String[]{"A  ", "B  ", "C  ", "D  ", "E  ", "F  ", "G  ", "H  ", "I  ", "J  ", "K  "};
    private int counter = 1;
    private int index;
    private List<Integer> usersGuess = new ArrayList<>();

    public Display(IO guesses, ArrayList<Integer> mineLocations, int size) {
        this.guesses = guesses;
        this.mineLocations = mineLocations;
        this.size = size;
        this.gridArray = buildGrid();
    }

    public static void main(String args[]) {
        IO io = new ConsoleIO(System.in, System.out);
        ArrayList<Integer> mineLocations = new ArrayList<>();
        mineLocations.add(1);
        mineLocations.add(10);
        Display game = new Display(io, mineLocations, 100);
        System.out.println(game.convertToStringDisplay(game.buildGrid()));
        System.out.println("Enter a coordinate: \n");
        game.gameLoop();
    }

    public void gameLoop() {
        UserCoordinateIndex locationIndex = new UserCoordinateIndex(guesses, size);
        GameState newGameState = new GameState(size, mineLocations, gridArray);
        while (!newGameState.checkGameOver(gridArray)) {
            newGameState.revealNeighbours(index = locationIndex.convertCoordinateToIndex());
            clearScreen();
            System.out.println(convertToStringDisplay(gridArray));
            System.out.println("Enter a coordinate: \n");
        }
        System.out.println(convertToStringDisplay(gridArray));
    }

    public String[] buildGrid() {
        String[] gridArray = new String[size];
        for (int i = 0; i < size; i++) {
            gridArray[i] = "•";
        }
        return gridArray;
    }

    public String convertToStringDisplay(String[] array) {
        String grid = addColumnNumbers();
        grid = addRowLetters(array, counter, grid);
        return removeLastElement(grid);
    }

    private String addRowLetters(String[] array, int counter, String grid) {
        grid += rowLetter[0];
        for (int i = 0; i < array.length; i++) {
            grid += (array[i] + " ");
            if ((i + 1) % Math.sqrt(size) == 0) {
                grid += "\n";
                grid += (rowLetter[counter++]);
            }
        }
        return grid;
    }

    private String addColumnNumbers() {
        String grid = "   ";
        for (int n = 0; n < Math.sqrt(size); n++) {
            grid += columnNumber[n] + " ";
        }
        grid += "\n";
        return grid;
    }

    private String removeLastElement(String grid) {
        String newGrid = grid.substring(0, grid.length() - 5);
        return newGrid;
    }

    public void clearScreen() {
        String ESC = "\033[2J\033[1;1H";
        System.out.println(ESC);
        System.out.flush();
    }

    public List<Integer> addMines(List<Integer> mineAdditions) {
        for (int i = 0; i < mineAdditions.size(); i++) {
            mineLocations.add(mineAdditions.get(i));
        }
        return mineLocations;
    }
}
