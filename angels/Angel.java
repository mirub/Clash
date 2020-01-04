package angels;

import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public abstract class Angel implements AngelAffect{
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

    public Angel (final AngelType type, final int x, final int y) {
        this.currentX = x;
        this.currentY = y;
        this.type = type;
        this.isOnMap = 0;
    }

    public int getIsOnMap() {
        return isOnMap;
    }

    public void setIsOnMap(int isOnMap) {
        this.isOnMap = isOnMap;
    }

    public AngelType getType() {
        return type;
    }

    public void setType(final AngelType type) {
        this.type = type;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(final int currentY) {
        this.currentY = currentY;
    }

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
