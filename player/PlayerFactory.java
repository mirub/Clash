/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package player;

import ground.BattleField;

public final class PlayerFactory {
    private static PlayerFactory instance = null;

    private PlayerFactory() { }

    public static PlayerFactory getInstance() {
        if (instance == null) {
            instance = new PlayerFactory();
        }
        return instance;
    }

    public Player getPlayerType(final PlayerType type, final int id, final int initialHP,
                                final int bonusHpLevel, final BattleField g, final int x,
                                final int y, final char c) {
        switch (type) {
            case PYRO:
                return new Pyromancer(id, initialHP, bonusHpLevel, g, x, y, c);
            case WIZARD:
                return new Wizard(id, initialHP, bonusHpLevel, g, x, y, c);
            case ROGUE:
                return new Rogue(id, initialHP, bonusHpLevel, g, x, y, c);
            case KNIGHT:
                return new Knight(id, initialHP, bonusHpLevel, g, x, y, c);
            default:
                return null;
        }
    }
}
