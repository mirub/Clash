package angels;

import constants.Constants;
import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class GoodBoy extends Angel{
    public int currentX;
    public int currentY;
    public AngelType type;

    public GoodBoy(final AngelType type, final int x, final int y) {
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
    public void affect(Pyromancer p, ReadInput  readInput) {
        if (p.getStatus() == 1) {
            /* If the player is alive, change hp */
            readInput.printHelp(this, p);
            p.setHp(p.getHp() + Constants.PYRO_GB_HP_RAISE);
            if (p.getHp() > p.getMaxHp()) {
                p.setHp(p.getMaxHp());
            }
            /* If the player is alive, change modifiers */
            p.setFireblastRoguePercent(p.getFireblastRoguePercent()
                    + Constants.PYRO_GB_RAISE);
            p.setFireblastKnightPercent(p.getFireblastKnightPercent()
                    + Constants.PYRO_GB_RAISE);
            p.setFireblastPyroPercent(p.getFireblastPyroPercent()
                    + Constants.PYRO_GB_RAISE);
            p.setFireblastWizardPercent(p.getFireblastWizardPercent()
                    + Constants.PYRO_GB_RAISE);
            p.setIgniteRoguePercent(p.getIgniteRoguePercent()
                    + Constants.PYRO_GB_RAISE);
            p.setIgniteKnightPercent(p.getIgniteKnightPercent()
                    + Constants.PYRO_GB_RAISE);
            p.setIgnitePyroPercent(p.getIgnitePyroPercent()
                    + Constants.PYRO_GB_RAISE);
            p.setIgniteWizardPercent(p.getIgniteWizardPercent()
                    + Constants.PYRO_GB_RAISE);
        }
    }

    @Override
    public void affect(Wizard w, ReadInput readInput) {
        if (w.getStatus() == 1) {
            /* If the player is alive, change hp */
            readInput.printHelp(this, w);
            w.setHp(w.getHp() + Constants.WIZARD_GB_HP_RAISE);
            if (w.getHp() > w.getMaxHp()) {
                w.setHp(w.getMaxHp());
            }
            /* If the player is alive, change modifiers */
            w.setDrainRoguePercent(w.getDrainRoguePercent()
                    + Constants.WIZARD_GB_RAISE);
            w.setDrainKnightPercent(w.getDrainKnightPercent()
                    + Constants.WIZARD_GB_RAISE);
            w.setDrainPyroPercent(w.getDrainPyroPercent()
                    + Constants.WIZARD_GB_RAISE);
            w.setDrainWizardPercent(w.getDrainWizardPercent()
                    + Constants.WIZARD_GB_RAISE);
            w.setDeflectRoguePercent(w.getDeflectRoguePercent()
                    + Constants.WIZARD_GB_RAISE);
            w.setDeflectKnightPercent(w.getDeflectKnightPercent()
                    + Constants.WIZARD_GB_RAISE);
            w.setDeflectPyroPercent(w.getDeflectPyroPercent()
                    + Constants.WIZARD_GB_RAISE);
        }
    }

    @Override
    public void affect(Knight k, ReadInput readInput)  {
        if (k.getStatus() == 1) {
            /* If the player is alive, change hp */
            readInput.printHelp(this, k);
            k.setHp(k.getHp() + Constants.KNIGHT_GB_HP_RAISE);
            if (k.getHp() > k.getMaxHp()) {
                k.setHp(k.getMaxHp());
            }
            /* If the player is alive, change modifiers */
            k.setExecuteRoguePercent(k.getExecuteRoguePercent()
                    + Constants.KNIGHT_GB_RAISE);
            k.setExecutePyroPercent(k.getExecutePyroPercent()
                    + Constants.KNIGHT_GB_RAISE);
            k.setExecuteWizardPercent(k.getExecuteWizardPercent()
                    + Constants.KNIGHT_GB_RAISE);
            k.setSlamRoguePercent(k.getSlamRoguePercent()
                    + Constants.KNIGHT_GB_RAISE);
            k.setSlamKnightPercent(k.getSlamKnightPercent()
                    + Constants.KNIGHT_GB_RAISE);
            k.setSlamPyroPercent(k.getSlamPyroPercent()
                    + Constants.KNIGHT_GB_RAISE);
            k.setSlamWizardPercent(k.getSlamWizardPercent()
                    + Constants.KNIGHT_GB_RAISE);
        }
    }

    @Override
    public void affect(Rogue r, ReadInput readInput) {
        if (r.getStatus() == 1) {
            /* If the player is alive, change hp */
            readInput.printHelp(this, r);
            r.setHp(r.getHp() + Constants.ROGUE_GB_HP_RAISE);
            if (r.getHp() > r.getMaxHp()) {
                r.setHp(r.getMaxHp());
            }
            /* If the player is alive, change modifiers */
            r.setBackstabRoguePercent(r.getBackstabRoguePercent()
                    + Constants.ROGUE_GB_RAISE);
            r.setBackstabKnightPercent(r.getBackstabKnightPercent()
                    + Constants.ROGUE_GB_RAISE);
            r.setBackstabPyroPercent(r.getBackstabPyroPercent()
                    + Constants.ROGUE_GB_RAISE);
            r.setBackstabWizardPercent(r.getBackstabWizardPercent()
                    + Constants.ROGUE_GB_RAISE);
            r.setParalysisRoguePercent(r.getParalysisRoguePercent()
                    + Constants.ROGUE_GB_RAISE);
            r.setParalysisKnightPercent(r.getParalysisKnightPercent()
                    + Constants.ROGUE_GB_RAISE);
            r.setParalysisPyroPercent(r.getParalysisPyroPercent()
                    + Constants.ROGUE_GB_RAISE);
            r.setParalysisWizardPercent(r.getParalysisWizardPercent()
                    + Constants.ROGUE_GB_RAISE);
        }
    }
}
