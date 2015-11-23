package main;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private final int size;
    private MineSweeper game;
    private IO io;
    private ArrayList<Integer> mineLocations;
    private String[] gridArray;
    private List<Integer> guessedLocations = new ArrayList<>();

    public GameState(int size, ArrayList<Integer> mineLocations, String[] gridArray) {
        this.size = size;
        this.mineLocations = mineLocations;
        this.gridArray = gridArray;
    }

    public boolean checkGameOver(String[] gridArray) {
        for (String individualElement : gridArray) {
            if (individualElement.equals("*")) return true;
        }
        return false;
    }

    public void revealNeighbours(int guessedIndex) {
        this.game = new MineSweeper(io, size, mineLocations);
        guessedLocations.add(guessedIndex);
        for (Integer individualGuess : guessedLocations) {
            if (mineLocations.contains(individualGuess)) addMineSymbol(mineLocations);
            else {
                gridArray[individualGuess] = String.valueOf(game.neighbourMinesFound(individualGuess));
            }
        }

    }

    public String[] addMineSymbol(ArrayList<Integer> mineLocations) {
        for (int i = 0; i < gridArray.length; i++) {
            for (int j = 0; j < mineLocations.size(); j++) {
                if (i == mineLocations.get(j)) {
                    gridArray[i] = "*";
                }
            }
        }
        return gridArray;
    }

    public List<Integer> addMines(ArrayList<Integer> mineAdditions) {
        for (int i = 0; i < mineAdditions.size(); i++) {
            mineLocations.add(mineAdditions.get(i));
        }
        return mineLocations;
    }
}
