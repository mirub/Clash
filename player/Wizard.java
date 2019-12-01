/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package player;

import constants.Constants;
import ground.BattleField;

public final class Wizard extends Player implements Fighter, Fought {
    public Wizard() { }

    public Wizard(final int id, final int initialHP, final int bonusHpLevel,
                  final BattleField g, final int x, final int y, final char c) {
        super(id, initialHP, bonusHpLevel, g, x, y, c);
    }

    /* Increases the level of the current player */
    @Override
    public void increaseLevel(final int level) {
        int ok = 0;
        while (this.getXp() >= this.toLevelUp()) {
            this.setLevel(this.getLevel() + 1);
            ok = 1;
        }
        if (ok == 1) {
            this.setHp(Constants.INITIAL_WIZARD_HP + this.getLevel()
                    * Constants.WIZARD_HP_LEVEL_BONUS);
        }
    }

    /* Returns the max hp per level of the current player */
    @Override
    public int getMaxHp() {
        return (Constants.INITIAL_WIZARD_HP + Constants.WIZARD_HP_LEVEL_BONUS * this.getLevel());
    }

    /* Returns the basic drain damage percent */
    public float getBasicDrainDamage() {
        float drainDamagePercent = Constants.DRAIN_DAMAGE_PERCENT
                + Constants.DRAIN_DAMAGE_PERCENT_BONUS * this.getLevel();

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'D') {
            drainDamagePercent *= Constants.WIZARD_DESERT_PERCENT;
        }
        return drainDamagePercent;
    }

    /* Returns the basic slam damage percent */
    public float getBasicDeflectDamage() {
        float deflectDamagePercent = Constants.DEFLECT_DAMAGE_PERCENT
                + Constants.DEFLECT_DAMAGE_LEVEL_BONUS * this.getLevel();

        if (deflectDamagePercent > Constants.WIZARD_MAX_DEFLECT_PERCENT) {
            deflectDamagePercent = Constants.WIZARD_MAX_DEFLECT_PERCENT;
        }

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'D') {
            deflectDamagePercent *= Constants.WIZARD_DESERT_PERCENT;
        }

        return deflectDamagePercent;
    }

    /* Returns the basic drain damage */
    public float getDrainDamage(final Player p) {
        return Math.min(Constants.WIZARD_DRAIN_PERCENT * p.getMaxHp(), p.getHp());
    }

    /* Implements the battle between a Wizard and a Pyromancer */
    public void battle(final Pyromancer p) {
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

    /* Implements the battle between a Wizard and a Knight */
    public void battle(final Knight k) {
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

    /* Implements the fight between a Wizard and a Rogue */
    public void battle(final Rogue r) {
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

    /* Implements the fight between two Wizards */
    public void battle(final Wizard w) {
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

    /* Accepts the attack from fighter "V" */
    public void accept(final Fighter v) {
        v.battle(this);
    }
}
