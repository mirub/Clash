/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package player;

import angels.AngelEffect;
import constants.Constants;
import ground.BattleField;
import main.ReadInput;
import strategy.Strategy;

public abstract class Player implements Fighter, Fought, AngelEffect {
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
    private int doomerDead;
    private int roundXP;
    private float fireblastRoguePercent;
    private float fireblastKnightPercent;
    private float fireblastPyroPercent;
    private float fireblastWizardPercent;
    private float igniteRoguePercent;
    private float igniteKnightPercent;
    private float ignitePyroPercent;
    private float igniteWizardPercent;
    private float backstabRoguePercent;
    private float backstabKnightPercent;
    private float backstabPyroPercent;
    private float backstabWizardPercent;
    private float paralysisRoguePercent;
    private float paralysisKnightPercent;
    private float paralysisPyroPercent;
    private float paralysisWizardPercent;
    private float executeRoguePercent;
    private float executeKnightPercent;
    private float executePyroPercent;
    private float executeWizardPercent;
    private float slamRoguePercent;
    private float slamKnightPercent;
    private float slamPyroPercent;
    private float slamWizardPercent;
    private float drainRoguePercent;
    private float drainKnightPercent;
    private float drainPyroPercent;
    private float drainWizardPercent;
    private float deflectRoguePercent;
    private float deflectKnightPercent;
    private float deflectPyroPercent;
    private float deflectWizardPercent;


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
        this.doomerDead = 0;
        this.roundXP = 0;
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
    public abstract void increaseLevel(int lvl, ReadInput readInput);

    /* Implements the fight between the current player and a Rogue */
    public abstract void battle(Rogue r);

    /* Implements the fight between the current player and a Pyromancer */
    public abstract void battle(Pyromancer p);

    /* Implements the fight between the current player and a Wizard */
    public abstract void battle(Wizard w);

    /* Implements the fight between the current player and a Knight */
    public abstract void battle(Knight k);

    /* Implements the attack accept from another player */
    public abstract void accept(Fighter f);

    /* Plays the strategy */
    public abstract void chooseStrategy(Strategy strategy);

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

    /* Sees if the player had been killed by the Doomer */
    public int getDoomerDead() {
        return doomerDead;
    }

    /* Sets if the player had been killed by the Doomer */
    public void setDoomerDead(final int doomerDead) {
        this.doomerDead = doomerDead;
    }

    /* Returns the XP at the beginning of the round */
    public int getRoundXP() {
        return roundXP;
    }

    /* Sets the XP at the beginning of the round */
    public void setRoundXP(final int roundXP) {
        this.roundXP = roundXP;
    }

    /* Gets the fireblast percent for rogue */
    public float getFireblastRoguePercent() {
        return fireblastRoguePercent;
    }

    /* Sets the fireblast percent for rogue */
    public void setFireblastRoguePercent(final float fireblastRoguePercent) {
        this.fireblastRoguePercent = fireblastRoguePercent;
    }

    /* Gets the fireblast percent for knight */
    public float getFireblastKnightPercent() {
        return fireblastKnightPercent;
    }

    /* Sets the fireblast percent for knight */
    public void setFireblastKnightPercent(final float fireblastKnightPercent) {
        this.fireblastKnightPercent = fireblastKnightPercent;
    }

    /* Gets the fireblast percent for pyromancer */
    public float getFireblastPyroPercent() {
        return fireblastPyroPercent;
    }

    /* Sets the fireblast percent for pyromancer */
    public void setFireblastPyroPercent(final float fireblastPyroPercent) {
        this.fireblastPyroPercent = fireblastPyroPercent;
    }

    /* Gets the fireblast percent for wizard */
    public float getFireblastWizardPercent() {
        return fireblastWizardPercent;
    }

    /* Sets the fireblast percent for wizard */
    public void setFireblastWizardPercent(final float fireblastWizardPercent) {
        this.fireblastWizardPercent = fireblastWizardPercent;
    }

    /* Gets the ignite percent for rogue */
    public float getIgniteRoguePercent() {
        return igniteRoguePercent;
    }

