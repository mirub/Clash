package angels;

import constants.Constants;
import magician.GreatMagician;
import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Dracula extends Angel {
    private int currentX;
    private int currentY;
    private AngelType type;

    public Dracula(final AngelType type, final int x, final int y) {
        this.currentX = x;
        this.currentY = y;
        this.type = type;
    }

    @Override
    /* Gets the current X */
    public int getCurrentX() {
        return currentX;
    }

    @Override
    /* Sets the current X */
    public void setCurrentX(final int currentX) {
        this.currentX = currentX;
    }

    @Override
    /* Gets the current Y */
    public int getCurrentY() {
        return currentY;
    }

    @Override
    /* Sets the current Y */
    public void setCurrentY(final int currentY) {
        this.currentY = currentY;
    }

    @Override
    /* Gets the type */
    public AngelType getType() {
        return type;
    }

    @Override
    /* Sets the type */
    public void setType(final AngelType type) {
        this.type = type;
    }

    @Override
    /* Affects the pyromancer */
    public void affect(final Pyromancer p, final ReadInput readInput,
                       final GreatMagician greatMagician) {
        if (p.getStatus() == 1) {
            /* If the player is alive, substract hp */
            greatMagician.setNotice(readInput.printHit(this, p));
            p.setHp(p.getHp() - Constants.PYRO_DRACULA_HP_SUB);
            if (p.getHp() <= 0) {
                greatMagician.setNotice(readInput.killedByAngel(p));
                p.setStatus(0);
            }
            /* If the player is alive, change modifiers */
            p.setFireblastRoguePercent(p.getFireblastRoguePercent()
                    - Constants.PYRO_DRACULA_SUB);
            p.setFireblastKnightPercent(p.getFireblastKnightPercent()
                    - Constants.PYRO_DRACULA_SUB);
            p.setFireblastPyroPercent(p.getFireblastPyroPercent()
                    - Constants.PYRO_DRACULA_SUB);
            p.setFireblastWizardPercent(p.getFireblastWizardPercent()
                    - Constants.PYRO_DRACULA_SUB);
            p.setIgniteRoguePercent(p.getIgniteRoguePercent()
                    - Constants.PYRO_DRACULA_SUB);
            p.setIgniteKnightPercent(p.getIgniteKnightPercent()
                    - Constants.PYRO_DRACULA_SUB);
            p.setIgnitePyroPercent(p.getIgnitePyroPercent()
                    - Constants.PYRO_DRACULA_SUB);
            p.setIgniteWizardPercent(p.getIgniteWizardPercent()
                    - Constants.PYRO_DRACULA_SUB);

        }
    }

    @Override
    /* Affects the wizard */
    public void affect(final Wizard w, final ReadInput readInput,
                       final GreatMagician greatMagician) {
        if (w.getStatus() == 1) {
            /* If the player is alive, substract hp */
            greatMagician.setNotice(readInput.printHit(this, w));
            w.setHp(w.getHp() - Constants.WIZARD_DRACULA_HP_SUB);
            if (w.getHp() <= 0) {
                w.setStatus(0);
                greatMagician.setNotice(readInput.killedByAngel(w));
            }
            /* If the player is alive, change modifiers */
            w.setDrainRoguePercent(w.getDrainRoguePercent()
                    - Constants.WIZARD_DRACULA_SUB);
            w.setDrainKnightPercent(w.getDrainKnightPercent()
                    - Constants.WIZARD_DRACULA_SUB);
            w.setDrainPyroPercent(w.getDrainPyroPercent()
                    - Constants.WIZARD_DRACULA_SUB);
            w.setDrainWizardPercent(w.getDrainWizardPercent()
                    - Constants.WIZARD_DRACULA_SUB);
            w.setDeflectRoguePercent(w.getDeflectRoguePercent()
                    - Constants.WIZARD_DRACULA_SUB);
            w.setDeflectKnightPercent(w.getDeflectKnightPercent()
                    - Constants.WIZARD_DRACULA_SUB);
            w.setDeflectPyroPercent(w.getDeflectPyroPercent()
                    - Constants.WIZARD_DRACULA_SUB);
        }
    }

    @Override
    /* Affects the knight */
    public void affect(final Knight k, final ReadInput readInput,
                       final GreatMagician greatMagician)  {
        if (k.getStatus() == 1) {
            /* If the player is alive, substract hp */
            greatMagician.setNotice(readInput.printHit(this, k));
            k.setHp(k.getHp() - Constants.KNIGHT_DRACULA_HP_SUB);
            if (k.getHp() <= 0) {
                k.setStatus(0);
                greatMagician.setNotice(readInput.killedByAngel(k));
            }
            /* If the player is alive, change modifiers */
            k.setExecuteRoguePercent(k.getExecuteRoguePercent()
                    - Constants.KNIGHT_DRACULA_SUB);
            k.setExecutePyroPercent(k.getExecutePyroPercent()
                    - Constants.KNIGHT_DRACULA_SUB);
            k.setExecuteWizardPercent(k.getExecuteWizardPercent()
                    - Constants.KNIGHT_DRACULA_SUB);
            k.setSlamRoguePercent(k.getSlamRoguePercent()
                    - Constants.KNIGHT_DRACULA_SUB);
            k.setSlamKnightPercent(k.getSlamKnightPercent()
                    - Constants.KNIGHT_DRACULA_SUB);
            k.setSlamPyroPercent(k.getSlamPyroPercent()
                    - Constants.KNIGHT_DRACULA_SUB);
            k.setSlamWizardPercent(k.getSlamWizardPercent()
                    - Constants.KNIGHT_DRACULA_SUB);
        }
    }

    @Override
    /* Affects the rogue */
    public void affect(final Rogue r, final ReadInput readInput,
                       final GreatMagician greatMagician) {
        if (r.getStatus() == 1) {
            /* If the player is alive, substract hp */
            greatMagician.setNotice(readInput.printHit(this, r));
            r.setHp(r.getHp() - Constants.ROGUE_DRACULA_HP_SUB);
            if (r.getHp() <= 0) {
                greatMagician.setNotice(readInput.killedByAngel(r));
                r.setStatus(0);
            }
            /* If the player is alive, change modifiers */
            r.setBackstabRoguePercent(r.getBackstabRoguePercent()
                    - Constants.ROGUE_DRACULA_SUB);
            r.setBackstabKnightPercent(r.getBackstabKnightPercent()
                    - Constants.ROGUE_DRACULA_SUB);
            r.setBackstabPyroPercent(r.getBackstabPyroPercent()
                    - Constants.ROGUE_DRACULA_SUB);
            r.setBackstabWizardPercent(r.getBackstabWizardPercent()
                    - Constants.ROGUE_DRACULA_SUB);
            r.setParalysisRoguePercent(r.getParalysisRoguePercent()
                    - Constants.ROGUE_DRACULA_SUB);
            r.setParalysisKnightPercent(r.getParalysisKnightPercent()
                    - Constants.ROGUE_DRACULA_SUB);
            r.setParalysisPyroPercent(r.getParalysisPyroPercent()
                    - Constants.ROGUE_DRACULA_SUB);
            r.setParalysisWizardPercent(r.getParalysisWizardPercent()
                    - Constants.ROGUE_DRACULA_SUB);
        }
    }
}
