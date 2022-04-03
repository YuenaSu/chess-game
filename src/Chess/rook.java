package Chess;

/**
 * rook can only move vertically and horizontally
 */
public class rook implements chess {

    @Override
    public boolean checkPath(int[] myPos, int[] otherPos) {
        return myPos[0] == otherPos[0] || myPos[1] == otherPos[1];
    }
}
