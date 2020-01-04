package strategy;

import constants.Constants;
import player.Player;

public class WizardDamageStrategy implements Strategy {
    @Override
    /* Damage strategy for wizard */
    public void doOperation(final Player w) {
        /* Change the modifiers */
        w.setDrainRoguePercent(w.getDrainRoguePercent()
                + Constants.WIZARD_DMG_COEF_RAISE);
        w.setDrainKnightPercent(w.getDrainKnightPercent()
                + Constants.WIZARD_DMG_COEF_RAISE);
        w.setDrainPyroPercent(w.getDrainPyroPercent()
                + Constants.WIZARD_DMG_COEF_RAISE);
        w.setDrainWizardPercent(w.getDrainWizardPercent()
                + Constants.WIZARD_DMG_COEF_RAISE);
        w.setDeflectRoguePercent(w.getDeflectRoguePercent()
                + Constants.WIZARD_DMG_COEF_RAISE);
        w.setDeflectKnightPercent(w.getDeflectKnightPercent()
                + Constants.WIZARD_DMG_COEF_RAISE);
        w.setDeflectPyroPercent(w.getDeflectPyroPercent()
                + Constants.WIZARD_DMG_COEF_RAISE);
        /* Change the hp */
        w.setHp(w.getHp() - (w.getHp() / Constants.WIZARD_DMG_HP_SUB));
    }
}
