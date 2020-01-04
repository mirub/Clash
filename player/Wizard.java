/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package player;

import angels.Angel;
import constants.Constants;
import ground.BattleField;
import magician.GreatMagician;
import main.ReadInput;
import strategy.Strategy;

public final class Wizard extends Player implements Fighter, Fought {

    public Wizard() { }

    public Wizard(final int id, final int initialHP, final int bonusHpLevel,
                  final BattleField g, final int x, final int y, final char c) {
        super(id, initialHP, bonusHpLevel, g, x, y, c);
        this.setDrainRoguePercent(Constants.DRAIN_ROGUE_PERCENT);
        this.setDrainKnightPercent(Constants.DRAIN_KNIGHT_PERCENT);
        this.setDrainPyroPercent(Constants.DRAIN_PYRO_PERCENT);
        this.setDrainWizardPercent(Constants.DRAIN_WIZARD_PERCENT);
        this.setDeflectRoguePercent(Constants.DEFLECT_ROGUE_PERCENT);
        this.setDeflectKnightPercent(Constants.DEFLECT_KNIGHT_PERCENT);
        this.setDeflectPyroPercent(Constants.DEFLECT_PYRO_PERCENT);
        this.setDeflectWizardPercent(Constants.DEFLECT_WIZARD_PERCENT);
    }

    /* Increases the level of the current player */
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
                this.setHp(Constants.INITIAL_WIZARD_HP + this.getLevel()
                        * Constants.WIZARD_HP_LEVEL_BONUS);
            }
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

        drainDamagePercent *= this.getDrainPyroPercent();
        deflectDamagePercent *= this.getDeflectPyroPercent();

        float basicDrainDamage = drainDamagePercent * this.getDrainDamage(p);
        float deflectDamage = deflectDamagePercent * this.getPreviousDamage();

        int basicDrainDamageRounded = Math.round(basicDrainDamage);
        int deflectDamageRounded = Math.round(deflectDamage);

        int totalDamage = basicDrainDamageRounded + deflectDamageRounded;
        p.setHp(p.getHp() - totalDamage);
        p.setPreviousDamage(totalDamage);
    }

    /* Implements the battle between a Wizard and a Knight */
    public void battle(final Knight k) {
        float drainDamagePercent = this.getBasicDrainDamage();
        float deflectDamagePercent = this.getBasicDeflectDamage();

        drainDamagePercent *= this.getDrainKnightPercent();
        deflectDamagePercent *= this.getDeflectKnightPercent();

        float basicDrainDamage = drainDamagePercent * this.getDrainDamage(k);
        float deflectDamage = deflectDamagePercent * this.getPreviousDamage();

        int basicDrainDamageRounded = Math.round(basicDrainDamage);
        int deflectDamageRounded = Math.round(deflectDamage);

        int totalDamage = basicDrainDamageRounded + deflectDamageRounded;
        k.setHp(k.getHp() - totalDamage);
        k.setPreviousDamage(totalDamage);
    }

    /* Implements the fight between a Wizard and a Rogue */
    public void battle(final Rogue r) {
        float drainDamagePercent = this.getBasicDrainDamage();
        float deflectDamagePercent = this.getBasicDeflectDamage();

        drainDamagePercent *= this.getDrainRoguePercent();
        deflectDamagePercent *= this.getDeflectRoguePercent();

        float basicDrainDamage = drainDamagePercent * this.getDrainDamage(r);
        float deflectDamage = deflectDamagePercent * this.getPreviousDamage();

        int basicDrainDamageRounded = Math.round(basicDrainDamage);
        int deflectDamageRounded = Math.round(deflectDamage);

        int totalDamage = basicDrainDamageRounded + deflectDamageRounded;
        r.setHp(r.getHp() - totalDamage);
        r.setPreviousDamage(totalDamage);
    }

    /* Implements the fight between two Wizards */
    public void battle(final Wizard w) {
        float drainDamagePercent = this.getBasicDrainDamage();
        float deflectDamagePercent = this.getBasicDeflectDamage();

        drainDamagePercent *= this.getDrainWizardPercent();
        deflectDamagePercent *= this.getDeflectWizardPercent();

        float basicDrainDamage = drainDamagePercent * this.getDrainDamage(w);
        float deflectDamage = deflectDamagePercent * this.getPreviousDamage();

        int basicDrainDamageRounded = Math.round(basicDrainDamage);
        int deflectDamageRounded = Math.round(deflectDamage);

        int totalDamage = basicDrainDamageRounded + deflectDamageRounded;
        w.setHp(w.getHp() - totalDamage);
        w.setPreviousDamage(totalDamage);
    }

    /* Accepts the attack from fighter "V" */
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
