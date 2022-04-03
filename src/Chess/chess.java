package Chess;

public interface chess {

    /**
     * check if the other position is on the current chess's moving path
     * @param myPos refers to the position of the current chess
     * @param otherPos refers to another position
     * @return true if the other position is on the current chess's moving path
     *         , vice versa.
     */
    boolean checkPath(int[] myPos, int[] otherPos);
}
