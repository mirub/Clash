package angels;

import constants.Constants;
import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class LevelUpAngel extends Angel{
    public int currentX;
    public int currentY;
    public AngelType type;

    public LevelUpAngel(final AngelType type, final int x, final int y) {
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
            /* If the player is alive, raise level */
            p.setXp(Constants.STANDARD_LEVEL_XP
                    + Constants.BONUS_LEVEL_XP * p.getLevel());
            p.setLevel(p.getLevel() + 1);
            p.setHp(Constants.INITIAL_PYRO_HP + p.getLevel()
                    * Constants.PYRO_HP_LEVEL_BONUS);
            readInput.printHelp(this, p);
            readInput.printLevelUp(p);
            /* If the player is alive, change modifiers */
            p.setFireblastRoguePercent(p.getFireblastRoguePercent()
                    + Constants.PYRO_LA_RAISE);
            p.setFireblastKnightPercent(p.getFireblastKnightPercent()
                    + Constants.PYRO_LA_RAISE);
            p.setFireblastPyroPercent(p.getFireblastPyroPercent()
                    + Constants.PYRO_LA_RAISE);
            p.setFireblastWizardPercent(p.getFireblastWizardPercent()
                    + Constants.PYRO_LA_RAISE);
            p.setIgniteRoguePercent(p.getIgniteRoguePercent()
                    + Constants.PYRO_LA_RAISE);
            p.setIgniteKnightPercent(p.getIgniteKnightPercent()
                    + Constants.PYRO_LA_RAISE);
            p.setIgnitePyroPercent(p.getIgnitePyroPercent()
                    + Constants.PYRO_LA_RAISE);
            p.setIgniteWizardPercent(p.getIgniteWizardPercent()
                    + Constants.PYRO_LA_RAISE);
        }
    }

    @Override
    public void affect(Wizard w, ReadInput readInput) {
        if (w.getStatus() == 1) {
            /* If the player is alive, raise level */
            w.setXp(Constants.STANDARD_LEVEL_XP
                    + Constants.BONUS_LEVEL_XP * w.getLevel());
            w.setLevel(w.getLevel() + 1);
            w.setHp(Constants.INITIAL_WIZARD_HP + w.getLevel()
                    * Constants.WIZARD_HP_LEVEL_BONUS);
            readInput.printHelp(this, w);
            readInput.printLevelUp(w);
            /* If the player is alive, change modifiers */
            w.setDrainRoguePercent(w.getDrainRoguePercent()
                    + Constants.WIZARD_LA_RAISE);
            w.setDrainKnightPercent(w.getDrainKnightPercent()
                    + Constants.WIZARD_LA_RAISE);
            w.setDrainPyroPercent(w.getDrainPyroPercent()
                    + Constants.WIZARD_LA_RAISE);
            w.setDrainWizardPercent(w.getDrainWizardPercent()
                    + Constants.WIZARD_LA_RAISE);
            w.setDeflectRoguePercent(w.getDeflectRoguePercent()
                    + Constants.WIZARD_LA_RAISE);
            w.setDeflectKnightPercent(w.getDeflectKnightPercent()
                    + Constants.WIZARD_LA_RAISE);
            w.setDeflectPyroPercent(w.getDeflectPyroPercent()
                    + Constants.WIZARD_LA_RAISE);
        }
    }

    @Override
    public void affect(Knight k, ReadInput readInput)  {
        if (k.getStatus() == 1) {
            /* If the player is alive, raise level */
            k.setXp(Constants.STANDARD_LEVEL_XP
                    + Constants.BONUS_LEVEL_XP * k.getLevel());
            k.setLevel(k.getLevel() + 1);
            k.setHp(Constants.INITIAL_KNIGHT_HP + k.getLevel()
                    * Constants.KNIGHT_HP_LEVEL_BONUS);
            readInput.printHelp(this, k);
            readInput.printLevelUp(k);
            /* If the player is alive, change modifiers */
            k.setExecuteRoguePercent(k.getExecuteRoguePercent()
                    + Constants.KNIGHT_LA_RAISE);
            k.setExecutePyroPercent(k.getExecutePyroPercent()
                    + Constants.KNIGHT_LA_RAISE);
            k.setExecuteWizardPercent(k.getExecuteWizardPercent()
                    + Constants.KNIGHT_LA_RAISE);
            k.setSlamRoguePercent(k.getSlamRoguePercent()
                    + Constants.KNIGHT_LA_RAISE);
            k.setSlamKnightPercent(k.getSlamKnightPercent()
                    + Constants.KNIGHT_LA_RAISE);
            k.setSlamPyroPercent(k.getSlamPyroPercent()
                    + Constants.KNIGHT_LA_RAISE);
            k.setSlamWizardPercent(k.getSlamWizardPercent()
                    + Constants.KNIGHT_LA_RAISE);
        }
    }

    @Override
    public void affect(Rogue r, ReadInput readInput) {
        if (r.getStatus() == 1) {
            /* If the player is alive, raise level */
            r.setXp(Constants.STANDARD_LEVEL_XP
                    + Constants.BONUS_LEVEL_XP * r.getLevel());
            r.setLevel(r.getLevel() + 1);
            r.setHp(Constants.INITIAL_ROGUE_HP
                    + r.getLevel() * Constants.ROGUE_HP_LEVEL_BONUS);
            readInput.printHelp(this, r);
            readInput.printLevelUp(r);
            /* If the player is alive, change modifiers */
            r.setBackstabRoguePercent(r.getBackstabRoguePercent()
                    + Constants.ROGUE_LA_RAISE);
            r.setBackstabKnightPercent(r.getBackstabKnightPercent()
                    + Constants.ROGUE_LA_RAISE);
            r.setBackstabPyroPercent(r.getBackstabPyroPercent()
                    + Constants.ROGUE_LA_RAISE);
            r.setBackstabWizardPercent(r.getBackstabWizardPercent()
                    + Constants.ROGUE_LA_RAISE);
            r.setParalysisRoguePercent(r.getParalysisRoguePercent()
                    + Constants.ROGUE_LA_RAISE);
            r.setParalysisKnightPercent(r.getParalysisKnightPercent()
                    + Constants.ROGUE_LA_RAISE);
            r.setParalysisPyroPercent(r.getParalysisPyroPercent()
                    + Constants.ROGUE_LA_RAISE);
            r.setParalysisWizardPercent(r.getParalysisWizardPercent()
                    + Constants.ROGUE_LA_RAISE);
        }
    }
}
