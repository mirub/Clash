package player;

import constants.Constants;
import ground.BattleField;

public class Rogue extends Player implements Fighter, Fought {
    public Rogue() {}

    public Rogue(int id, int initialHP, int bonusHpLevel, BattleField g, int x, int y, char c) {
        super(id, initialHP, bonusHpLevel, g, x, y, c);
    }

    @Override
    public void increaseLevel(int level) {
        int ok = 0;
        while (this.getXp() > this.toLevelUp()) {
            this.setLevel(this.getLevel() + 1);
            ok = 1;
        }
        if (ok == 1) {
            this.setHp(Constants.INITIAL_ROGUE_HP + this.getLevel() * Constants.ROGUE_HP_LEVEL_BONUS);
        }
    }

    @Override
    public int getMaxHp() {
        return (Constants.INITIAL_ROGUE_HP + Constants.ROGUE_HP_LEVEL_BONUS * this.getLevel());
    }

    /* Returns the basic backstab damage */
    public float getBasicBackstabDamage () {
        float backstabDamage = Constants.BACKSTAB_DAMAGE +
                Constants.BACKSTAB_DAMAGE_LEVEL_BONUS * this.getLevel();

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'W') {
            backstabDamage *= Constants.ROGUE_WOODS_PERCENT;
        }

        return backstabDamage;
    }

    /* Returns the paralysis slam damage */
    public float getBasicParalysisDamage () {
        float paralysisDamage = Constants.PARALYSIS_DAMAGE +
                Constants.PARALYSIS_DAMAGE_LEVEL_BONUS * this.getLevel();

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'W') {
            paralysisDamage *= Constants.ROGUE_WOODS_PERCENT;
        }

        return paralysisDamage;
    }

    public void battle(Pyromancer p) {
        //this.computeOvertimeDamage();

        float basicBackstabDamage = this.getBasicBackstabDamage();
        float basicParalysisDamage = this.getBasicParalysisDamage();

        p.removeOvertimeDamage();

        basicBackstabDamage *= Constants.BACKSTAB_PYRO_PERCENT;
        basicParalysisDamage *= Constants.PARALYSIS_PYRO_PERCENT;

        if (this.getAttackCount() % 3 == 0 &&
                this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'W') {
            basicBackstabDamage *= 1.5f;
        }

        int basicBackstabDamageRounded = Math.round(basicBackstabDamage);
        int basicParalysisDamageRounded = Math.round(basicParalysisDamage);

        int totalDamage = basicBackstabDamageRounded + basicParalysisDamageRounded;
        p.setHp(p.getHp() - totalDamage);
        System.out.println(p.getHp());

        p.setPreviousDamage(totalDamage);

        p.setOvertimeDamage(basicParalysisDamageRounded);

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'W') {
            p.setOvertimeDamageRound(6);
            p.setCanMove(0);
        } else {
            p.setOvertimeDamageRound(3);
            p.setCanMove(0);
        }

        if (p.getHp() <= 0) {
            p.setStatus(0);
            this.hasWon(p);
        }
    }

    public void battle(Knight k) {

        float basicBackstabDamage = this.getBasicBackstabDamage();
        float basicParalysisDamage = this.getBasicParalysisDamage();

        basicBackstabDamage *= Constants.BACKSTAB_KNIGHT_PERCENT;
        basicParalysisDamage *= Constants.PARALYSIS_KNIGHT_PERCENT;

        if (this.getAttackCount() % 3 == 0 &&
                this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'W') {
            basicBackstabDamage *= 1.5f;
        }

        int basicBackstabDamageRounded = Math.round(basicBackstabDamage);
        int basicParalysisDamageRounded = Math.round(basicParalysisDamage);

        int totalDamage = basicBackstabDamageRounded + basicParalysisDamageRounded;
        System.out.println(this.getType() + " " + totalDamage + " " + k.getType());

        k.setHp(k.getHp() - totalDamage);

        k.removeOvertimeDamage();

        k.setPreviousDamage(totalDamage);

        k.setOvertimeDamage(basicParalysisDamageRounded);
        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'W') {
            k.setOvertimeDamageRound(6);
            k.setCanMove(0);
        } else {
            k.setOvertimeDamageRound(3);
            k.setCanMove(0);
        }

        if (k.getHp() <= 0) {
            k.setStatus(0);
            this.hasWon(k);
        }
    }

    public void battle(Rogue r) {
        //this.computeOvertimeDamage();

//        if (this.getStatus() == 0) {
//            return;
//        }
        float basicBackstabDamage = this.getBasicBackstabDamage();
        float basicParalysisDamage = this.getBasicParalysisDamage();

        r.removeOvertimeDamage();

        basicBackstabDamage *= Constants.BACKSTAB_ROGUE_PERCENT;
        basicParalysisDamage *= Constants.PARALYSIS_ROGUE_PERCENT;

        if (this.getAttackCount() % 3 == 0 &&
                this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'W') {
            basicBackstabDamage *= 1.5f;
        }

        int basicBackstabDamageRounded = Math.round(basicBackstabDamage);
        int basicParalysisDamageRounded = Math.round(basicParalysisDamage);

        int totalDamage = basicBackstabDamageRounded + basicParalysisDamageRounded;
        r.setHp(r.getHp() - totalDamage);

        r.setPreviousDamage(totalDamage);

        r.setOvertimeDamage(basicParalysisDamageRounded);
        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'W') {
            r.setOvertimeDamageRound(6);
            r.setCanMove(0);
        } else {
            r.setOvertimeDamageRound(3);
            r.setCanMove(0);
        }

        if (r.getHp() <= 0) {
            r.setStatus(0);
            this.hasWon(r);
        }
    }

    public void battle(Wizard w) {

        float basicBackstabDamage = this.getBasicBackstabDamage();
        float basicParalysisDamage = this.getBasicParalysisDamage();

        w.removeOvertimeDamage();

        if (this.getAttackCount() % 3 == 0 &&
                this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'W') {
            basicBackstabDamage *= 1.5f;
        }

        int basicBackstabDamageRounded = Math.round(basicBackstabDamage);
        int basicParalysisDamageRounded = Math.round(basicParalysisDamage);

        int totalDamage = basicBackstabDamageRounded + basicParalysisDamageRounded;
        w.setPreviousDamage(totalDamage);

        basicBackstabDamage *= Constants.BACKSTAB_WIZARD_PERCENT;
        basicParalysisDamage *= Constants.PARALYSIS_WIZARD_PERCENT;

        basicBackstabDamageRounded = Math.round(basicBackstabDamage);
        basicParalysisDamageRounded = Math.round(basicParalysisDamage);

        totalDamage = basicBackstabDamageRounded + basicParalysisDamageRounded;
        w.setHp(w.getHp() - totalDamage);

        w.setOvertimeDamage(basicParalysisDamageRounded);
        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'W') {
            w.setOvertimeDamageRound(6);
            w.setCanMove(0);
        } else {
            w.setOvertimeDamageRound(3);
            w.setCanMove(0);
        }

        if (w.getHp() <= 0) {
            w.setStatus(0);
            this.hasWon(w);
        }
    }

    public void accept(Fighter v) {
        v.battle(this);
    }

}
