package Chess;

public class bishop implements chess {

    @Override
    public boolean checkPath(int[] myPos, int[] otherPos) {
        return Math.abs(myPos[0] - otherPos[0])
                == Math.abs(myPos[1] - otherPos[1]);
    }
}
