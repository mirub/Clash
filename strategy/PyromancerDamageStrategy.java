package strategy;

import constants.Constants;
import player.*;

public class PyromancerDamageStrategy implements Strategy {
    @Override
    public void doOperation(Player p) {
        /* Changes the modifiers */
        p.setFireblastRoguePercent(p.getFireblastRoguePercent()
                + Constants.PYRO_DMG_COEF_RAISE);
        p.setFireblastKnightPercent(p.getFireblastKnightPercent()
                + Constants.PYRO_DMG_COEF_RAISE);
        p.setFireblastPyroPercent(p.getFireblastPyroPercent()
                + Constants.PYRO_DMG_COEF_RAISE);
        p.setFireblastWizardPercent(p.getFireblastWizardPercent()
                + Constants.PYRO_DMG_COEF_RAISE);
        p.setIgniteRoguePercent(p.getIgniteRoguePercent()
                + Constants.PYRO_DMG_COEF_RAISE);
        p.setIgniteKnightPercent(p.getIgniteKnightPercent()
                + Constants.PYRO_DMG_COEF_RAISE);
        p.setIgnitePyroPercent(p.getIgnitePyroPercent()
                + Constants.PYRO_DMG_COEF_RAISE);
        p.setIgniteWizardPercent(p.getIgniteWizardPercent()
                + Constants.PYRO_DMG_COEF_RAISE);
        /* Changes the hp */
        p.setHp(p.getHp() - (p.getHp() / Constants.PYRO_DMG_HP_SUB));
    }
}
