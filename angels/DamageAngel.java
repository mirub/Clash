package angels;

import constants.Constants;
import magician.GreatMagician;
import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class DamageAngel extends Angel {
    private int currentX;
    private int currentY;
    private AngelType type;

    public DamageAngel(final AngelType type, final int x, final int y) {
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
    /* Sets the current Y*/
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
            /* If the player is alive, change modifiers*/
            /* Notice the magician*/
            greatMagician.setNotice(readInput.printHelp(this, p));
            p.setFireblastRoguePercent(p.getFireblastRoguePercent()
                    + Constants.PYRO_DA_RAISE);
            p.setFireblastKnightPercent(p.getFireblastKnightPercent()
                    + Constants.PYRO_DA_RAISE);
            p.setFireblastPyroPercent(p.getFireblastPyroPercent()
                    + Constants.PYRO_DA_RAISE);
            p.setFireblastWizardPercent(p.getFireblastWizardPercent()
                    + Constants.PYRO_DA_RAISE);
            p.setIgniteRoguePercent(p.getIgniteRoguePercent()
                    + Constants.PYRO_DA_RAISE);
            p.setIgniteKnightPercent(p.getIgniteKnightPercent()
                    + Constants.PYRO_DA_RAISE);
            p.setIgnitePyroPercent(p.getIgnitePyroPercent()
                    + Constants.PYRO_DA_RAISE);
            p.setIgniteWizardPercent(p.getIgniteWizardPercent()
                    + Constants.PYRO_DA_RAISE);
        }
    }

    @Override
    /* Affects the wizard */
    public void affect(final Wizard w, final ReadInput readInput,
                       final GreatMagician greatMagician) {
        if (w.getStatus() == 1) {
            /* If the player is alive, change modifiers*/
            /* Notice the magician */
            greatMagician.setNotice(readInput.printHelp(this, w));
            w.setDrainRoguePercent(w.getDrainRoguePercent()
                    + Constants.WIZARD_DA_RAISE);
            w.setDrainKnightPercent(w.getDrainKnightPercent()
                    + Constants.WIZARD_DA_RAISE);
            w.setDrainPyroPercent(w.getDrainPyroPercent()
                    + Constants.WIZARD_DA_RAISE);
            w.setDrainWizardPercent(w.getDrainWizardPercent()
                    + Constants.WIZARD_DA_RAISE);
            w.setDeflectRoguePercent(w.getDeflectRoguePercent()
                    + Constants.WIZARD_DA_RAISE);
            w.setDeflectKnightPercent(w.getDeflectKnightPercent()
                    + Constants.WIZARD_DA_RAISE);
            w.setDeflectPyroPercent(w.getDeflectPyroPercent()
                    + Constants.WIZARD_DA_RAISE);
        }
    }

    @Override
    /* Affects the knight */
    public void affect(final Knight k, final ReadInput readInput,
                       final GreatMagician greatMagician)  {
        if (k.getStatus() == 1) {
            /* If the player is alive, change modifiers*/
            /* Notice the magician */
            greatMagician.setNotice(readInput.printHelp(this, k));
            k.setExecuteRoguePercent(k.getExecuteRoguePercent()
                    + Constants.KNIGHT_DA_RAISE);
            k.setExecutePyroPercent(k.getExecutePyroPercent()
                    + Constants.KNIGHT_DA_RAISE);
            k.setExecuteWizardPercent(k.getExecuteWizardPercent()
                    + Constants.KNIGHT_DA_RAISE);
            k.setSlamRoguePercent(k.getSlamRoguePercent()
                    + Constants.KNIGHT_DA_RAISE);
            k.setSlamKnightPercent(k.getSlamKnightPercent()
                    + Constants.KNIGHT_DA_RAISE);
            k.setSlamPyroPercent(k.getSlamPyroPercent()
                    + Constants.KNIGHT_DA_RAISE);
            k.setSlamWizardPercent(k.getSlamWizardPercent()
                    + Constants.KNIGHT_DA_RAISE);
        }
    }

    @Override
    /* Affects the rogue */
    public void affect(final Rogue r, final ReadInput readInput,
                       final GreatMagician greatMagician) {
        if (r.getStatus() == 1) {
            /* If the player is alive, change modifiers*/
            /* Notice the magician */
            greatMagician.setNotice(readInput.printHelp(this, r));
            r.setBackstabRoguePercent(r.getBackstabRoguePercent()
                    + Constants.ROGUE_DA_RAISE);
            r.setBackstabKnightPercent(r.getBackstabKnightPercent()
                    + Constants.ROGUE_DA_RAISE);
            r.setBackstabPyroPercent(r.getBackstabPyroPercent()
                    + Constants.ROGUE_DA_RAISE);
            r.setBackstabWizardPercent(r.getBackstabWizardPercent()
                    + Constants.ROGUE_DA_RAISE);
            r.setParalysisRoguePercent(r.getParalysisRoguePercent()
                    + Constants.ROGUE_DA_RAISE);
            r.setParalysisKnightPercent(r.getParalysisKnightPercent()
                    + Constants.ROGUE_DA_RAISE);
            r.setParalysisPyroPercent(r.getParalysisPyroPercent()
                    + Constants.ROGUE_DA_RAISE);
            r.setParalysisWizardPercent(r.getParalysisWizardPercent()
                    + Constants.ROGUE_DA_RAISE);
        }
    }
}
