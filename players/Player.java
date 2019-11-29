package player;

import ground.BattleField;

public abstract class Player implements Fighter, Fought {
    private int id;
    private int level;
    private int status; // dead or alive
    private int hp;
    private int xp;
    private int initialHp;
    private int bonusHpLevel;
    private BattleField ground;
    private int currentX = -1;
    private int currentY = -1;
    private int previousDamage;
    private int overtimeDamage;
    private int overtimeDamageRound;
    private int canMove = 1;
    private int hasFought;
    private char type;
    private int currentRound;
    private int attackCount;


    public Player() {}

    public Player(int id, int hp, int bonusHpLevel, BattleField g, int x, int y, char c) {
        this.currentX = x;
        this.currentY = y;
        this.ground = g;
        this.id = id;
        this.bonusHpLevel = bonusHpLevel;
        this.initialHp = hp;
        this.hp = hp;
        this.status = 1;
        this.xp = 0;
        this.level = 0;
        this.overtimeDamage = 0;
        this.overtimeDamageRound = 0;
        this.canMove = 1;
        this.hasFought = 0;
        this.previousDamage = 0;
        this.type = c;
        this.attackCount = 0;
    }

    /* returns what the amount of xp necessary for
    the current player to level up is */
    public int toLevelUp () {
        return (250 + 50 * this.level);
    }

    public abstract int getMaxHp();

    /* Removes any ovetime damage */
    public void removeOvertimeDamage() {
        if (this.getOvertimeDamage() > 0) {
            this.setOvertimeDamage(0);
            this.setOvertimeDamageRound(0);
        }

        if (this.getCanMove() == 0) {
            this.canMove = 1;
        }
    }

    /* Computes the overtime damage */
    public void computeOvertimeDamage() {
        if (this.getOvertimeDamage() > 0 && this.getOvertimeDamageRound() > 0) {
            this.setHp(this.getHp() - this.getOvertimeDamage());
            this.setOvertimeDamageRound(this.getOvertimeDamageRound() - 1);
        }

        if (this.getHp() <= 0) {
            this.setStatus(0);
        }
    }

    public void hasWon(Player p) {
        if (p.getHp() <= 0) {
            int newXp = this.getXp() + Math.max(0, 200 - (this.getLevel() - p.getLevel()) * 40);
            this.setXp(newXp);
        }
    }

    public abstract void increaseLevel(int level);

    public abstract void battle(Rogue r);
    public abstract void battle(Pyromancer p);
    public abstract void battle(Wizard w);
    public abstract void battle(Knight k);

    public abstract void accept(Fighter f);

    public int getAttackCount() {
        return attackCount;
    }

    public void setAttackCount(int attackCount) {
        this.attackCount = attackCount;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInitialHp() {
        return initialHp;
    }

    public int getBonusHpLevel() {
        return bonusHpLevel;
    }

    public void setBonusHpLevel(int bonusHpLevel) {
        this.bonusHpLevel = bonusHpLevel;
    }

    public int getPreviousDamage() {
        return previousDamage;
    }

    public void setPreviousDamage(int previousDamage) {
        this.previousDamage = previousDamage;
    }

    public int getHasFought() {
        return hasFought;
    }

    public void setHasFought(int hasFought) {
        this.hasFought = hasFought;
    }

    public void setInitialHp(int initialHp) {
        this.initialHp = initialHp;
    }

    public int getLevel() {
        return level;
    }

    public int getStatus() {
        return status;
    }

    public int getHp() {
        return hp;
    }

    public int getXp() {
        return xp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public BattleField getGround() {
        return ground;
    }

    public void setGround(BattleField ground) {
        this.ground = ground;
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public int getCanMove() {
        return canMove;
    }

    public void setCanMove(int canMove) {
        this.canMove = canMove;
    }

    public int getOvertimeDamageRound() {
        return overtimeDamageRound;
    }

    public void setOvertimeDamageRound(int overtimeDamageRound) {
        this.overtimeDamageRound = overtimeDamageRound;
    }

    public int getOvertimeDamage() {
        return overtimeDamage;
    }

    public void setOvertimeDamage(int overtimeDamage) {
        this.overtimeDamage = overtimeDamage;
    }

}
