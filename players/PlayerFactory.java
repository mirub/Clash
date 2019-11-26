package player;

public class PlayerFactory {
    private static PlayerFactory instance = null;

    private PlayerFactory() {}

    public static PlayerFactory getInstance() {
        if (instance == null) {
            instance = new PlayerFactory();
        }
        return instance;
    }

    public Player getPlayerType (PlayerType type) {
        switch (type) {
            case PYRO:
                return new Pyromancer();
            case WIZARD:
                return new Wizard();
            case ROGUE:
                return new Rogue();
            case KNIGHT:
                return new Knight();
            default:
                return null;
        }
    }
}
