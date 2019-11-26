package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Input {
    private int n, m; // sizes of the battleground
    private List<String> ground = new ArrayList<String>(n);
    private  int p; // number of players
    private List<String> players = new ArrayList<String>(p);
    private int r; // rounds number
    private List<String> roundMoves = new ArrayList<String>(r);

    public Input () {
        this.ground = null;
        this.players = null;
        this.roundMoves = null;
        this.n = 0;
        this.m = 0;
        this.p = 0;
        this.r = 0;
    }

    public Input (int n, int m, List<String> ground, int p, List<String> players,
                  int r, List<String> roundMoves) {
        this.ground = ground;
        this.players = players;
        this.roundMoves = roundMoves;
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

    public int getR() {
        return r;
    }

    public List<String> getRoundMoves() {
        return roundMoves;
    }

    public final boolean isValidInput() {
        boolean size = n != 0 && m != 0;
        boolean groundNotEmpty = ground.size() > 0;
        boolean play = p != 0;
        boolean playersNotEmpty = players.size() > 0;
        boolean rounds = r != 0;
        boolean roundsNotEmpty = roundMoves.size() > 0;
        return size && groundNotEmpty && play && playersNotEmpty &&
                rounds && roundsNotEmpty;
    }
}
