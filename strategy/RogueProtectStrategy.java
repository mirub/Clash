package strategy;

import constants.Constants;
import player.*;

public class RogueProtectStrategy implements Strategy {
    @Override
    public void doOperation(Player r) {
        /* Change the modifiers */
        r.setBackstabRoguePercent(r.getBackstabRoguePercent()
                - Constants.ROGUE_PRT_COEF_SUB);
        r.setBackstabKnightPercent(r.getBackstabKnightPercent()
                - Constants.ROGUE_PRT_COEF_SUB);
        r.setBackstabPyroPercent(r.getBackstabPyroPercent()
                - Constants.ROGUE_PRT_COEF_SUB);
        r.setBackstabWizardPercent(r.getBackstabWizardPercent()
                - Constants.ROGUE_PRT_COEF_SUB);
        r.setParalysisRoguePercent(r.getParalysisRoguePercent()
                - Constants.ROGUE_PRT_COEF_SUB);
        r.setParalysisKnightPercent(r.getParalysisKnightPercent()
                - Constants.ROGUE_PRT_COEF_SUB);
        r.setParalysisPyroPercent(r.getParalysisPyroPercent()
                - Constants.ROGUE_PRT_COEF_SUB);
        r.setParalysisWizardPercent(r.getParalysisWizardPercent()
                - Constants.ROGUE_PRT_COEF_SUB);
        /* Change the hp */
        r.setHp(r.getHp() + (r.getHp() / Constants.ROGUE_PRT_HP_RAISE));
    }
}
