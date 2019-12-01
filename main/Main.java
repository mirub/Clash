/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package main;

import ground.BattleField;
import player.PlayerFactory;

public final class Main {
    private Main() { }

    public static void main(final String[] args) {
        ReadInput readInput = ReadInput.getInstance(args[0], args[1]);
        GameInput gameInput = readInput.load();
        PlayerFactory factory = PlayerFactory.getInstance();
        BattleField ground = BattleField.getInstance(gameInput.getGround());
        PlayGame play = PlayGame.getInstance();
        play.play(gameInput, ground, readInput, factory);
    }
}
