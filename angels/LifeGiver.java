package angels;

import constants.Constants;
import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class LifeGiver extends Angel {
    public int currentX;
    public int currentY;
    public AngelType type;

    public LifeGiver(final AngelType type, final int x, final int y) {
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
            p.setHp(p.getHp() + Constants.PYRO_LG_HP_RAISE);
            if (p.getHp() > p.getMaxHp()) {
                p.setHp(p.getMaxHp());
            }
        }
    }

    @Override
    public void affect(Wizard w, ReadInput readInput) {
        if (w.getStatus() == 1) {
            /* If the player is alive, add hp */
            readInput.printHelp(this, w);
            w.setHp(w.getHp() + Constants.WIZARD_LG_HP_RAISE);
            if (w.getHp() > w.getMaxHp()) {
                w.setHp(w.getMaxHp());
            }
        }
    }

    @Override
    public void affect(Knight k, ReadInput readInput)  {
        if (k.getStatus() == 1) {
            /* If the player is alive, add hp */
            readInput.printHelp(this, k);
            k.setHp(k.getHp() + Constants.KNIGHT_LG_HP_RAISE);
            if (k.getHp() > k.getMaxHp()) {
                k.setHp(k.getMaxHp());
            }
        }
    }

    @Override
    public void affect(Rogue r, ReadInput readInput) {
        if (r.getStatus() == 1) {
            /* If the player is alive, add hp */
            readInput.printHelp(this, r);
            r.setHp(r.getHp() + Constants.ROGUE_LG_HP_RAISE);
            if (r.getHp() > r.getMaxHp()) {
                r.setHp(r.getMaxHp());
            }
        }
    }
}
