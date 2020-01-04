package strategy;

import constants.Constants;
import player.Player;

public class PyromancerProtectStrategy implements Strategy {
    @Override
    /* Protect strategy for pyromancer */
    public void doOperation(final Player p) {
        /* Changes the modifiers*/
        p.setFireblastRoguePercent(p.getFireblastRoguePercent()
                - Constants.PYRO_PRT_COEF_SUB);
        p.setFireblastKnightPercent(p.getFireblastKnightPercent()
                - Constants.PYRO_PRT_COEF_SUB);
        p.setFireblastPyroPercent(p.getFireblastPyroPercent()
                - Constants.PYRO_PRT_COEF_SUB);
        p.setFireblastWizardPercent(p.getFireblastWizardPercent()
                - Constants.PYRO_PRT_COEF_SUB);
        p.setIgniteRoguePercent(p.getIgniteRoguePercent()
                - Constants.PYRO_PRT_COEF_SUB);
        p.setIgniteKnightPercent(p.getIgniteKnightPercent()
                - Constants.PYRO_PRT_COEF_SUB);
        p.setIgnitePyroPercent(p.getIgnitePyroPercent()
                - Constants.PYRO_PRT_COEF_SUB);
        p.setIgniteWizardPercent(p.getIgniteWizardPercent()
                - Constants.PYRO_PRT_COEF_SUB);
        /* Changes the hp */
        p.setHp(p.getHp() + (p.getHp() / Constants.PYRO_PRT_HP_RAISE));
    }
}
