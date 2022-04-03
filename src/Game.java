import Chess.chess;
import Chess.bishop;
import Chess.rook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private final chess[][] board;
    protected final int[] rookPos;
    private final int[] bishopPos;
    private boolean state; //if the game ongoing
    private String dir; //direction for this round
    private int dis; //distance for this round

    //rounds
    private final int roundMax;
    private int currRound; //which round now

    /**
     * game constructor
     * @param row is the number of rows in the game
     * @param col is the number of columns in the game
     * @param bishopPos initial position of bishop [x,y]
     * @param rookPos initial position of rook [x,y]
     * @param round the maximum rounds, in this case, if rook survives, it wins
     */
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
    }


    public void move() {
        //true - head - up, false - tail - right
        currRound++;
        if (currRound > roundMax) {
            state = false;
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

    //get a random number inclusively
    protected int random(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    /**
     * get the current state of the game
     * @return true if rook wins, false if bishop wins
     */
    public boolean getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Game state: \n" +
                "round " + currRound + "\n" +
                "rook moves " + dir + " by distance of " + dis + "\n" +
                "rook is at " + ((char) (rookPos[0] + 'a'))
                + (rookPos[1] + 1) + "\n" +
                (state ? "ongoing" : (currRound > roundMax ? "rook wins" : "bishop wins"));
    }
}
