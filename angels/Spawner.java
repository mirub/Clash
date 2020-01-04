package angels;

import constants.Constants;
import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public class Spawner extends Angel {
    private int currentX;
    private int currentY;
    private AngelType type;

    public Spawner(final AngelType type, final int x, final int y) {
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
        if (p.getStatus() == 0) {
            /*If the player is dead, bring it back to life */
            readInput.printHelp(this, p);
            p.setStatus(1);
            if (p.getDoomerDead() == 0) {
                /*If the player was not killed by Doomer,
                set the hp as it was at the beginning of
                the round */
                p.setXp(p.getRoundXP());
            }
            p.setHp(Constants.PYRO_SPAWN_HP);
            readInput.printResurrection(p);
        }
    }

    @Override
    /* Affects the wizard */
    public void affect(final Wizard w, final ReadInput readInput) {
        if (w.getStatus() == 0) {
            /*If the player is dead, bring it back to life */
            readInput.printHelp(this, w);
            w.setStatus(1);
            if (w.getDoomerDead() == 0) {
                /*If the player was not killed by Doomer,
                set the hp as it was at the beginning of
                the round */
                w.setXp(w.getRoundXP());
            }
            w.setHp(Constants.WIZARD_SPAWN_HP);
            readInput.printResurrection(w);
        }
    }

    @Override
    /* Affects the knight */
    public void affect(final Knight k, final ReadInput readInput)  {
        if (k.getStatus() == 0) {
            /*If the player is dead, bring it back to life */
            readInput.printHelp(this, k);
            k.setStatus(1);
            if (k.getDoomerDead() == 0) {
                /*If the player was not killed by Doomer,
                set the hp as it was at the beginning of
                the round */
                k.setXp(k.getRoundXP());
            }
            k.setHp(Constants.KNIGHT_SPAWN_HP);
            readInput.printResurrection(k);
        }
    }

    @Override
    /* Affects the rogue */
    public void affect(final Rogue r, final ReadInput readInput) {
        if (r.getStatus() == 0) {
            /*If the player is dead, bring it back to life */
            readInput.printHelp(this, r);
            r.setStatus(1);
            if (r.getDoomerDead() == 0) {
                /*If the player was not killed by Doomer,
                set the hp as it was at the beginning of
                the round */
                r.setXp(r.getRoundXP());
            }
            r.setHp(Constants.ROGUE_SPAWN_HP);
            readInput.printResurrection(r);
        }
    }
}
