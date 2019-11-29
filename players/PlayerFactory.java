package player;

import ground.BattleField;

public class PlayerFactory {
    private static PlayerFactory instance = null;

    private PlayerFactory() {}

    public static PlayerFactory getInstance() {
        if (instance == null) {
            instance = new PlayerFactory();
        }
        return instance;
    }

    public Player getPlayerType (PlayerType type, int id, int initialHP, int bonusHpLevel,
                                 BattleField g, int x, int y, char c) {
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
