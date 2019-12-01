/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package player;

import constants.Constants;
import ground.BattleField;

public abstract class Player implements Fighter, Fought {
    private int id;
    private int level;
    private int status; /* dead or alive */
    private int hp;
    private int xp;
    private int initialHp;
    private int bonusHpLevel;
    private BattleField ground;
    private int currentX;
    private int currentY;
    private int previousDamage;
    private int overtimeDamage;
    private int overtimeDamageRound;
    private int canMove;
    private int immobilityRound;
    private char type;
    private int attackCount;


    public Player() { }

    public Player(final int id, final int hp, final int bonusHpLevel,
                  final BattleField g, final int x, final int y, final char c) {
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
        this.immobilityRound = 0;
        this.previousDamage = 0;
        this.type = c;
        this.attackCount = 0;
    }

    /* returns what the amount of xp necessary for
    the current player to level up is */
    public int toLevelUp() {
        return (Constants.STANDARD_LEVEL_XP
                + Constants.BONUS_LEVEL_XP * this.level);
    }

    /* Returns the maximum hp of the current player  */
    public abstract int getMaxHp();

    /* Removes any overtime damage */
    public void removeOvertimeDamage() {
        if (this.getOvertimeDamage() > 0 && getOvertimeDamageRound() > 0) {
            this.setOvertimeDamage(0);
            this.setOvertimeDamageRound(0);
        }
        if (this.getCanMove() == 0) {
            this.setCanMove(1);
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

    /* Checks if the current player has won against "p" */
    public void hasWon(final Player p) {
        if (p.getHp() <= 0) {
            int newXp = this.getXp() + Math.max(0, Constants.MAX_WINNER_HP
                    - (this.getLevel() - p.getLevel()) * Constants.WINNER_HP_MULTIPLIER);
            this.setXp(newXp);
        }
    }

    /* Increases the level of the current player */
    public abstract void increaseLevel(int lvl);

    /* Implements the fight between the current player and a Rogue */
    public abstract void battle(Rogue r);

    /* Implements the fight between the current player and a Pyromancer */
    public abstract void battle(Pyromancer p);

    /* Implements the fight between the current player and a Wizard */
    public abstract void battle(Wizard w);

    /* Implements the fight between the current player and a Knight */
    public abstract void battle(Knight k);

    /* IMplements the attack accept from another player */
    public abstract void accept(Fighter f);

    /* Returns how many immonbility round are left */
    public int getImmobilityRound() {
        return immobilityRound;
    }

    /* Sets the number of immobility rounds */
    public void setImmobilityRound(final int immobilityRound) {
        this.immobilityRound = immobilityRound;
    }

    /* Returns the current number of attacks */
    public int getAttackCount() {
        return attackCount;
    }

    /* Sets the durrent number of attacks */
    public void setAttackCount(final int attackCount) {
        this.attackCount = attackCount;
    }

    /* Returns the type of the player */
    public char getType() {
        return type;
    }

    /* Sets the type of the player */
    public void setType(final char type) {
        this.type = type;
    }

    /* Gets the id of the player */
    public int getId() {
        return id;
    }

    /* Sets the id of the player */
    public void setId(final int id) {
        this.id = id;
    }

    /* Gets the initial hp */
    public int getInitialHp() {
        return initialHp;
    }

    /* Gets the bonus hp */
    public int getBonusHpLevel() {
        return bonusHpLevel;
    }

    /* Sets the bonus hp */
    public void setBonusHpLevel(final int bonusHpLevel) {
        this.bonusHpLevel = bonusHpLevel;
    }

    /* Gets the previous damage */
    public int getPreviousDamage() {
        return previousDamage;
    }

    /* Sets the previous damage */
    public void setPreviousDamage(final int previousDamage) {
        this.previousDamage = previousDamage;
    }

    /* Sets the initial hp **/
    public void setInitialHp(final int initialHp) {
        this.initialHp = initialHp;
    }

    /* Gets the current level */
    public int getLevel() {
        return level;
    }

    /* Gets the current status */
    public int getStatus() {
        return status;
    }

    /* Gets the current hp */
    public int getHp() {
        return hp;
    }

    /* Gets the current xp */
    public int getXp() {
        return xp;
    }

    /* Sets the current level */
    public void setLevel(final int level) {
        this.level = level;
    }

    /* Sets the current status */
    public void setStatus(final int status) {
        this.status = status;
    }

    /* Sets the current xp */
    public void setXp(final int xp) {
        this.xp = xp;
    }

    /* Sets the current hp */
    public void setHp(final int hp) {
        this.hp = hp;
    }

    /* Gets the ground */
    public BattleField getGround() {
        return ground;
    }

    /* Sets the ground */
    public void setGround(final BattleField ground) {
        this.ground = ground;
    }

    /* Gets the current X */
    public int getCurrentX() {
        return currentX;
    }

    /* Sets the current X */
    public void setCurrentX(final int currentX) {
        this.currentX = currentX;
    }

    /* Gets the current Y */
    public int getCurrentY() {
        return currentY;
    }

    /* Sets the current Y */
    public void setCurrentY(final int currentY) {
        this.currentY = currentY;
    }

    /* Returns if the player can move */
    public int getCanMove() {
        return canMove;
    }

    /* Sets the ability to move */
    public void setCanMove(final int canMove) {
        this.canMove = canMove;
    }

    /* Returns the overtime damage */
    public int getOvertimeDamageRound() {
        return overtimeDamageRound;
    }

    /* Sets the overtime damage */
    public void setOvertimeDamageRound(final int overtimeDamageRound) {
        this.overtimeDamageRound = overtimeDamageRound;
    }

    /* Returns the overtime damage */
    public int getOvertimeDamage() {
        return overtimeDamage;
    }

    /* Sets the overtime damage */
    public void setOvertimeDamage(final int overtimeDamage) {
        this.overtimeDamage = overtimeDamage;
    }
}
