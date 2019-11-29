package ground;

import java.util.List;

public class BattleField {
    private List<String> ground;
    private static BattleField instance = null;


    public static BattleField getInstance(List<String> ground) {
        if (instance == null) {
            instance = new BattleField(ground);
        }
        return instance;
    }

    private BattleField(List<String> ground) {
        this.ground = ground;
    }

    public List<String> getGround() {
        return ground;
    }
}
