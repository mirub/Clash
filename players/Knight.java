package player;

import constants.Constants;
import ground.BattleField;

public class Knight extends Player implements Fighter, Fought {
    public Knight() {}

    public Knight(int id, int initialHP, int bonusHpLevel, BattleField g, int x, int y, char c) {
        super(id, initialHP, bonusHpLevel, g, x, y, c);
    }

    /* Increases the level if needed */
    @Override
    public void increaseLevel(int level) {
        int ok = 0;
        while (this.getXp() > this.toLevelUp()) {
            this.setLevel(this.getLevel() + 1);
            ok = 1;
        }
        if (ok == 1) {
            this.setHp(Constants.INITIAL_KNIGHT_HP + this.getLevel() * Constants.KNIGHT_HP_LEVEL_BONUS);
        }
    }

    @Override
    public int getMaxHp() {
        return (Constants.INITIAL_KNIGHT_HP + Constants.KNIGHT_HP_LEVEL_BONUS * this.getLevel());
    }

    /* Returns the basic execute damage */
    public float getBasicExecuteDamage () {
        float executeDamage = Constants.EXECUTE_DAMAGE +
                Constants.EXECUTE_DAMAGE_BONUS * this.getLevel();

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'L') {
            executeDamage *= Constants.KNIGHT_LAND_PERCENT;
        }

        return executeDamage;
    }

    /* Returns the basic slam damage */
    public float getBasicSlamDamage () {
        float slamDamage = Constants.SLAM_DAMAGE +
                Constants.SLAM_DAMAGE_LEVEL_BONUS * this.getLevel();

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'L') {
            slamDamage *= Constants.KNIGHT_LAND_PERCENT;
        }

        return slamDamage;
    }

    int computeHpLimit(Player p) {
        // MAGIC NUMBER
        float hpLimit = 0.2f * p.getMaxHp() + 0.01f * this.getLevel() * p.getMaxHp();

        if (hpLimit > 0.4f * p.getMaxHp()) {
            hpLimit = 0.4f * p.getMaxHp();
        }

        return Math.round(hpLimit);
    }

    @Override
    public void battle(Pyromancer p) {
        //this.computeOvertimeDamage();

//        if (this.getStatus() == 0) {
//            return;
//        }

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

    @Override
    public void battle(Knight k) {
        // MAGIC NUMBER BAGA IN CONSTANTE!!!!!!!!
        //this.computeOvertimeDamage();

//        if (this.getStatus() == 0) {
//            return;
//        }

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

    @Override
    public void battle(Rogue r) {
        //this.computeOvertimeDamage();

//        if (this.getStatus() == 0) {
//            return;
//        }

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

        int totalDamage = basicExecuteDamageRounded + basicSlamDamageRounded;

        System.out.println(this.getType() + " " + totalDamage + " " + r.getType());
        r.setHp(r.getHp() - totalDamage);

        r.setPreviousDamage(totalDamage);

        if (r.getHp() <= 0) {
            r.setStatus(0);
            this.hasWon(r);
        }
    }

    @Override
    public void battle(Wizard w) {
        int hpLimit = this.computeHpLimit(w);

        if (w.getHp() < hpLimit) {
            w.setStatus(0);
            this.hasWon(w);
            //return;
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

        w.removeOvertimeDamage();
        w.setCanMove(0);

        totalDamage = basicExecuteDamageRounded + basicSlamDamageRounded;
        w.setHp(w.getHp() - totalDamage);

        //w.setPreviousDamage(totalDamage);

        if (w.getHp() <= 0) {
            w.setStatus(0);
            this.hasWon(w);
        }
    }

    public void accept(Fighter v) {
        v.battle(this);
    }

}
