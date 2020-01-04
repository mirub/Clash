package angels;

import constants.Constants;
import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class DamageAngel extends Angel {
    public int currentX;
    public int currentY;
    public AngelType type;

    public DamageAngel(final AngelType type, final int x, final int y) {
        this.currentX = x;
        this.currentY = y;
        this.type = type;
    }

    @Override
    public int getCurrentX() {
        return currentX;
    }

    @Override
    public void setCurrentX(final int currentX) {
        this.currentX = currentX;
    }

    @Override
    public int getCurrentY() {
        return currentY;
    }

    @Override
    public void setCurrentY(final int currentY) {
        this.currentY = currentY;
    }

    @Override
    public AngelType getType() {
        return type;
    }

    @Override
    public void setType(final AngelType type) {
        this.type = type;
    }

    @Override
    public void affect(Pyromancer p, ReadInput readInput) {
        if (p.getStatus() == 1) {
            /* If the player is alive, change modifiers*/
            readInput.printHelp(this, p);
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
    public void affect(Wizard w, ReadInput readInput) {
        if (w.getStatus() == 1) {
            /* If the player is alive, change modifiers*/
            readInput.printHelp(this, w);
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
    public void affect(Knight k, ReadInput readInput)  {
        if (k.getStatus() == 1) {
            /* If the player is alive, change modifiers*/
            readInput.printHelp(this, k);
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
    public void affect(Rogue r, ReadInput readInput) {
        if (r.getStatus() == 1) {
            /* If the player is alive, change modifiers*/
            readInput.printHelp(this, r);
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
