package angels;

/* The Angel Factory Class */
public final class AngelFactory {
    private static AngelFactory instance = null;

    private AngelFactory() { }

    public static AngelFactory getInstance() {
        if (instance == null) {
            instance = new AngelFactory();
        }
        return instance;
    }

    public Angel getAngelType(final AngelType type, final int x, final int y) {
        switch (type) {
            case DAMAGE:
                return new DamageAngel(type, x, y);
            case DARK:
                return new DarkAngel(type, x, y);
            case DRACULA:
                return new Dracula(type, x, y);
            case GOODBOY:
                return new GoodBoy(type, x, y);
            case LEVEL:
                return new LevelUpAngel(type, x, y);
            case LIFE:
                return new LifeGiver(type, x, y);
            case SMALL:
                return new SmallAngel(type, x, y);
            case SPAWN:
                return new Spawner(type, x, y);
            case DOOM:
                return new TheDoomer(type, x, y);
            case XP:
                return new XPAngel(type, x, y);
            default:
                return null;
        }
    }
}
