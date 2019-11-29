package player;

import constants.Constants;
import ground.BattleField;

import static java.util.Collections.min;

public class Wizard extends Player implements Fighter, Fought {
    public Wizard() {}

    public Wizard(int id, int initialHP, int bonusHpLevel, BattleField g, int x, int y, char c) {
        super(id, initialHP, bonusHpLevel, g, x, y, c);
    }

    @Override
    public void increaseLevel(int level) {
        int ok = 0;
        if (this.getXp() > this.toLevelUp()) {
            this.setLevel(this.getLevel() + 1);
            ok = 1;
        }
        if (ok == 1) {
            this.setHp(Constants.INITIAL_WIZARD_HP + this.getLevel() * Constants.WIZARD_HP_LEVEL_BONUS);
        }
    }

    @Override
    public int getMaxHp() {
        return (Constants.INITIAL_WIZARD_HP + Constants.WIZARD_HP_LEVEL_BONUS * this.getLevel());
    }

    /* Returns the basic drain damage */
    public float getBasicDrainDamage () {
        float drainDamagePercent = Constants.DRAIN_DAMAGE_PERCENT +
                Constants.DRAIN_DAMAGE_PERCENT_BONUS * this.getLevel();

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'D') {
            drainDamagePercent *= Constants.WIZARD_DESERT_PERCENT;
        }

        return drainDamagePercent;
    }

    /* Returns the basic slam damage */
    public float getBasicDeflectDamage () {
        float deflectDamagePercent = Constants.DEFLECT_DAMAGE_PERCENT+
                Constants.DEFLECT_DAMAGE_LEVEL_BONUS * this.getLevel();

        if (deflectDamagePercent > 0.7f) {
            deflectDamagePercent = 0.7f;
        }

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'D') {
            deflectDamagePercent *= Constants.WIZARD_DESERT_PERCENT;
        }

        return deflectDamagePercent;
    }

    public float getDrainDamage(Player p) {
        return Math.min(0.3f * p.toLevelUp(), p.getHp());
    }

    public void battle(Pyromancer p) {
        float drainDamagePercent = this.getBasicDrainDamage();
        float deflectDamagePercent = this.getBasicDeflectDamage();

        drainDamagePercent *= Constants.DRAIN_PYRO_PERCENT;
        deflectDamagePercent *= Constants.DEFLECT_PYRO_PERCENT;

        float basicDrainDamage = drainDamagePercent * this.getDrainDamage(p);
        float deflectDamage = deflectDamagePercent * this.getPreviousDamage();

        int basicDrainDamageRounded = Math.round(basicDrainDamage);
        int deflectDamageRounded = Math.round(deflectDamage);


        int totalDamage = basicDrainDamageRounded + deflectDamageRounded;
        p.setHp(p.getHp() - totalDamage);

        p.setPreviousDamage(totalDamage);

        if (p.getHp() <= 0) {
            p.setStatus(0);
            this.hasWon(p);
        }
    }
    public void battle(Knight k) {
        //this.computeOvertimeDamage();

//        if (this.getStatus() == 0) {
//            return;
//        }

        float drainDamagePercent = this.getBasicDrainDamage();
        float deflectDamagePercent = this.getBasicDeflectDamage();

        drainDamagePercent *= Constants.DRAIN_KNIGHT_PERCENT;
        deflectDamagePercent *= Constants.DEFLECT_KNIGHT_PERCENT;

        float basicDrainDamage = drainDamagePercent * this.getDrainDamage(k);
        float deflectDamage = deflectDamagePercent * this.getPreviousDamage();

        int basicDrainDamageRounded = Math.round(basicDrainDamage);
        int deflectDamageRounded = Math.round(deflectDamage);


        int totalDamage = basicDrainDamageRounded + deflectDamageRounded;
        k.setHp(k.getHp() - totalDamage);

        k.setPreviousDamage(totalDamage);

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

        float drainDamagePercent = this.getBasicDrainDamage();
        float deflectDamagePercent = this.getBasicDeflectDamage();

        drainDamagePercent *= Constants.DRAIN_ROGUE_PERCENT;
        deflectDamagePercent *= Constants.DEFLECT_ROGUE_PERCENT;

        float basicDrainDamage = drainDamagePercent * this.getDrainDamage(r);
        float deflectDamage = deflectDamagePercent * this.getPreviousDamage();

        int basicDrainDamageRounded = Math.round(basicDrainDamage);
        int deflectDamageRounded = Math.round(deflectDamage);


        int totalDamage = basicDrainDamageRounded + deflectDamageRounded;
        r.setHp(r.getHp() - totalDamage);

        r.setPreviousDamage(totalDamage);

        if (r.getHp() <= 0) {
            r.setStatus(0);
            this.hasWon(r);
        }
    }
    public void battle(Wizard w) {
        //this.computeOvertimeDamage();

//        if (this.getStatus() == 0) {
//            return;
//        }

        float drainDamagePercent = this.getBasicDrainDamage();
        float deflectDamagePercent = this.getBasicDeflectDamage();

        drainDamagePercent *= Constants.DRAIN_WIZARD_PERCENT;
        deflectDamagePercent *= Constants.DEFLECT_WIZARD_PERCENT;
        float basicDrainDamage = drainDamagePercent * this.getDrainDamage(w);
        float deflectDamage = deflectDamagePercent * this.getPreviousDamage();

        int basicDrainDamageRounded = Math.round(basicDrainDamage);
        int deflectDamageRounded = Math.round(deflectDamage);


        int totalDamage = basicDrainDamageRounded + deflectDamageRounded;
        w.setHp(w.getHp() - totalDamage);

        w.setPreviousDamage(totalDamage);

        if (w.getHp() <= 0) {
            w.setStatus(0);
            this.hasWon(w);
        }
    }

    public void accept(Fighter v) {
        v.battle(this);
    }

}
