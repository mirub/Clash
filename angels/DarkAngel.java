package angels;

import constants.Constants;
import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class DarkAngel extends Angel{
    public int currentX;
    public int currentY;
    public AngelType type;

    public DarkAngel(final AngelType type, final int x, final int y) {
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
            /* If the player is alive, substract hp */
            readInput.printHit(this, p);
            p.setHp(p.getHp() - Constants.PYRO_DA_SUBSTRACT);
            if (p.getHp() <= 0) {
                p.setStatus(0);
                readInput.killedByAngel(p);
            }
        }
    }

    @Override
    public void affect(Wizard w, ReadInput readInput) {
        if (w.getStatus() == 1) {
            /* If the player is alive, substract hp */
            readInput.printHit(this, w);
            w.setHp(w.getHp() - Constants.WIZARD_DA_SUBSTRACT);
            if (w.getHp() <= 0) {
                w.setStatus(0);
                readInput.killedByAngel(w);
            }
        }
    }

    @Override
    public void affect(Knight k, ReadInput readInput)  {
        if (k.getStatus() == 1) {
            /* If the player is alive, substract hp */
            readInput.printHit(this, k);
            k.setHp(k.getHp() - Constants.KNIGHT_DA_SUBSTRACT);
            if (k.getHp() <= 0) {
                k.setStatus(0);
                readInput.killedByAngel(k);
            }
        }
    }

    @Override
    public void affect(Rogue r, ReadInput readInput) {
        if (r.getStatus() == 1) {
            /* If the player is alive, substract hp */
            readInput.printHit(this, r);
            r.setHp(r.getHp() - Constants.ROGUE_DA_SUBSTRACT);
            if (r.getHp() <= 0) {
                r.setStatus(0);
                readInput.killedByAngel(r);
            }
        }
    }
}
