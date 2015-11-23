package main;

public class UserCoordinateIndex {
    int size;
    IO io;

    public UserCoordinateIndex(IO io, int size) {
        this.io = io;
        this.size = size;
    }

    public int convertCoordinateToIndex() {
        char[] coordinates = io.takeInput().toCharArray();
        int row = coordinates[0] - 'A';
        if (coordinates.length > 2) {
            int column = Character.getNumericValue(coordinates[1] + coordinates[2]);
            return converts(row, column);
        }
        int column = Character.getNumericValue(coordinates[1]);

        return converts(row, column);
    }

    public int converts(int row, int column) {
        return (int) (row * (Math.sqrt(size)) + (column - 1));
    }
}