    /* Sets the ignite percent for rogue */
    public void setIgniteRoguePercent(final float igniteRoguePercent) {
        this.igniteRoguePercent = igniteRoguePercent;
    }

    /* Gets the ignite percent for knight */
    public float getIgniteKnightPercent() {
        return igniteKnightPercent;
    }

    /* Sets the ignite percent for knight */
    public void setIgniteKnightPercent(final float igniteKnightPercent) {
        this.igniteKnightPercent = igniteKnightPercent;
    }

    /* Gets the ignite percent for pyro */
    public float getIgnitePyroPercent() {
        return ignitePyroPercent;
    }

    /* Sets the ignite percent for pyro */
    public void setIgnitePyroPercent(final float ignitePyroPercent) {
        this.ignitePyroPercent = ignitePyroPercent;
    }

    /* Gets the ignite percent for wizard */
    public float getIgniteWizardPercent() {
        return igniteWizardPercent;
    }

    /* Sets the ignite percent for wizard */
    public void setIgniteWizardPercent(final float igniteWizardPercent) {
        this.igniteWizardPercent = igniteWizardPercent;
    }

    /* Gets the backstab percent for rogue */
    public float getBackstabRoguePercent() {
        return backstabRoguePercent;
    }

    /* Sets the backstab percent for rogue */
    public void setBackstabRoguePercent(final float backstabRoguePercent) {
        this.backstabRoguePercent = backstabRoguePercent;
    }

    /* Gets the backstab percent for knight */
    public float getBackstabKnightPercent() {
        return backstabKnightPercent;
    }

    /* Sets the backstab percent for knight */
    public void setBackstabKnightPercent(final float backstabKnightPercent) {
        this.backstabKnightPercent = backstabKnightPercent;
    }

    /* Gets the backstab percent for pyro */
    public float getBackstabPyroPercent() {
        return backstabPyroPercent;
    }

    /* Sets the backstab percent for pyro */
    public void setBackstabPyroPercent(final float backstabPyroPercent) {
        this.backstabPyroPercent = backstabPyroPercent;
    }

    /* Gets the backstab percent for wizard */
    public float getBackstabWizardPercent() {
        return backstabWizardPercent;
    }

    /* Set backstab percent for wizard */
    public void setBackstabWizardPercent(final float backstabWizardPercent) {
        this.backstabWizardPercent = backstabWizardPercent;
    }

    /* Get paralysis percent for rogue */
    public float getParalysisRoguePercent() {
        return paralysisRoguePercent;
    }

    /* Set paralysis percent for rogue */
    public void setParalysisRoguePercent(final float paralysisRoguePercent) {
        this.paralysisRoguePercent = paralysisRoguePercent;
    }

    /* Get paralysis percent for knight */
    public float getParalysisKnightPercent() {
        return paralysisKnightPercent;
    }

    /* Set paralysis percent for knight */
    public void setParalysisKnightPercent(final float paralysisKnightPercent) {
        this.paralysisKnightPercent = paralysisKnightPercent;
    }

    /* Get paralysis percent for pyro */
    public float getParalysisPyroPercent() {
        return paralysisPyroPercent;
    }

    /* Set paralysis percent for pyro */
    public void setParalysisPyroPercent(final float paralysisPyroPercent) {
        this.paralysisPyroPercent = paralysisPyroPercent;
    }

    /* Get paralysis percent for wizard */
    public float getParalysisWizardPercent() {
        return paralysisWizardPercent;
    }

    /* Set paralysis percent for wizard */
    public void setParalysisWizardPercent(final float paralysisWizardPercent) {
        this.paralysisWizardPercent = paralysisWizardPercent;
    }

    /* Get execute percent for rogue */
    public float getExecuteRoguePercent() {
        return executeRoguePercent;
    }

    /* Set execute percent for rogue */
    public void setExecuteRoguePercent(final float executeRoguePercent) {
        this.executeRoguePercent = executeRoguePercent;
    }

    /* Get execute percent for pyro */
    public float getExecutePyroPercent() {
        return executePyroPercent;
    }

    /* Set execute percent for pyro */
    public void setExecutePyroPercent(final float executePyroPercent) {
        this.executePyroPercent = executePyroPercent;
    }

