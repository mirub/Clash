package main;

import fileio.FileSystem;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

public class ReadInput {
    private static String inputFile;
    private static String outputFile;

    public ReadInput(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public static Input load() {
        int n = 0;
        int m = 0;
        List<String> ground = new ArrayList<String>();
        int p = 0;
        List<String> players = new ArrayList<String>();
        int r = 0;
        List<String> roundMoves = new ArrayList<String>();
        try {
            FileSystem fs = new FileSystem(inputFile, outputFile);

            n = fs.nextInt();
            m = fs.nextInt();

            for (int i = 0; i < n; ++i) {
                ground.add(fs.nextWord());
            }

            p = fs.nextInt();

            for (int i = 0; i < p; ++i) {
                String currentPlayer = "";
                for (int j = 0; j < 3; ++j) {
                    currentPlayer += fs.nextWord();
                }
                players.add(currentPlayer);
            }

            r = fs.nextInt();

            for (int i = 0; i < r ; ++i) {
                roundMoves.add(fs.nextWord());
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new Input(n, m, ground, p, players, r, roundMoves);
    }
}
