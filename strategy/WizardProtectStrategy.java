package strategy;

import constants.Constants;
import player.Player;

public class WizardProtectStrategy implements Strategy {
    @Override
    /* Protect strategy for wizard */
    public void doOperation(final Player w) {
        /* Change the modifiers */
        w.setDrainRoguePercent(w.getDrainRoguePercent()
                - Constants.WIZARD_PRT_COEF_SUB);
        w.setDrainKnightPercent(w.getDrainKnightPercent()
                - Constants.WIZARD_PRT_COEF_SUB);
        w.setDrainPyroPercent(w.getDrainPyroPercent()
                - Constants.WIZARD_PRT_COEF_SUB);
        w.setDrainWizardPercent(w.getDrainWizardPercent()
                - Constants.WIZARD_PRT_COEF_SUB);
        w.setDeflectRoguePercent(w.getDeflectRoguePercent()
                - Constants.WIZARD_PRT_COEF_SUB);
        w.setDeflectKnightPercent(w.getDeflectKnightPercent()
                - Constants.WIZARD_PRT_COEF_SUB);
        w.setDeflectPyroPercent(w.getDeflectPyroPercent()
                - Constants.WIZARD_PRT_COEF_SUB);
        /* Change the hp */
        w.setHp(w.getHp() + (w.getHp() / Constants.WIZARD_PRT_HP_RAISE));
    }
}
