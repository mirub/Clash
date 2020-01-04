package angels;

import constants.Constants;
import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class XPAngel extends Angel {
    private int currentX;
    private int currentY;
    private AngelType type;

    public XPAngel(final AngelType type, final int x, final int y) {
        this.currentX = x;
        this.currentY = y;
        this.type = type;
    }

    @Override
    /* Returns the current X */
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
    public void affect(final Pyromancer p, final ReadInput readInput) {
        if (p.getStatus() == 1) {
            /* If the player is alive, add xp */
            p.setXp(p.getXp() + Constants.PYRO_XA_XP);
            readInput.printHelp(this, p);
            p.increaseLevel(p.getLevel(), readInput);
        }
    }

    @Override
    /* Affects the wizard */
    public void affect(final Wizard w, final ReadInput readInput) {
        if (w.getStatus() == 1) {
            /* If the player is alive, add xp */
            w.setXp(w.getXp() + Constants.WIZARD_XA_XP);
            readInput.printHelp(this, w);
            w.increaseLevel(w.getLevel(), readInput);
        }
    }

    @Override
    /* Affect the knight */
    public void affect(final Knight k, final ReadInput readInput)  {
        if (k.getStatus() == 1) {
            /* If the player is alive, add xp */
            k.setXp(k.getXp() + Constants.KNIGHT_XA_XP);
            readInput.printHelp(this, k);
            k.increaseLevel(k.getLevel(), readInput);
        }
    }

    @Override
    /* Affect the rogue */
    public void affect(final Rogue r, final ReadInput readInput) {
        if (r.getStatus() == 1) {
            /* If the player is alive, add xp */
            r.setXp(r.getXp() + Constants.ROGUE_XA_XP);
            readInput.printHelp(this, r);
            r.increaseLevel(r.getLevel(), readInput);
        }
    }
}
