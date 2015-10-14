import java.util.ArrayList;

public class MineSweeper {

    private final int size;
    int width;
    int height;
    private ArrayList<Integer> mineLocations = new ArrayList<>();
    int state = 0;
    ArrayList<Integer> neighbours = new ArrayList<>();

    public MineSweeper(int size, ArrayList<Integer> mineLocations) {
        this.size = size;
        this.mineLocations = mineLocations;
        this.width = (int) Math.sqrt(size);
        this.height = (int) Math.sqrt(size);
    }

    public boolean isEmpty(int location) {
        return !mineLocations.contains(location);
    }

    public int numberOfMinesAround(int location) {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (!isEmpty(-location + counter) || !isEmpty(location + 1)) {
                state = 1;
                counter = counter + 1;
            }
            counter = counter + 1;
        }
        if (mineLocations.contains(location)) {
            state = 0;
        }
        return state;
    }

    public ArrayList<Integer> neighbourCells(int location) {
        int xLocation = ((location % width));
        int yLocation = ((location / height));

        notTopLeftCorner(location, xLocation);

        notFirstRow(location, yLocation);

        notTopRightCorner(location, xLocation, yLocation);

        notFirstColumn(xLocation, location - 1);

        notLastColumn(location, xLocation);

        notBottomLeftCorner(location, xLocation, yLocation);

        notBottomRow(location, yLocation);

        notBottomRightCorner(location, xLocation, yLocation);

        return neighbours;
    }

    private void notBottomRightCorner(int location, int xLocation, int yLocation) {
        if (xLocation < width - 1 && yLocation < height - 1)
            neighbours.add(location + (width + 1));
    }

    private void notBottomRow(int location, int yLocation) {
        if (yLocation < (height - 1))
            neighbours.add(location + width);
    }

    private void notBottomLeftCorner(int location, int xLocation, int yLocation) {
        if (xLocation > 0 && (yLocation < (height - 1)))
            neighbours.add(location + (width - 1));
    }

    private void notLastColumn(int location, int xLocation) {
        if (xLocation < (width - 1))
            neighbours.add(location + 1);
    }

    private void notFirstColumn(int xLocation, int e) {
        if (xLocation > 0)
            neighbours.add(e);
    }

    private void notTopRightCorner(int location, int xLocation, int yLocation) {
        if (xLocation < (width - 1) && yLocation > 0)
            neighbours.add(location - (width - 1));
    }

    private void notFirstRow(int location, int yLocation) {
        if (yLocation > 0)
            neighbours.add(((location - (width))));
    }

    private void notTopLeftCorner(int location, int xLocation) {
        if (xLocation > 0 && location > 0)
            neighbours.add((location - (width) - 1));
    }
}
