/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package main;

import java.util.ArrayList;
import java.util.List;

public final class GameInput {
    private int n, m; // sizes of the battleground
    private List<String> ground = new ArrayList<String>(n);
    private int p; // number of players
    private List<String> players = new ArrayList<String>(p);
    private ArrayList<ArrayList<Integer>> positions = new ArrayList<ArrayList<Integer>>(p);
    private int r; // rounds number
    private List<String> roundMoves = new ArrayList<String>(r);
    private List<Integer> angelsPerRound = new ArrayList<Integer>(r);
    private int a; // number of angels
    private List<String> angels = new ArrayList<String>(a);

    public GameInput() {
        this.ground = null;
        this.players = null;
        this.roundMoves = null;
        this.n = 0;
        this.m = 0;
        this.p = 0;
        this.r = 0;
        this.angelsPerRound = null;
        this.a = 0;
        this.angels = null;
    }

    public GameInput(final int n, final int m, final List<String> ground, final int p,
                     final List<String> players, final ArrayList<ArrayList<Integer>> positions,
                     final int r, final List<String> roundMoves, final List<Integer>
                     angelsPerRound, final int a, final List<String> angels) {
        this.ground = ground;
        this.players = players;
        this.positions = positions;
        this.roundMoves = roundMoves;
        this.angelsPerRound = angelsPerRound;
        this.angels = angels;
        this.a = a;
        this.n = n;
        this.m = m;
        this.p = p;
        this.r = r;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public List<String> getGround() {
        return ground;
    }

    public int getP() {
        return p;
    }

    public List<String> getPlayers() {
        return players;
    }

    public ArrayList<ArrayList<Integer>> getPositions() {
        return positions;
    }

    public void setPositions(final ArrayList<ArrayList<Integer>> positions) {
        this.positions = positions;
    }

    public int getR() {
        return r;
    }

    public List<String> getRoundMoves() {
        return roundMoves;
    }

    public List<Integer> getAngelsPerRound() {
        return angelsPerRound;
    }

    public int getA() {
        return a;
    }

    public List<String> getAngels() {
        return angels;
    }

    public boolean isValidInput() {
        boolean size = n != 0 && m != 0;
        boolean groundNotEmpty = ground.size() > 0;
        boolean play = p != 0;
        boolean playersNotEmpty = players.size() > 0;
        boolean positionsNotEmpty = positions.size() > 0;
        boolean rounds = r != 0;
        boolean roundsNotEmpty = roundMoves.size() > 0;
        boolean angelNumberNotEmpty = angelsPerRound.size() > 0;
        boolean areAngels = a != 0;
        boolean angelsNotEmpty = angels.size() > 0;
        return size && groundNotEmpty && play && playersNotEmpty
                && rounds && roundsNotEmpty && positionsNotEmpty
                && angelNumberNotEmpty && areAngels && angelsNotEmpty;
    }
}
