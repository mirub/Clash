package angels;

import constants.Constants;
import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class LifeGiver extends Angel {
    private int currentX;
    private int currentY;
    private AngelType type;

    public LifeGiver(final AngelType type, final int x, final int y) {
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
    public void affect(final Pyromancer p, final ReadInput readInput) {
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
    /* Affects the wizard */
    public void affect(final Wizard w, final ReadInput readInput) {
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
    /* Affects the knight */
    public void affect(final Knight k, final ReadInput readInput)  {
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
    /* Affects the rogue */
    public void affect(final Rogue r, final ReadInput readInput) {
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
