package angels;

import constants.Constants;
import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class SmallAngel extends Angel{
    public int currentX;
    public int currentY;
    public AngelType type;

    public SmallAngel(final AngelType type, final int x, final int y) {
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
            /* If the player is alive, add hp */
            readInput.printHelp(this, p);
            p.setHp(p.getHp() + Constants.PYRO_SA_HP_RAISE);
            if (p.getHp() > p.getMaxHp()) {
                p.setHp(p.getMaxHp());
            }
            /* If the player is alive, change modifiers */
            p.setFireblastRoguePercent(p.getFireblastRoguePercent()
                    + Constants.PYRO_SA_RAISE);
            p.setFireblastKnightPercent(p.getFireblastKnightPercent()
                    + Constants.PYRO_SA_RAISE);
            p.setFireblastPyroPercent(p.getFireblastPyroPercent()
                    + Constants.PYRO_SA_RAISE);
            p.setFireblastWizardPercent(p.getFireblastWizardPercent()
                    + Constants.PYRO_SA_RAISE);
            p.setIgniteRoguePercent(p.getIgniteRoguePercent()
                    + Constants.PYRO_SA_RAISE);
            p.setIgniteKnightPercent(p.getIgniteKnightPercent()
                    + Constants.PYRO_SA_RAISE);
            p.setIgnitePyroPercent(p.getIgnitePyroPercent()
                    + Constants.PYRO_SA_RAISE);
            p.setIgniteWizardPercent(p.getIgniteWizardPercent()
                    + Constants.PYRO_SA_RAISE);
        }
    }

    @Override
    public void affect(Wizard w, ReadInput readInput) {
        if (w.getStatus() == 1) {
            /* If the player is alive, add hp */
            readInput.printHelp(this, w);
            w.setHp(w.getHp() + Constants.WIZARD_SA_HP_RAISE);
            if (w.getHp() > w.getMaxHp()) {
                w.setHp(w.getMaxHp());
            }
            /* If the player is alive, change modifiers */
            w.setDrainRoguePercent(w.getDrainRoguePercent()
                    + Constants.WIZARD_SA_RAISE);
            w.setDrainKnightPercent(w.getDrainKnightPercent()
                    + Constants.WIZARD_SA_RAISE);
            w.setDrainPyroPercent(w.getDrainPyroPercent()
                    + Constants.WIZARD_SA_RAISE);
            w.setDrainWizardPercent(w.getDrainWizardPercent()
                    + Constants.WIZARD_SA_RAISE);
            w.setDeflectRoguePercent(w.getDeflectRoguePercent()
                    + Constants.WIZARD_SA_RAISE);
            w.setDeflectKnightPercent(w.getDeflectKnightPercent()
                    + Constants.WIZARD_SA_RAISE);
            w.setDeflectPyroPercent(w.getDeflectPyroPercent()
                    + Constants.WIZARD_SA_RAISE);
            w.setDeflectWizardPercent(w.getDeflectWizardPercent()
                    + Constants.WIZARD_SA_RAISE);
        }
    }

    @Override
    public void affect(Knight k, ReadInput readInput)  {
        if (k.getStatus() == 1) {
            /* If the player is alive, add hp */
            readInput.printHelp(this, k);
            k.setHp(k.getHp() + Constants.KNIGHT_SA_HP_RAISE);
            if (k.getHp() > k.getMaxHp()) {
                k.setHp(k.getMaxHp());
            }
            /* If the player is alive, change modifiers */
            k.setExecuteRoguePercent(k.getExecuteRoguePercent()
                    + Constants.KNIGHT_SA_RAISE);
            k.setExecutePyroPercent(k.getExecutePyroPercent()
                    + Constants.KNIGHT_SA_RAISE);
            k.setExecuteWizardPercent(k.getExecuteWizardPercent()
                    + Constants.KNIGHT_SA_RAISE);
            k.setSlamRoguePercent(k.getSlamRoguePercent()
                    + Constants.KNIGHT_SA_RAISE);
            k.setSlamKnightPercent(k.getSlamKnightPercent()
                    + Constants.KNIGHT_SA_RAISE);
            k.setSlamPyroPercent(k.getSlamPyroPercent()
                    + Constants.KNIGHT_SA_RAISE);
            k.setSlamWizardPercent(k.getSlamWizardPercent()
                    + Constants.KNIGHT_SA_RAISE);
        }
    }

    @Override
    public void affect(Rogue r, ReadInput readInput) {
        if (r.getStatus() == 1) {
            /* If the player is alive, add hp */
            readInput.printHelp(this, r);
            r.setHp(r.getHp() + Constants.ROGUE_SA_HP_RAISE);
            if (r.getHp() > r.getMaxHp()) {
                r.setHp(r.getMaxHp());
            }
            /* If the player is alive, change modifiers */
            r.setBackstabRoguePercent(r.getBackstabRoguePercent()
                    + Constants.ROGUE_SA_RAISE);
            r.setBackstabKnightPercent(r.getBackstabKnightPercent()
                    + Constants.ROGUE_SA_RAISE);
            r.setBackstabPyroPercent(r.getBackstabPyroPercent()
                    + Constants.ROGUE_SA_RAISE);
            r.setBackstabWizardPercent(r.getBackstabWizardPercent()
                    + Constants.ROGUE_SA_RAISE);
            r.setParalysisRoguePercent(r.getParalysisRoguePercent()
                    + Constants.ROGUE_SA_RAISE);
            r.setParalysisKnightPercent(r.getParalysisKnightPercent()
                    + Constants.ROGUE_SA_RAISE);
            r.setParalysisPyroPercent(r.getParalysisPyroPercent()
                    + Constants.ROGUE_SA_RAISE);
            r.setParalysisWizardPercent(r.getParalysisWizardPercent()
                    + Constants.ROGUE_SA_RAISE);
        }
    }
}
