import java.util.ArrayList;
import java.util.List;

/**
 * mock game for test
 */
public class mockGame extends Game {
    private final List<Integer> testNumber;
    private int index;

    /**
     * game constructor
     *
     * @param row       is the number of rows in the game
     * @param col       is the number of columns in the game
     * @param bishopPos initial position of bishop [x,y]
     * @param rookPos   initial position of rook [x,y]
     * @param round     the maximum rounds, in this case, if rook survives, it wins
     */
    public mockGame(int row, int col, int[] bishopPos, int[] rookPos, int round) {
        super(row, col, bishopPos, rookPos, round);
        testNumber = new ArrayList<>();
        index = 0;
    }

    public void addTestNumber(int[] num) {
        testNumber.clear();
        for (int n : num) {
            testNumber.add(n);
        }
        index = 0;
    }

    public String pos() {
        return "" + ((char) (rookPos[0] + 'a'))
                + (rookPos[1] + 1);
    }

    @Override
    protected int random(int min, int max) {
        return testNumber.get(index++);
    }
}
