package angels;

import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public abstract class Angel implements AngelAffect {
    private AngelType type;
    private int currentX;
    private int currentY;
    private int isOnMap;

    public Angel() {
        this.type = null;
        this.currentX = -1;
        this.currentY = -1;
        this.isOnMap = 0;
    }

    public Angel(final AngelType type, final int x, final int y) {
        this.currentX = x;
        this.currentY = y;
        this.type = type;
        this.isOnMap = 0;
    }

    /* Get if the player is on the map */
    public int getIsOnMap() {
        return isOnMap;
    }

    /* Set if the player is on the map */
    public void setIsOnMap(final int isOnMap) {
        this.isOnMap = isOnMap;
    }

    /* Get the angel type */
    public AngelType getType() {
        return type;
    }

    /* Se the angel type */
    public void setType(final AngelType type) {
        this.type = type;
    }

    /* Get the current X */
    public int getCurrentX() {
        return currentX;
    }

    /* Ge the current Y */
    public int getCurrentY() {
        return currentY;
    }

    /* Sets the current Y */
    public void setCurrentY(final int currentY) {
        this.currentY = currentY;
    }

    /* Sets the current X */
    public void setCurrentX(final int currentX) {
        this.currentX = currentX;
    }

    @Override
    public abstract void affect(Pyromancer p, ReadInput readInput);

    @Override
    public abstract void affect(Wizard w, ReadInput readInput);

    @Override
    public abstract void affect(Knight k, ReadInput readInput);

    @Override
    public abstract void affect(Rogue r, ReadInput readInput);
}
