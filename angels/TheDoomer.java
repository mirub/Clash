package angels;

import magician.GreatMagician;
import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class TheDoomer extends Angel {
    private int currentX;
    private int currentY;
    private AngelType type;

    public TheDoomer(final AngelType type, final int x, final int y) {
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
            /* If the player is alive, kill it */
            p.setStatus(0);
            p.setDoomerDead(1);
            /* Notice the magician */
            greatMagician.setNotice(readInput.printHit(this, p));
            greatMagician.setNotice(readInput.killedByAngel(p));
        }
    }

    @Override
    /* Affects the wizard */
    public void affect(final Wizard w, final ReadInput readInput,
                       final GreatMagician greatMagician) {
        if (w.getStatus() == 1) {
            /* If the player is alive, kill it */
            w.setStatus(0);
            w.setDoomerDead(1);
            /* Notice the magician */
            greatMagician.setNotice(readInput.printHit(this, w));
            greatMagician.setNotice(readInput.killedByAngel(w));
        }
    }

    @Override
    /* Affects the knight */
    public void affect(final Knight k, final ReadInput readInput,
                       final GreatMagician greatMagician)  {
        if (k.getStatus() == 1) {
            /* If the player is alive, kill it */
            k.setStatus(0);
            k.setDoomerDead(1);
            /* Notice the magician */
            greatMagician.setNotice(readInput.printHit(this, k));
            greatMagician.setNotice(readInput.killedByAngel(k));
        }
    }

    @Override
    /* Affects the rogue */
    public void affect(final Rogue r, final ReadInput readInput,
                       final GreatMagician greatMagician) {
        if (r.getStatus() == 1) {
            /* If the player is alive, kill it */
            r.setStatus(0);
            r.setDoomerDead(1);
            /* Notice the magician */
            greatMagician.setNotice(readInput.printHit(this, r));
            greatMagician.setNotice(readInput.killedByAngel(r));
        }
    }
}
