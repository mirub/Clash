package angels;

import constants.Constants;
import magician.GreatMagician;
import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class DarkAngel extends Angel {
    private int currentX;
    private int currentY;
    private AngelType type;

    public DarkAngel(final AngelType type, final int x, final int y) {
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
    /* Sets the current X*/
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
            /* Notice the magician */
            greatMagician.setNotice(readInput.printHit(this, p));
            p.setHp(p.getHp() - Constants.PYRO_DA_SUBSTRACT);
            if (p.getHp() <= 0) {
                p.setStatus(0);
                /* Notice the magician */
                greatMagician.setNotice(readInput.killedByAngel(p));
            }
        }
    }

    @Override
    /* Affects the wizard */
    public void affect(final Wizard w, final ReadInput readInput,
                       final GreatMagician greatMagician) {
        if (w.getStatus() == 1) {
            /* If the player is alive, substract hp */
            /* Notice the magician */
            greatMagician.setNotice(readInput.printHit(this, w));
            w.setHp(w.getHp() - Constants.WIZARD_DA_SUBSTRACT);
            if (w.getHp() <= 0) {
                w.setStatus(0);
                /* Notice the magician */
                greatMagician.setNotice(readInput.killedByAngel(w));
            }
        }
    }

    @Override
    /* Affects the knight */
    public void affect(final Knight k, final ReadInput readInput,
                       final GreatMagician greatMagician)  {
        if (k.getStatus() == 1) {
            /* If the player is alive, substract hp */
            /* Notice the magician */
            greatMagician.setNotice(readInput.printHit(this, k));
            k.setHp(k.getHp() - Constants.KNIGHT_DA_SUBSTRACT);
            if (k.getHp() <= 0) {
                k.setStatus(0);
                /* Notice the magician */
                greatMagician.setNotice(readInput.killedByAngel(k));
            }
        }
    }

    @Override
    /* Affects the rogue */
    public void affect(final Rogue r, final ReadInput readInput,
                       final GreatMagician greatMagician) {
        if (r.getStatus() == 1) {
            /* If the player is alive, substract hp */
            /* Notice the magician */
            greatMagician.setNotice(readInput.printHit(this, r));
            r.setHp(r.getHp() - Constants.ROGUE_DA_SUBSTRACT);
            if (r.getHp() <= 0) {
                r.setStatus(0);
                /* Notice the magician */
                greatMagician.setNotice(readInput.killedByAngel(r));
            }
        }
    }
}
