/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package main;

import fileio.FileSystem;
import player.Player;
import java.util.ArrayList;
import java.util.List;

public final class ReadInput {
    private static String inFile;
    private static String outFile;
    private static ReadInput instance = null;


    public static ReadInput getInstance(final String inputFile,
                                        final String outputFile) {
        if (instance == null) {
            instance = new ReadInput(inputFile, outputFile);
        }
        return instance;
    }


    private ReadInput(final String inputFile, final String outputFile) {
        this.inFile = inputFile;
        this.outFile = outputFile;
    }

    /* Returns a variable of type Input upon reading from a file */
    public static GameInput load() {
        int n = 0;
        int m = 0;
        List<String> ground = new ArrayList<String>();
        int p = 0;
        List<String> players = new ArrayList<String>();
        ArrayList<ArrayList<Integer>> positions = new ArrayList<ArrayList<Integer>>();
        int r = 0;
        List<String> roundMoves = new ArrayList<String>();
        try {
            FileSystem fs = new FileSystem(inFile, outFile);

            n = fs.nextInt();
            m = fs.nextInt();

            for (int i = 0; i < n; ++i) {
                ground.add(fs.nextWord());
            }

            p = fs.nextInt();

            for (int i = 0; i < p; ++i) {
                ArrayList<Integer> currentPosition = new ArrayList<Integer>(2);
                players.add(fs.nextWord());
                currentPosition.add(fs.nextInt());
                currentPosition.add(fs.nextInt());
                positions.add(currentPosition);
            }

            r = fs.nextInt();

            for (int i = 0; i < r; ++i) {
                roundMoves.add(fs.nextWord());
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(n, m, ground, p, players, positions, r, roundMoves);
    }

    /* Writes the result to a file */
    public static void writeResult(final ArrayList<Player> gamePlayers) {
        try {
            FileSystem fs = new FileSystem(inFile, outFile);

            for (int i = 0; i < gamePlayers.size(); ++i) {
                Player p = gamePlayers.get(i);
                if (p.getStatus() == 1) {
                    fs.writeCharacter(p.getType());
                    fs.writeCharacter(' ');
                    fs.writeInt(p.getLevel());
                    fs.writeCharacter(' ');
                    fs.writeInt(p.getXp());
                    fs.writeCharacter(' ');
                    fs.writeInt(p.getHp());
                    fs.writeCharacter(' ');
                    fs.writeInt(p.getCurrentX());
                    fs.writeCharacter(' ');
                    fs.writeInt(p.getCurrentY());
                    fs.writeNewLine();
                } else {
                    fs.writeCharacter(p.getType());
                    fs.writeCharacter(' ');
                    fs.writeWord("dead");
                    fs.writeNewLine();
                }
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
