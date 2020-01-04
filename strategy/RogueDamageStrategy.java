package strategy;

import constants.Constants;
import player.Player;

public class RogueDamageStrategy implements Strategy {
    @Override
    /* Damage strategy for rogue */
    public void doOperation(final Player r) {
        /* Changes the modifiers */
        r.setBackstabRoguePercent(r.getBackstabRoguePercent()
                + Constants.ROGUE_DMG_COEF_RAISE);
        r.setBackstabKnightPercent(r.getBackstabKnightPercent()
                + Constants.ROGUE_DMG_COEF_RAISE);
        r.setBackstabPyroPercent(r.getBackstabPyroPercent()
                + Constants.ROGUE_DMG_COEF_RAISE);
        r.setBackstabWizardPercent(r.getBackstabWizardPercent()
                + Constants.ROGUE_DMG_COEF_RAISE);
        r.setParalysisRoguePercent(r.getParalysisRoguePercent()
                + Constants.ROGUE_DMG_COEF_RAISE);
        r.setParalysisKnightPercent(r.getParalysisKnightPercent()
                + Constants.ROGUE_DMG_COEF_RAISE);
        r.setParalysisPyroPercent(r.getParalysisPyroPercent()
                + Constants.ROGUE_DMG_COEF_RAISE);
        r.setParalysisWizardPercent(r.getParalysisWizardPercent()
                + Constants.ROGUE_DMG_COEF_RAISE);
        /* Changes the hp */
        r.setHp(r.getHp() - (r.getHp() / Constants.ROGUE_DMG_HP_SUB));
    }
}
