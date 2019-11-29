package player;

import constants.Constants;
import ground.BattleField;

public class Pyromancer extends Player implements Fighter, Fought {
    public Pyromancer() {}

    public Pyromancer(int id, int initialHP, int bonusHpLevel, BattleField g, int x, int y, char c) {
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
            this.setHp(Constants.INITIAL_PYRO_HP + this.getLevel() * Constants.PYRO_HP_LEVEL_BONUS);
        }
    }

    @Override
    public int getMaxHp() {
        return (Constants.INITIAL_PYRO_HP + Constants.PYRO_HP_LEVEL_BONUS * this.getLevel());
    }

    /* Returns the basic fireblast damage */
    public float getBasicFireblastDamage () {
        float fireblastDamage = Constants.FIREBLAST_DAMAGE +
                Constants.FIREBLAST_DAMAGE_BONUS * this.getLevel();

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'V') {
            fireblastDamage *= Constants.PYRO_VOLCANIC_PERCENT;
        }

        return fireblastDamage;
    }

    /* Returns the basic ignite damage */
    public float getBasicIgniteDamage () {
        float igniteDamage = Constants.IGNITE_DAMAGE_FIRST +
                Constants.IGNITE_DAMAGE_FIRST_LEVEL_BONUS * this.getLevel();

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'V') {
            igniteDamage *= Constants.PYRO_VOLCANIC_PERCENT;
        }

        return igniteDamage;
    }

    /* Returns the basic future ignite damage */
    public float getBasicFutureIgniteDamage () {
        float futureIgniteDamage = Constants.IGNITE_DAMAGE +
                Constants.IGNITE_DAMAGE_LEVEL_BONUS * this.getLevel();

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY()) == 'V') {
            futureIgniteDamage *= Constants.PYRO_VOLCANIC_PERCENT;
        }

        return futureIgniteDamage;
    }

    /* Implements the fight between the current player and a Pyromancer */
    @Override
    public void battle(Pyromancer p) {
        //this.computeOvertimeDamage();

//        if (this.getStatus() == 0) {
//            return;
//        }

        float fireblastDamage = this.getBasicFireblastDamage();
        float igniteDamage = this.getBasicIgniteDamage();
        float futureIgniteDamage = this.getBasicFutureIgniteDamage();

        p.removeOvertimeDamage();

        int fireblastDamageRounded = Math.round(fireblastDamage);
        int igniteDamageRounded = Math.round(igniteDamage);
        int futureIgniteDamageRounded = Math.round(futureIgniteDamage);

        fireblastDamage *= Constants.FIREBLAST_PYRO_PERCENT;
        igniteDamage *= Constants.IGNITE_PYRO_PERCENT;
        futureIgniteDamage *= Constants.IGNITE_PYRO_PERCENT;

        fireblastDamageRounded = Math.round(fireblastDamage);
        igniteDamageRounded = Math.round(igniteDamage);
        futureIgniteDamageRounded = Math.round(futureIgniteDamage);

        p.setOvertimeDamage(futureIgniteDamageRounded);
        p.setOvertimeDamageRound(2);

        int totalDamage = fireblastDamageRounded + igniteDamageRounded;
        p.setHp(p.getHp() - totalDamage);

        p.setPreviousDamage(totalDamage);

        if (p.getHp() <= 0) {
            p.setStatus(0);
            this.hasWon(p);
        }
    }

    /* Implements the fight between the current player and a Knight */
    @Override
    public void battle(Knight k) {
        //this.computeOvertimeDamage();

//        if (this.getStatus() == 0) {
//            return;
//        }

        float fireblastDamage = this.getBasicFireblastDamage();
        float igniteDamage = this.getBasicIgniteDamage();
        float futureIgniteDamage = this.getBasicFutureIgniteDamage();

        k.removeOvertimeDamage();

        fireblastDamage *= Constants.FIREBLAST_KNIGHT_PERCENT;
        igniteDamage *= Constants.IGNITE_KNIGHT_PERCENT;
        futureIgniteDamage *= Constants.IGNITE_KNIGHT_PERCENT;

        int fireblastDamageRounded = Math.round(fireblastDamage);
        int igniteDamageRounded = Math.round(igniteDamage);
        int futureIgniteDamageRounded = Math.round(futureIgniteDamage);

        k.setOvertimeDamage(futureIgniteDamageRounded);
        k.setOvertimeDamageRound(2);

        int totalDamage = fireblastDamageRounded + igniteDamageRounded;
        k.setHp(k.getHp() - totalDamage);

        k.setPreviousDamage(totalDamage);

        if (k.getHp() <= 0) {
            k.setStatus(0);
            this.hasWon(k);
        }
    }

    /* Implements the fight between the current player and a Rogue */
    @Override
    public void battle(Rogue r) {
        //this.computeOvertimeDamage();

//        if (this.getStatus() == 0) {
//            return;
//        }

        float fireblastDamage = this.getBasicFireblastDamage();
        float igniteDamage = this.getBasicIgniteDamage();
        float futureIgniteDamage = this.getBasicFutureIgniteDamage();

        r.removeOvertimeDamage();

        fireblastDamage *= Constants.FIREBLAST_ROGUE_PERCENT;
        igniteDamage *= Constants.IGNITE_ROGUE_PERCENT;
        futureIgniteDamage *= Constants.IGNITE_ROGUE_PERCENT;

        int fireblastDamageRounded = Math.round(fireblastDamage);
        int igniteDamageRounded = Math.round(igniteDamage);
        int futureIgniteDamageRounded = Math.round(futureIgniteDamage);

        r.setOvertimeDamage(futureIgniteDamageRounded);
        r.setOvertimeDamageRound(2);

        int totalDamage = fireblastDamageRounded + igniteDamageRounded;
        r.setHp(r.getHp() - totalDamage);

        r.setPreviousDamage(totalDamage);

        if (r.getHp() <= 0) {
            r.setStatus(0);
            this.hasWon(r);
        }
    }

    /* Implements the fight between the current player and a Wizard */
    @Override
    public void battle(Wizard w) {

        float fireblastDamage = this.getBasicFireblastDamage();
        float igniteDamage = this.getBasicIgniteDamage();
        float futureIgniteDamage = this.getBasicFutureIgniteDamage();

        int fireblastDamageRounded = Math.round(fireblastDamage);
        int igniteDamageRounded = Math.round(igniteDamage);

        int totalDamage = fireblastDamageRounded + igniteDamageRounded;
        w.setPreviousDamage(totalDamage);

        w.removeOvertimeDamage();

        fireblastDamage *= Constants.FIREBLAST_WIZARD_PERCENT;
        igniteDamage *= Constants.IGNITE_WIZARD_PERCENT;
        futureIgniteDamage *= Constants.IGNITE_WIZARD_PERCENT;

        fireblastDamageRounded = Math.round(fireblastDamage);
        igniteDamageRounded = Math.round(igniteDamage);
        int futureIgniteDamageRounded = Math.round(futureIgniteDamage);

        w.setOvertimeDamage(futureIgniteDamageRounded);
        w.setOvertimeDamageRound(2);

        totalDamage = fireblastDamageRounded + igniteDamageRounded;
        w.setHp(w.getHp() - totalDamage);

        if (w.getHp() <= 0) {
            w.setStatus(0);
            this.hasWon(w);
        }
    }

    public void accept(Fighter v) {
        v.battle(this);
    }

}
