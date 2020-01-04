package strategy;

import constants.Constants;
import player.*;

public class KnightProtectStrategy implements Strategy {
    @Override
    public void doOperation(Player k) {
        /* Changes the modifiers */
        k.setExecuteRoguePercent(k.getExecuteRoguePercent()
                - Constants.KNIGHT_PRT_COEF_SUB);
        k.setExecutePyroPercent(k.getExecutePyroPercent()
                - Constants.KNIGHT_PRT_COEF_SUB);
        k.setExecuteWizardPercent(k.getExecuteWizardPercent()
                - Constants.KNIGHT_PRT_COEF_SUB);
        k.setSlamRoguePercent(k.getSlamRoguePercent()
                - Constants.KNIGHT_PRT_COEF_SUB);
        k.setSlamKnightPercent(k.getSlamKnightPercent()
                - Constants.KNIGHT_PRT_COEF_SUB);
        k.setSlamPyroPercent(k.getSlamPyroPercent()
                - Constants.KNIGHT_PRT_COEF_SUB);
        k.setSlamWizardPercent(k.getSlamWizardPercent()
                - Constants.KNIGHT_PRT_COEF_SUB);
        /* Changes the hp */
        k.setHp(k.getHp() + (k.getHp() / Constants.KNIGHT_PRT_HP_RAISE));
    }
}
