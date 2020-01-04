/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package main;

import angels.AngelFactory;
import ground.BattleField;
import magician.GreatMagician;
import player.Player;
import player.PlayerFactory;

import java.util.ArrayList;

public final class Main {
    private Main() { }

    public static void main(final String[] args) {
        ReadInput readInput = ReadInput.getInstance(args[0], args[1]);
        GameInput gameInput = readInput.load();
        GreatMagician greatMagician = GreatMagician.getInstance();
        PlayerFactory factory = PlayerFactory.getInstance();
        AngelFactory angelFactory = AngelFactory.getInstance();
        BattleField ground = BattleField.getInstance(gameInput.getGround());
        PlayGame play = PlayGame.getInstance();
        ArrayList<Player> players = play.play(gameInput, ground, readInput, factory,
                angelFactory, greatMagician);
        readInput.printOutput(players);
    }
}
