import java.util.ArrayList;

public class MineSweeper {

    private final int size;
    private ArrayList<Integer> mineLocations = new ArrayList<>();
    private ArrayList<Integer> numbersAroundMines = new ArrayList<>();
    int state = 0;
    ArrayList<Integer> neighbours = new ArrayList<>();

    public MineSweeper(int size, ArrayList<Integer> mineLocations) {
        this.size = size;
        this.mineLocations = mineLocations;
    }

    public boolean isEmpty(int location) {
        return !mineLocations.contains(location);
    }

    public ArrayList<Integer> indicesAroundMine() {
        ArrayList<Integer> indicesAroundIndividualMine = new ArrayList<>();

        for (int i = 0; i < mineLocations.size(); i++) {
            if (notTopRowOrFirstColumn(mineLocations.get(i))) {
                indicesAroundIndividualMine.add(mineLocations.get(i) - 3);
            }
            if (notTopRow(mineLocations.get(i))) {
                indicesAroundIndividualMine.add(mineLocations.get(i) - 2);
            }

            if (notFirstColumn(mineLocations.get(i))) {
                indicesAroundIndividualMine.add(mineLocations.get(i) - 1);
            }

            if (notLastColumn(mineLocations.get(i))) {
                indicesAroundIndividualMine.add(mineLocations.get(i) + 1);
            }

            if (notBottomRow(mineLocations.get(i))) {
                indicesAroundIndividualMine.add(mineLocations.get(i) + 2);
            }

            if (notBottomRowLastColumn(mineLocations.get(i))) {
                indicesAroundIndividualMine.add(mineLocations.get(i) + 3);
            }
        }
        return indicesAroundIndividualMine;
    }

    public ArrayList<Integer> removeIndicesWithMines(int size, ArrayList<Integer> mineLocations) {
        for (Integer mineLocation : mineLocations) {
            if (isEmpty(mineLocation)) {
                numbersAroundMines.add(mineLocation);
            }
        }
        return numbersAroundMines;
    }

    public int numberOfMinesAround(int location) {
        if (!isEmpty(location - 1) || !isEmpty(location - 3) || !isEmpty(location - 4) || !isEmpty(location - 5)) {
            state = 1;
        } else if (!isEmpty(location) || !mineLocations.contains(location)) {
            state = 0;
        }
        return state;
    }

    private boolean notBottomRowLastColumn(int mineLocationIndex) {
        if (mineLocationIndex == 0) {
            return true;
        }
        return false;
    }

    private boolean notLastColumn(int mineLocationIndex) {
        if (mineLocationIndex != 3) {
            return true;
        }
        return false;
    }

    private boolean notTopRow(int mineLocationIndex) {
        if ((mineLocationIndex >= 2)) {
            return true;
        }
        return false;
    }

    private boolean notFirstColumn(int mineLocationIndex) {
        if (mineLocationIndex != 0) {
            return true;
        }
        return false;
    }

    private boolean notBottomRow(int mineLocationIndex) {
        if (mineLocationIndex <= 1) {
            return true;
        }
        return false;
    }

    private boolean notTopRowOrFirstColumn(int mineLocationIndex) {
        if (mineLocationIndex == 3) {
            return true;
        }
        return false;
    }

    public ArrayList<Integer> neighbourCells(int location) {
        int width = (int) Math.sqrt(size);
        int height = (int) Math.sqrt(size);
        int xLocation = ((location % width));
        int yLocation = ((location / height));

        if (xLocation > 0 && location > 0)
            neighbours.add((location - (width) - 1));

        if (yLocation > 0)
            neighbours.add(((location - (width))));

        if (xLocation < (width - 1) && yLocation > 0)
            neighbours.add(location - (width - 1));

        if (xLocation > 0)
            neighbours.add(location - 1);

        if (xLocation < (width - 1))
            neighbours.add(location + 1);

        if (xLocation > 0 && (yLocation < (height - 1)))
        neighbours.add(location + (width - 1));

        if (yLocation < (height - 1))
        neighbours.add(location + width);

        if (xLocation < width - 1 && yLocation < height - 1)
        neighbours.add(location + (width + 1));

        return neighbours;
    }
}
