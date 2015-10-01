import java.util.ArrayList;

public class MineSweeper {

    private ArrayList<Integer> mineLocations = new ArrayList<>();

    public MineSweeper(int size, ArrayList<Integer> mineLocations) {
        this.mineLocations = mineLocations;
    }

    public boolean checkEmpty(int location) {
        return !mineLocations.contains(location);
    }
}

