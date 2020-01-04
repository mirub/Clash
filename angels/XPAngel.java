package angels;

import constants.Constants;
import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class XPAngel extends Angel {
    public int currentX;
    public int currentY;
    public AngelType type;

    public XPAngel(final AngelType type, final int x, final int y) {
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
            /* If the player is alive, add xp */
            p.setXp(p.getXp() + Constants.PYRO_XA_XP);
            readInput.printHelp(this, p);
            p.increaseLevel(p.getLevel(), readInput);
        }
    }

    @Override
    public void affect(Wizard w, ReadInput readInput) {
        if (w.getStatus() == 1) {
            /* If the player is alive, add xp */
            w.setXp(w.getXp() + Constants.WIZARD_XA_XP);
            readInput.printHelp(this, w);
            w.increaseLevel(w.getLevel(), readInput);
        }
    }

    @Override
    public void affect(Knight k, ReadInput readInput)  {
        if (k.getStatus() == 1) {
            /* If the player is alive, add xp */
            k.setXp(k.getXp() + Constants.KNIGHT_XA_XP);
            readInput.printHelp(this, k);
            k.increaseLevel(k.getLevel(), readInput);
        }
    }

    @Override
    public void affect(Rogue r, ReadInput readInput) {
        if (r.getStatus() == 1) {
            /* If the player is alive, add xp */
            r.setXp(r.getXp() + Constants.ROGUE_XA_XP);
            readInput.printHelp(this, r);
            r.increaseLevel(r.getLevel(), readInput);
        }
    }
}
