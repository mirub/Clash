/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package player;

import constants.Constants;
import ground.BattleField;

public final class Knight extends Player implements Fighter, Fought {
    public Knight() { }

    public Knight(final int id, final int initialHP, final int bonusHpLevel,
                  final BattleField g, final int x, final int y, final char c) {
        super(id, initialHP, bonusHpLevel, g, x, y, c);
    }

    /* Increases the level if needed */
    @Override
    public void increaseLevel(final int level) {
        int ok = 0;
        while (this.getXp() >= this.toLevelUp()) {
            this.setLevel(this.getLevel() + 1);
            ok = 1;
        }
        if (ok == 1) {
            this.setHp(Constants.INITIAL_KNIGHT_HP + this.getLevel()
                    * Constants.KNIGHT_HP_LEVEL_BONUS);
        }
    }

    /* Returns the maximum hp per level of the current player */
    @Override
    public int getMaxHp() {
        return (Constants.INITIAL_KNIGHT_HP
                + Constants.KNIGHT_HP_LEVEL_BONUS * this.getLevel());
    }

    /* Returns the basic execute damage */
    public float getBasicExecuteDamage() {
        float executeDamage = Constants.EXECUTE_DAMAGE
                + Constants.EXECUTE_DAMAGE_BONUS * this.getLevel();

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'L') {
            executeDamage *= Constants.KNIGHT_LAND_PERCENT;
        }

        return executeDamage;
    }

    /* Returns the basic slam damage */
    public float getBasicSlamDamage() {
        float slamDamage = Constants.SLAM_DAMAGE
                + Constants.SLAM_DAMAGE_LEVEL_BONUS * this.getLevel();

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'L') {
            slamDamage *= Constants.KNIGHT_LAND_PERCENT;
        }

        return slamDamage;
    }

    /* Computes the Hp limit for the player p*/
    int computeHpLimit(final Player p) {
        float hpLimit = Constants.KNIGHT_OPPONENT_PERCENT_HP * p.getMaxHp()
                + Constants.OPPONENT_HP_MULTIPLIER * this.getLevel() * p.getMaxHp();

        if (hpLimit > Constants.MAX_KNIGHT_HP_LIMIT * p.getMaxHp()) {
            hpLimit = Constants.MAX_KNIGHT_HP_LIMIT * p.getMaxHp();
        }

        return Math.round(hpLimit);
    }

    /* Implements the battle between a Knight and a Pyromancer */
    @Override
    public void battle(final Pyromancer p) {
        int hpLimit = this.computeHpLimit(p);
        if (p.getHp() < hpLimit) {
            p.setPreviousDamage(p.getHp());
            p.setStatus(0);
            this.hasWon(p);
            return;
        }

        float basicExecuteDamage = this.getBasicExecuteDamage();
        float basicSlamDamage = this.getBasicSlamDamage();

        p.removeOvertimeDamage();
        p.setCanMove(0);
        p.setImmobilityRound(1);

        basicExecuteDamage *= Constants.EXECUTE_PYRO_PERCENT;
        basicSlamDamage *= Constants.SLAM_PYRO_PERCENT;

        int basicExecuteDamageRounded = Math.round(basicExecuteDamage);
        int basicSlamDamageRounded = Math.round(basicSlamDamage);

        int totalDamage = basicExecuteDamageRounded + basicSlamDamageRounded;
        p.setHp(p.getHp() - totalDamage);
        p.setPreviousDamage(totalDamage);

        if (p.getHp() <= 0) {
            p.setStatus(0);
            this.hasWon(p);
        }
    }

    /* Implements the battle between two Knights*/
    @Override
    public void battle(final Knight k) {
        int hpLimit = this.computeHpLimit(k);

        if (k.getHp() < hpLimit) {
            k.setPreviousDamage(k.getHp());
            k.setStatus(0);
            this.hasWon(k);
            return;
        }

        float basicExecuteDamage = this.getBasicExecuteDamage();
        float basicSlamDamage = this.getBasicSlamDamage();

        basicExecuteDamage *= Constants.EXECUTE_KNIGHT_PERCENT;
        basicSlamDamage *= Constants.SLAM_KNIGHT_PERCENT;

        k.removeOvertimeDamage();
        k.setCanMove(0);
        k.setImmobilityRound(1);

        int basicExecuteDamageRounded = Math.round(basicExecuteDamage);
        int basicSlamDamageRounded = Math.round(basicSlamDamage);

        int totalDamage = basicExecuteDamageRounded + basicSlamDamageRounded;
        k.setHp(k.getHp() - totalDamage);

        k.setPreviousDamage(totalDamage);

        if (k.getHp() <= 0) {
            k.setStatus(0);
            this.hasWon(k);
        }
    }

    /* Implements the battle between a Knight and a Rogue */
    @Override
    public void battle(final Rogue r) {
        int hpLimit = this.computeHpLimit(r);

        if (r.getHp() < hpLimit) {
            r.setPreviousDamage(r.getHp());
            r.setStatus(0);
            this.hasWon(r);
            return;
        }

        float basicExecuteDamage = this.getBasicExecuteDamage();
        float basicSlamDamage = this.getBasicSlamDamage();

        basicExecuteDamage *= Constants.EXECUTE_ROGUE_PERCENT;
        basicSlamDamage *= Constants.SLAM_ROGUE_PERCENT;

        int basicExecuteDamageRounded = Math.round(basicExecuteDamage);
        int basicSlamDamageRounded = Math.round(basicSlamDamage);

        r.removeOvertimeDamage();
        r.setCanMove(0);
        r.setImmobilityRound(1);

        int totalDamage = basicExecuteDamageRounded + basicSlamDamageRounded;
        r.setHp(r.getHp() - totalDamage);
        r.setPreviousDamage(totalDamage);

        if (r.getHp() <= 0) {
            r.setStatus(0);
            this.hasWon(r);
        }
    }

    /* Implements the battle between a Knight and a Wizard */
    @Override
    public void battle(final Wizard w) {
        w.removeOvertimeDamage();
        int hpLimit = this.computeHpLimit(w);

        if (w.getHp() < hpLimit) {
            w.setStatus(0);
            this.hasWon(w);
        }

        float basicExecuteDamage = this.getBasicExecuteDamage();
        float basicSlamDamage = this.getBasicSlamDamage();

        int basicExecuteDamageRounded = Math.round(basicExecuteDamage);
        int basicSlamDamageRounded = Math.round(basicSlamDamage);

        int totalDamage = basicExecuteDamageRounded + basicSlamDamageRounded;
        w.setPreviousDamage(totalDamage);

        basicExecuteDamage *= Constants.EXECUTE_WIZARD_PERCENT;
        basicSlamDamage *= Constants.SLAM_WIZARD_PERCENT;

        basicExecuteDamageRounded = Math.round(basicExecuteDamage);
        basicSlamDamageRounded = Math.round(basicSlamDamage);

        w.setCanMove(0);
        w.setImmobilityRound(1);

        totalDamage = basicExecuteDamageRounded + basicSlamDamageRounded;
        w.setHp(w.getHp() - totalDamage);

        if (w.getHp() <= 0) {
            w.setStatus(0);
            this.hasWon(w);
        }
    }

    /* Accepts the fight from fighter "v" */
    public void accept(final Fighter v) {
        v.battle(this);
    }
}
