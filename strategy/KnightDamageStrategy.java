package strategy;

import constants.Constants;
import player.Player;

public class KnightDamageStrategy implements Strategy {
    @Override
    /* Damage strategy for knight */
    public void doOperation(final Player k) {
        /* Changes the modifiers */
        k.setExecuteRoguePercent(k.getExecuteRoguePercent()
                + Constants.KNIGHT_DMG_COEF_RAISE);
        k.setExecutePyroPercent(k.getExecutePyroPercent()
                + Constants.KNIGHT_DMG_COEF_RAISE);
        k.setExecuteWizardPercent(k.getExecuteWizardPercent()
                + Constants.KNIGHT_DMG_COEF_RAISE);
        k.setSlamRoguePercent(k.getSlamRoguePercent()
                + Constants.KNIGHT_DMG_COEF_RAISE);
        k.setSlamKnightPercent(k.getSlamKnightPercent()
                + Constants.KNIGHT_DMG_COEF_RAISE);
        k.setSlamPyroPercent(k.getSlamPyroPercent()
                + Constants.KNIGHT_DMG_COEF_RAISE);
        k.setSlamWizardPercent(k.getSlamWizardPercent()
                + Constants.KNIGHT_DMG_COEF_RAISE);
        /* Changes the hp */
        k.setHp(k.getHp() - (k.getHp() / Constants.KNIGHT_DMG_HP_SUB));
    }
}
