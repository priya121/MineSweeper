package main;

import java.util.ArrayList;

public class NeighbourCalculation {
    int width;
    int height;
    ArrayList<Integer> neighbours = new ArrayList<>();
    private ArrayList<Integer> mineLocations;
    private int location;

    public NeighbourCalculation(int location, ArrayList mineLocations) {
        this.location = location;
        this.mineLocations = mineLocations;
        this.width = (int) Math.sqrt(MineSweeper.size);
        this.height = (int) Math.sqrt(MineSweeper.size);
    }

    public ArrayList<Integer> calculate(int location) {
        int xLocation = (location % width);
        int yLocation = (location / height);

        notTopLeftCorner(this.location, xLocation);

        notFirstRow(this.location, yLocation);

        notTopRightCorner(this.location, xLocation, yLocation);

        notFirstColumn(xLocation, this.location - 1);

        notLastColumn(this.location, xLocation);

        notBottomLeftCorner(this.location, xLocation, yLocation);

        notBottomRow(this.location, yLocation);

        notBottomRightCorner(this.location, xLocation, yLocation);

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
        if (xLocation > 0 && location > 1)
            neighbours.add((location - (width) - 1));
    }


}


