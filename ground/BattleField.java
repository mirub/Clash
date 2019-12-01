/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package ground;

import java.util.List;

public final class BattleField {
    private final List<String> ground;
    private static BattleField instance = null;


    public static BattleField getInstance(final List<String> ground) {
        if (instance == null) {
            instance = new BattleField(ground);
        }
        return instance;
    }

    private BattleField(final List<String> ground) {
        this.ground = ground;
    }

    public List<String> getGround() {
        return ground;
    }
}