    /* Get execute percent for wizard */
    public float getExecuteWizardPercent() {
        return executeWizardPercent;
    }

    /* Set execute percent for wizard */
    public void setExecuteWizardPercent(final float executeWizardPercent) {
        this.executeWizardPercent = executeWizardPercent;
    }

    /* Get slam percent for rogue */
    public float getSlamRoguePercent() {
        return slamRoguePercent;
    }

    /* Set slam percent for rogue */
    public void setSlamRoguePercent(final float slamRoguePercent) {
        this.slamRoguePercent = slamRoguePercent;
    }

    /* Get slam percent for knight */
    public float getSlamKnightPercent() {
        return slamKnightPercent;
    }

    /* Set slam percent for knight */
    public void setSlamKnightPercent(final float slamKnightPercent) {
        this.slamKnightPercent = slamKnightPercent;
    }

    /* Get slam percent for pyro */
    public float getSlamPyroPercent() {
        return slamPyroPercent;
    }

    /* Set slam percent for pyro */
    public void setSlamPyroPercent(final float slamPyroPercent) {
        this.slamPyroPercent = slamPyroPercent;
    }

    /* Get slam percent for wizard */
    public float getSlamWizardPercent() {
        return slamWizardPercent;
    }

    /* Set slam percent for wizard */
    public void setSlamWizardPercent(final float slamWizardPercent) {
        this.slamWizardPercent = slamWizardPercent;
    }

    /* Get drain percent for rogue */
    public float getDrainRoguePercent() {
        return drainRoguePercent;
    }

    /* Set drain percent for rogue */
    public void setDrainRoguePercent(final float drainRoguePercent) {
        this.drainRoguePercent = drainRoguePercent;
    }

    /* Get drain percent for knight */
    public float getDrainKnightPercent() {
        return drainKnightPercent;
    }

    /* Set drain percent for knight */
    public void setDrainKnightPercent(final float drainKnightPercent) {
        this.drainKnightPercent = drainKnightPercent;
    }

    /* Get drain percent for pyro */
    public float getDrainPyroPercent() {
        return drainPyroPercent;
    }

    /* Set drain percent for pyro */
    public void setDrainPyroPercent(final float drainPyroPercent) {
        this.drainPyroPercent = drainPyroPercent;
    }

    /* Get drain percent for wizard */
    public float getDrainWizardPercent() {
        return drainWizardPercent;
    }

    /* Set drain percent for wizard */
    public void setDrainWizardPercent(final float drainWizardPercent) {
        this.drainWizardPercent = drainWizardPercent;
    }

    /* Get deflect percent for rogue */
    public float getDeflectRoguePercent() {
        return deflectRoguePercent;
    }

    /* Set deflect percent for rogue */
    public void setDeflectRoguePercent(final float deflectRoguePercent) {
        this.deflectRoguePercent = deflectRoguePercent;
    }

    /* Get deflect percent for knight */
    public float getDeflectKnightPercent() {
        return deflectKnightPercent;
    }

    /* Set deflect percent for knight */
    public void setDeflectKnightPercent(final float deflectKnightPercent) {
        this.deflectKnightPercent = deflectKnightPercent;
    }

    /* Get deflect percent for pyro */
    public float getDeflectPyroPercent() {
        return deflectPyroPercent;
    }

    /* Set deflect percent for pyro */
    public void setDeflectPyroPercent(final float deflectPyroPercent) {
        this.deflectPyroPercent = deflectPyroPercent;
    }

    /* Get deflect percent for wizard */
    public float getDeflectWizardPercent() {
        return deflectWizardPercent;
    }

    /* Set deflect percent for wizard */
    public void setDeflectWizardPercent(final float deflectWizardPercent) {
        this.deflectWizardPercent = deflectWizardPercent;
    }

    /* Get execute percent for knight */
    public float getExecuteKnightPercent() {
        return executeKnightPercent;
    }

    /* Set execute percent for knight */
    public void setExecuteKnightPercent(final float executeKnightPercent) {
        this.executeKnightPercent = executeKnightPercent;
    }
}
