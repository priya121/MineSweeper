package test;

import main.FakeIO;
import main.UserCoordinateIndex;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;

public class UserCoordinateIndexTest {
    private UserCoordinateIndex userCoordinateIndex;

    private FakeIO getFakeIO(List<String> numbers) {
        return new FakeIO(numbers);
    }

    @Test
    public void userInputsCoordinateInsteadOfIndex() {
        FakeIO io = getFakeIO(asList("A1"));
        userCoordinateIndex = new UserCoordinateIndex(io, 4);
        assertEquals(0, userCoordinateIndex.convertCoordinateToIndex());
    }

    @Test
    public void anotherUserInputsCoordinateInsteadOfIndex() {
        FakeIO io = getFakeIO(asList("B1"));
        userCoordinateIndex = new UserCoordinateIndex(io, 4);
        assertEquals(2, userCoordinateIndex.convertCoordinateToIndex());
    }

    @Test
    public void takesInputWithCCoordinate() {
        FakeIO io = getFakeIO(asList("C3"));
        userCoordinateIndex = new UserCoordinateIndex(io, 9);
        assertEquals(8, userCoordinateIndex.convertCoordinateToIndex());
    }

    @Test
    public void takesInputWithECoordinate() {
        FakeIO io = getFakeIO(asList("E1"));
        userCoordinateIndex = new UserCoordinateIndex(io, 25);
        assertEquals(20, userCoordinateIndex.convertCoordinateToIndex());
    }

    @Test
    public void takesInputWithHCoordinate() {
        FakeIO io = getFakeIO(asList("H6"));
        userCoordinateIndex = new UserCoordinateIndex(io, 100);
        assertEquals(75, userCoordinateIndex.convertCoordinateToIndex());
    }

    @Test
    public void addsTwentyIfRowE() {
        FakeIO io = getFakeIO(asList("H1"));
        userCoordinateIndex = new UserCoordinateIndex(io, 100);
        assertEquals(70, userCoordinateIndex.convertCoordinateToIndex());
    }

    @Test
    public void addsTenIfRowA() {
        FakeIO io = getFakeIO(asList("A10"));
        userCoordinateIndex = new UserCoordinateIndex(io, 100);
        assertEquals(9, userCoordinateIndex.convertCoordinateToIndex());
    }
}
