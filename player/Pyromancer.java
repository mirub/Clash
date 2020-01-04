/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package player;

import angels.Angel;
import angels.AngelEffect;
import constants.Constants;
import ground.BattleField;
import magician.GreatMagician;
import main.ReadInput;
import strategy.Strategy;

public final class Pyromancer extends Player implements Fighter, Fought, AngelEffect {

    public Pyromancer() { }

    public Pyromancer(final int id, final int initialHP, final int bonusHpLevel,
                      final BattleField g, final int x, final int y, final char c) {
        super(id, initialHP, bonusHpLevel, g, x, y, c);
        this.setFireblastRoguePercent(Constants.FIREBLAST_ROGUE_PERCENT);
        this.setFireblastKnightPercent(Constants.FIREBLAST_KNIGHT_PERCENT);
        this.setFireblastPyroPercent(Constants.FIREBLAST_PYRO_PERCENT);
        this.setFireblastWizardPercent(Constants.FIREBLAST_WIZARD_PERCENT);
        this.setIgniteRoguePercent(Constants.IGNITE_ROGUE_PERCENT);
        this.setIgniteKnightPercent(Constants.IGNITE_KNIGHT_PERCENT);
        this.setIgnitePyroPercent(Constants.IGNITE_PYRO_PERCENT);
        this.setIgniteWizardPercent(Constants.IGNITE_WIZARD_PERCENT);
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
                this.setHp(Constants.INITIAL_PYRO_HP
                        + this.getLevel() * Constants.PYRO_HP_LEVEL_BONUS);
            }
        }
    }

    /* Returns the max hp per level of the current player */
    @Override
    public int getMaxHp() {
        return (Constants.INITIAL_PYRO_HP + Constants.PYRO_HP_LEVEL_BONUS * this.getLevel());
    }

    /* Returns the basic fireblast damage */
    public float getBasicFireblastDamage() {
        float fireblastDamage = Constants.FIREBLAST_DAMAGE
                + Constants.FIREBLAST_DAMAGE_BONUS * this.getLevel();

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'V') {
            fireblastDamage *= Constants.PYRO_VOLCANIC_PERCENT;
        }

        return fireblastDamage;
    }

    /* Returns the basic ignite damage */
    public float getBasicIgniteDamage() {
        float igniteDamage = Constants.IGNITE_DAMAGE_FIRST
                + Constants.IGNITE_DAMAGE_FIRST_LEVEL_BONUS * this.getLevel();

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'V') {
            igniteDamage *= Constants.PYRO_VOLCANIC_PERCENT;
        }

        return igniteDamage;
    }

    /* Returns the basic future ignite damage */
    public float getBasicFutureIgniteDamage() {
        float futureIgniteDamage = Constants.IGNITE_DAMAGE
                + Constants.IGNITE_DAMAGE_LEVEL_BONUS * this.getLevel();

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'V') {
            futureIgniteDamage *= Constants.PYRO_VOLCANIC_PERCENT;
        }

        return futureIgniteDamage;
    }

    /* Implements the fight between two Pyromancers */
    @Override
    public void battle(final Pyromancer p) {
        float fireblastDamage = this.getBasicFireblastDamage();
        float igniteDamage = this.getBasicIgniteDamage();
        float futureIgniteDamage = this.getBasicFutureIgniteDamage();

        p.removeOvertimeDamage();

        int fireblastDamageRounded = Math.round(fireblastDamage);
        int igniteDamageRounded = Math.round(igniteDamage);
        int futureIgniteDamageRounded = Math.round(futureIgniteDamage);

        fireblastDamage *= this.getFireblastPyroPercent();
        igniteDamage *= this.getIgnitePyroPercent();
        futureIgniteDamage *= this.getIgnitePyroPercent();

        fireblastDamageRounded = Math.round(fireblastDamage);
        igniteDamageRounded = Math.round(igniteDamage);
        futureIgniteDamageRounded = Math.round(futureIgniteDamage);

        p.setOvertimeDamage(futureIgniteDamageRounded);
        p.setOvertimeDamageRound(2);

        int totalDamage = fireblastDamageRounded + igniteDamageRounded;
        p.setHp(p.getHp() - totalDamage);

        p.setPreviousDamage(totalDamage);
    }

    /* Implements the fight between a Pyromancer and a Knight */
    @Override
    public void battle(final Knight k) {
        float fireblastDamage = this.getBasicFireblastDamage();
        float igniteDamage = this.getBasicIgniteDamage();
        float futureIgniteDamage = this.getBasicFutureIgniteDamage();

        k.removeOvertimeDamage();

        fireblastDamage *= this.getFireblastKnightPercent();
        igniteDamage *= this.getIgniteKnightPercent();
        futureIgniteDamage *= this.getIgniteKnightPercent();

        int fireblastDamageRounded = Math.round(fireblastDamage);
        int igniteDamageRounded = Math.round(igniteDamage);
        int futureIgniteDamageRounded = Math.round(futureIgniteDamage);

        k.setOvertimeDamage(futureIgniteDamageRounded);
        k.setOvertimeDamageRound(2);

        int totalDamage = fireblastDamageRounded + igniteDamageRounded;
        k.setHp(k.getHp() - totalDamage);

        k.setPreviousDamage(totalDamage);
    }

    /* Implements the fight between a Pyromancer and a Rogue */
    @Override
    public void battle(final Rogue r) {
        float fireblastDamage = this.getBasicFireblastDamage();
        float igniteDamage = this.getBasicIgniteDamage();
        float futureIgniteDamage = this.getBasicFutureIgniteDamage();

        r.removeOvertimeDamage();

        fireblastDamage *= this.getFireblastRoguePercent();
        igniteDamage *= this.getIgniteRoguePercent();
        futureIgniteDamage *= this.getIgniteRoguePercent();

        int fireblastDamageRounded = Math.round(fireblastDamage);
        int igniteDamageRounded = Math.round(igniteDamage);
        int futureIgniteDamageRounded = Math.round(futureIgniteDamage);

        r.setOvertimeDamage(futureIgniteDamageRounded);
        r.setOvertimeDamageRound(2);

        int totalDamage = fireblastDamageRounded + igniteDamageRounded;
        r.setHp(r.getHp() - totalDamage);

        r.setPreviousDamage(totalDamage);
    }

    /* Implements the fight between a Pyromancer and a Wizard */
    @Override
    public void battle(final Wizard w) {
        w.removeOvertimeDamage();

        float fireblastDamage = this.getBasicFireblastDamage();
        float igniteDamage = this.getBasicIgniteDamage();
        float futureIgniteDamage = this.getBasicFutureIgniteDamage();

        int fireblastDamageRounded = Math.round(fireblastDamage);
        int igniteDamageRounded = Math.round(igniteDamage);

        int totalDamage = fireblastDamageRounded + igniteDamageRounded;
        w.setPreviousDamage(totalDamage);

        fireblastDamage *= this.getFireblastWizardPercent();
        igniteDamage *= this.getIgniteWizardPercent();
        futureIgniteDamage *= this.getIgniteWizardPercent();

        fireblastDamageRounded = Math.round(fireblastDamage);
        igniteDamageRounded = Math.round(igniteDamage);
        int futureIgniteDamageRounded = Math.round(futureIgniteDamage);

        w.setOvertimeDamage(futureIgniteDamageRounded);
        w.setOvertimeDamageRound(2);

        totalDamage = fireblastDamageRounded + igniteDamageRounded;
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
