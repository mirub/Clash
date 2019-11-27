package player;

import constants.Constants;
import ground.BattleField;

public class Pyromancer extends Player implements Fighter, Fought {
    public Pyromancer() {}

    public Pyromancer(int id, int initialHP, int bonusHpLevel, BattleField g, int x, int y) {
       super(id, initialHP, bonusHpLevel, g, x, y);
    }

    /* Computes the overtime damage */
    public void computeOvertimeDamage() {
        if (this.getIgniteDamage() > 0) {
            this.setHp(this.getHp() - this.getIgniteDamage());
            this.setIgniteDamageRound(this.getIgniteDamageRound() - 1);
        }
    }

    // VEZI REMOVE OVERTIME DAMAGE DIN PLAYER

    /* Checks if the player has won and increases its hp */
    public void hasWon(Player p) {
        if (p.getHp() == 0) {
            int newHp = this.getXp() + Math.max(0, 200 - (this.getLevel() - p.getLevel()) * 40);
            this.setHp(newHp);
        }
    }

    /* Increases the level if needed */
    public void increaseLevel(int level) {
        int levelHp = this.toLevelUp();
        // SEE HERE
        if (this.getHp() > levelHp) {
            this.setHp(Constants.INITIAL_PYRO_HP + this.getLevel() * Constants.PYRO_HP_LEVEL_BONUS);
            this.setLevel(this.getLevel() + 1);
        }
    }

// IMPLEMENTEAZA VISIT GENERIC !!!!!! NU MERGE STAI

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
    public void battle(Pyromancer p) {
        this.computeOvertimeDamage();

        float fireblastDamage = this.getBasicFireblastDamage();
        float igniteDamage = this.getBasicIgniteDamage();
        float futureIgniteDamage = this.getBasicFutureIgniteDamage();

        p.removeOvertimeDamage();

        fireblastDamage *= Constants.FIREBLAST_PYRO_PERCENT;
        igniteDamage *= Constants.IGNITE_PYRO_PERCENT;
        futureIgniteDamage *= Constants.IGNITE_PYRO_PERCENT;

        int fireblastDamageRounded = Math.round(fireblastDamage);
        int igniteDamageRounded = Math.round(igniteDamage);
        int futureIgniteDamageRounded = Math.round(futureIgniteDamage);

        p.setIgniteDamage(futureIgniteDamageRounded);
        p.setIgniteDamageRound(2);

        int totalDamage = fireblastDamageRounded + igniteDamageRounded;
        p.setHp(p.getHp() - totalDamage);
    }

    /* Implements the fight between the current player and a Knight */
    public void battle(Knight k) {
        this.computeOvertimeDamage();

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

        k.setIgniteDamage(futureIgniteDamageRounded);
        k.setIgniteDamageRound(2);

        int totalDamage = fireblastDamageRounded + igniteDamageRounded;
        k.setHp(k.getHp() - totalDamage);
    }

    /* Implements the fight between the current player and a Rogue */
    public void battle(Rogue r) {
        this.computeOvertimeDamage();

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

        r.setIgniteDamage(futureIgniteDamageRounded);
        r.setIgniteDamageRound(2);

        int totalDamage = fireblastDamageRounded + igniteDamageRounded;
        r.setHp(r.getHp() - totalDamage);
    }
    /* Implements the fight between the current player and a Wizard */
    public void battle(Wizard w) {
        this.computeOvertimeDamage();

        float fireblastDamage = this.getBasicFireblastDamage();
        float igniteDamage = this.getBasicIgniteDamage();
        float futureIgniteDamage = this.getBasicFutureIgniteDamage();

        w.removeOvertimeDamage();

        fireblastDamage *= Constants.FIREBLAST_WIZARD_PERCENT;
        igniteDamage *= Constants.IGNITE_WIZARD_PERCENT;
        futureIgniteDamage *= Constants.IGNITE_WIZARD_PERCENT;

        int fireblastDamageRounded = Math.round(fireblastDamage);
        int igniteDamageRounded = Math.round(igniteDamage);
        int futureIgniteDamageRounded = Math.round(futureIgniteDamage);

        w.setIgniteDamage(futureIgniteDamageRounded);
        w.setIgniteDamageRound(2);

        int totalDamage = fireblastDamageRounded + igniteDamageRounded;
        w.setHp(w.getHp() - totalDamage);
    }

    public void accept(Fighter v) {
        v.battle(this);
    }

}
