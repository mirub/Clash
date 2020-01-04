package angels;

import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class TheDoomer extends Angel{
    public int currentX;
    public int currentY;
    public AngelType type;

    public TheDoomer(final AngelType type, final int x, final int y) {
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
            /* If the player is alive, kill it */
            p.setStatus(0);
            p.setDoomerDead(1);
            readInput.printHit(this, p);
            readInput.killedByAngel(p);
        }
    }

    @Override
    public void affect(Wizard w, ReadInput readInput) {
        if (w.getStatus() == 1) {
            /* If the player is alive, kill it */
            w.setStatus(0);
            w.setDoomerDead(1);
            readInput.printHit(this, w);
            readInput.killedByAngel(w);
        }
    }

    @Override
    public void affect(Knight k, ReadInput readInput)  {
        if (k.getStatus() == 1) {
            /* If the player is alive, kill it */
            k.setStatus(0);
            k.setDoomerDead(1);
            readInput.printHit(this, k);
            readInput.killedByAngel(k);
        }
    }

    @Override
    public void affect(Rogue r, ReadInput readInput) {
        if (r.getStatus() == 1) {
            /* If the player is alive, kill it */
            r.setStatus(0);
            r.setDoomerDead(1);
            readInput.printHit(this, r);
            readInput.killedByAngel(r);
        }
    }
}
