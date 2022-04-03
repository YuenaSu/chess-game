import Chess.chess;
import Chess.bishop;
import Chess.rook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 */
public class Game {
    private final chess[][] board;
    private final int[] rookPos;
    private final int[] bishopPos;
    private boolean state;
    private String dir;
    private int dis;

    //rounds
    private final int roundMax;
    private int currRound;

    //test mode
    private boolean test;
    private final List<Integer> rndNumber;
    private int testIdx;

    public Game(int row, int col, int[] bishopPos, int[] rookPos, int round){
        this.board = new chess[col][row];
        board[bishopPos[1]][bishopPos[0]] = new bishop();
        board[rookPos[1]][rookPos[0]] = new rook();
        this.bishopPos = bishopPos;
        this.rookPos = rookPos;
        this.roundMax = round - 1;
        currRound = 0;
        state = true;
        dir = "";
        dis = 0;
        testIdx = 0;
        test = false;
        rndNumber = new ArrayList<>();
    }

    /**
     *
     */
    public void testMode() {
        test = !test;
    }

    /**
     *
     * @param num
     */
    public void addTestNumber(int... num) {
        for (int n : num) {
            rndNumber.add(n);
        }
    }

    /**
     *
     */
    public void move() {
        //true - head - up, false - tail - right
        currRound++;
        if (currRound > roundMax) {
            return;
        }
        boolean dir = random(0, 1) == 0;
        int dis = random(1, 6) + random(1, 6);
        this.dir = dir ? "up" : "right";
        this.dis = dis;

        if (dir) {
            rookPos[1] = modY(rookPos[1] + dis);
        } else {
            rookPos[0] = modX(rookPos[0] + dis);
        }

        if (board[bishopPos[1]][bishopPos[0]].checkPath(new int[]{bishopPos[1], bishopPos[0]}
                , new int[]{rookPos[1], rookPos[0]})) {
            state = false;
        }
    }

    //
    private int modX(int num) {
        return num % board[0].length;
    }

    //
    private int modY(int num) {
        return num % board.length;
    }

    //
    private int random(int min, int max) {
        if (test) {
            return rndNumber.get(testIdx++ % rndNumber.size());
        } else {
            return new Random().nextInt(max - min + 1) + min;
        }
    }

    /**
     *
     * @return
     */
    public boolean getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Game state: \n" +
                "round " + currRound + "\n" +
                "rook moves " + dir + " by distance of " + dis + "\n" +
                "rook's position is " + ((char) (rookPos[0] + 'a'))
                + (rookPos[1] + 1) % board.length + "\n" +
                (state ? (currRound > roundMax ? "rook wins" : "ongoing") : "bishop wins");
    }
}
