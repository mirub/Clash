/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package player;

import angels.Angel;
import angels.AngelEffect;
import constants.Constants;
import ground.BattleField;
import magician.GreatMagician;
import main.ReadInput;
import strategy.Strategy;

public final class Knight extends Player implements Fighter, Fought, AngelEffect {

    public Knight() { }

    public Knight(final int id, final int initialHP, final int bonusHpLevel,
                  final BattleField g, final int x, final int y, final char c) {
        super(id, initialHP, bonusHpLevel, g, x, y, c);
        this.setExecuteRoguePercent(Constants.EXECUTE_ROGUE_PERCENT);
        this.setExecuteKnightPercent(Constants.EXECUTE_KNIGHT_PERCENT);
        this.setExecutePyroPercent(Constants.EXECUTE_PYRO_PERCENT);
        this.setExecuteWizardPercent(Constants.EXECUTE_WIZARD_PERCENT);
        this.setSlamRoguePercent(Constants.SLAM_ROGUE_PERCENT);
        this.setSlamKnightPercent(Constants.SLAM_KNIGHT_PERCENT);
        this.setSlamPyroPercent(Constants.SLAM_PYRO_PERCENT);
        this.setSlamWizardPercent(Constants.SLAM_WIZARD_PERCENT);
    }

    /* Increases the level if needed */
    @Override
    public void increaseLevel(final int level, final ReadInput readInput) {
        int ok = 0;
        if (this.getStatus() == 1) {
            while (this.getXp() >= this.toLevelUp()) {
                this.setLevel(this.getLevel() + 1);
                readInput.printLevelUp(this);
                ok = 1;
            }
            if (ok == 1) {
                this.setHp(Constants.INITIAL_KNIGHT_HP + this.getLevel()
                        * Constants.KNIGHT_HP_LEVEL_BONUS);
            }
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
            p.setHp(p.getHp() - hpLimit);
            return;
        }

        float basicExecuteDamage = this.getBasicExecuteDamage();
        float basicSlamDamage = this.getBasicSlamDamage();

        p.removeOvertimeDamage();
        p.setCanMove(0);
        p.setImmobilityRound(1);

        basicExecuteDamage *= this.getExecutePyroPercent();
        basicSlamDamage *= this.getSlamPyroPercent();

        int basicExecuteDamageRounded = Math.round(basicExecuteDamage);
        int basicSlamDamageRounded = Math.round(basicSlamDamage);

        int totalDamage = basicExecuteDamageRounded + basicSlamDamageRounded;
        p.setHp(p.getHp() - totalDamage);
        p.setPreviousDamage(totalDamage);
    }

    /* Implements the battle between two Knights*/
    @Override
    public void battle(final Knight k) {
        int hpLimit = this.computeHpLimit(k);

        if (k.getHp() < hpLimit) {
            k.setPreviousDamage(k.getHp());
            k.setHp(k.getHp() - hpLimit);
            return;
        }

        float basicExecuteDamage = this.getBasicExecuteDamage();
        float basicSlamDamage = this.getBasicSlamDamage();

        basicExecuteDamage *= this.getExecuteKnightPercent();
        basicSlamDamage *= this.getSlamKnightPercent();

        k.removeOvertimeDamage();
        k.setCanMove(0);
        k.setImmobilityRound(1);

        int basicExecuteDamageRounded = Math.round(basicExecuteDamage);
        int basicSlamDamageRounded = Math.round(basicSlamDamage);

        int totalDamage = basicExecuteDamageRounded + basicSlamDamageRounded;
    //System.out.println("Player " + this.getId() + "gives " + totalDamage + " to " + k.getId());
        //System.out.println("Player " + k.getId() + " had " + k.getHp() + " hp");

        k.setHp(k.getHp() - totalDamage);
        //System.out.println("Player " + k.getId() + " has now  " + k.getHp() + " hp");
        k.setPreviousDamage(totalDamage);
    }

    /* Implements the battle between a Knight and a Rogue */
    @Override
    public void battle(final Rogue r) {
        int hpLimit = this.computeHpLimit(r);

        if (r.getHp() < hpLimit) {
            r.setPreviousDamage(r.getHp());
            r.setHp(r.getHp() - hpLimit);
            return;
        }

        float basicExecuteDamage = this.getBasicExecuteDamage();
        float basicSlamDamage = this.getBasicSlamDamage();

        basicExecuteDamage *= this.getExecuteRoguePercent();
        basicSlamDamage *= this.getSlamRoguePercent();

        int basicExecuteDamageRounded = Math.round(basicExecuteDamage);
        int basicSlamDamageRounded = Math.round(basicSlamDamage);

        r.removeOvertimeDamage();
        r.setCanMove(0);
        r.setImmobilityRound(1);

        int totalDamage = basicExecuteDamageRounded + basicSlamDamageRounded;
        r.setHp(r.getHp() - totalDamage);
        r.setPreviousDamage(totalDamage);
    }

    /* Implements the battle between a Knight and a Wizard */
    @Override
    public void battle(final Wizard w) {
        w.removeOvertimeDamage();
        int hpLimit = this.computeHpLimit(w);

        if (w.getHp() < hpLimit) {
            w.setPreviousDamage(w.getHp());
            w.setHp(w.getHp() - hpLimit);
        }

        float basicExecuteDamage = this.getBasicExecuteDamage();
        float basicSlamDamage = this.getBasicSlamDamage();

        int basicExecuteDamageRounded = Math.round(basicExecuteDamage);
        int basicSlamDamageRounded = Math.round(basicSlamDamage);

        int totalDamage = basicExecuteDamageRounded + basicSlamDamageRounded;
        w.setPreviousDamage(totalDamage);

        basicExecuteDamage *= this.getExecuteWizardPercent();
        basicSlamDamage *= this.getSlamWizardPercent();

        basicExecuteDamageRounded = Math.round(basicExecuteDamage);
        basicSlamDamageRounded = Math.round(basicSlamDamage);

        w.setCanMove(0);
        w.setImmobilityRound(1);

        totalDamage = basicExecuteDamageRounded + basicSlamDamageRounded;
        w.setHp(w.getHp() - totalDamage);
    }

    /* Accepts the fight from fighter "v" */
    public void accept(final Fighter v) {
        v.battle(this);
    }

    /* Accepts the effect from angel "a" */
    public void isAffected(final Angel a, final ReadInput readInput,
                           final GreatMagician greatMagician) {
        a.affect(this, readInput, greatMagician); }

    /* Chooses the strategy */
    public void chooseStrategy(final Strategy strategy) {
        strategy.doOperation(this);
    }
}
