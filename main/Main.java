package main;

import ground.BattleField;
import player.PlayerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        ReadInput readInput = new ReadInput(args[0], args[1]);
        Input gameInput = readInput.load();
        PlayerFactory players = PlayerFactory.getInstance();
        BattleField ground = BattleField.getInstance(gameInput.getGround());
        PlayGame play = PlayGame.getInstance();

        play.play(gameInput, ground, readInput);
    }
}
