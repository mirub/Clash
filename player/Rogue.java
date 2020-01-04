/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package player;

import angels.Angel;
import constants.Constants;
import ground.BattleField;
import magician.GreatMagician;
import main.ReadInput;
import strategy.Strategy;

public final class Rogue extends Player implements Fighter, Fought {

    public Rogue() { }

    public Rogue(final int id, final int initialHP, final int bonusHpLevel,
                 final BattleField g, final int x, final int y, final char c) {
        super(id, initialHP, bonusHpLevel, g, x, y, c);
        this.setBackstabRoguePercent(Constants.BACKSTAB_ROGUE_PERCENT);
        this.setBackstabKnightPercent(Constants.BACKSTAB_KNIGHT_PERCENT);
        this.setBackstabPyroPercent(Constants.BACKSTAB_PYRO_PERCENT);
        this.setBackstabWizardPercent(Constants.BACKSTAB_WIZARD_PERCENT);
        this.setParalysisRoguePercent(Constants.PARALYSIS_ROGUE_PERCENT);
        this.setParalysisKnightPercent(Constants.PARALYSIS_KNIGHT_PERCENT);
        this.setParalysisPyroPercent(Constants.PARALYSIS_PYRO_PERCENT);
        this.setParalysisWizardPercent(Constants.PARALYSIS_WIZARD_PERCENT);
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
                this.setHp(Constants.INITIAL_ROGUE_HP
                        + this.getLevel() * Constants.ROGUE_HP_LEVEL_BONUS);
            }
        }
    }

    /* Returns the maximum hp per level of the current player */
    @Override
    public int getMaxHp() {
        return (Constants.INITIAL_ROGUE_HP + Constants.ROGUE_HP_LEVEL_BONUS * this.getLevel());
    }

    /* Returns the basic backstab damage */
    public float getBasicBackstabDamage() {
        float backstabDamage = Constants.BACKSTAB_DAMAGE
                + Constants.BACKSTAB_DAMAGE_LEVEL_BONUS * this.getLevel();

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'W') {
            backstabDamage *= Constants.ROGUE_WOODS_PERCENT;
        }
        return backstabDamage;
    }

    /* Returns the paralysis slam damage */
    public float getBasicParalysisDamage() {
        float paralysisDamage = Constants.PARALYSIS_DAMAGE
                + Constants.PARALYSIS_DAMAGE_LEVEL_BONUS * this.getLevel();

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'W') {
            paralysisDamage *= Constants.ROGUE_WOODS_PERCENT;
        }
        return paralysisDamage;
    }

    /* Implements the battle between a Rogue and a Pyromancer*/
    public void battle(final Pyromancer p) {
        float basicBackstabDamage = this.getBasicBackstabDamage();
        float basicParalysisDamage = this.getBasicParalysisDamage();

        p.removeOvertimeDamage();

        basicBackstabDamage *= this.getBackstabPyroPercent();
        basicParalysisDamage *= this.getParalysisPyroPercent();

        if (this.getAttackCount() % Constants.ROUND_NUMBER_BONUS == 0
                && this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'W') {
            basicBackstabDamage *= Constants.WOODS_DAMAGE_MULTIPLIER;
        }

        int basicBackstabDamageRounded = Math.round(basicBackstabDamage);
        int basicParalysisDamageRounded = Math.round(basicParalysisDamage);

        int totalDamage = basicBackstabDamageRounded + basicParalysisDamageRounded;
        p.setHp(p.getHp() - totalDamage);
        p.setPreviousDamage(totalDamage);

        p.setOvertimeDamage(basicParalysisDamageRounded);

        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'W') {
            p.setImmobilityRound(Constants.WOODS_IMMOBILITY_ROUNDS);
            p.setOvertimeDamageRound(Constants.WOODS_IMMOBILITY_ROUNDS);
            p.setCanMove(0);
        } else {
            p.setImmobilityRound(Constants.STANDARD_IMMOBILITY_ROUNDS);
            p.setOvertimeDamageRound(Constants.STANDARD_IMMOBILITY_ROUNDS);
            p.setCanMove(0);
        }
    }

    /* Implements the fight between a Rogue and a Knight */
    public void battle(final Knight k) {
        float basicBackstabDamage = this.getBasicBackstabDamage();
        float basicParalysisDamage = this.getBasicParalysisDamage();

        basicBackstabDamage *= this.getBackstabKnightPercent();
        basicParalysisDamage *= this.getParalysisKnightPercent();

        if (this.getAttackCount() % Constants.ROUND_NUMBER_BONUS == 0
                && this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'W') {
            basicBackstabDamage *= Constants.WOODS_DAMAGE_MULTIPLIER;
        }

        int basicBackstabDamageRounded = Math.round(basicBackstabDamage);
        int basicParalysisDamageRounded = Math.round(basicParalysisDamage);

        int totalDamage = basicBackstabDamageRounded + basicParalysisDamageRounded;
        k.setHp(k.getHp() - totalDamage);
        k.setPreviousDamage(totalDamage);
        k.removeOvertimeDamage();

        k.setOvertimeDamage(basicParalysisDamageRounded);
        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'W') {
            k.setImmobilityRound(Constants.WOODS_IMMOBILITY_ROUNDS);
            k.setOvertimeDamageRound(Constants.WOODS_IMMOBILITY_ROUNDS);
            k.setCanMove(0);
        } else {
            k.setImmobilityRound(Constants.STANDARD_IMMOBILITY_ROUNDS);
            k.setOvertimeDamageRound(Constants.STANDARD_IMMOBILITY_ROUNDS);
            k.setCanMove(0);
        }
    }

    /* Implements the fight between two Rogues */
    public void battle(final Rogue r) {
        float basicBackstabDamage = this.getBasicBackstabDamage();
        float basicParalysisDamage = this.getBasicParalysisDamage();

        r.removeOvertimeDamage();

        basicBackstabDamage *= this.getBackstabRoguePercent();
        basicParalysisDamage *= this.getParalysisRoguePercent();

        if (this.getAttackCount() % Constants.ROUND_NUMBER_BONUS == 0
                && this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'W') {
            basicBackstabDamage *= Constants.WOODS_DAMAGE_MULTIPLIER;
        }

        int basicBackstabDamageRounded = Math.round(basicBackstabDamage);
        int basicParalysisDamageRounded = Math.round(basicParalysisDamage);

        int totalDamage = basicBackstabDamageRounded + basicParalysisDamageRounded;
        r.setHp(r.getHp() - totalDamage);

        r.setPreviousDamage(totalDamage);

        r.setOvertimeDamage(basicParalysisDamageRounded);
        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'W') {
            r.setImmobilityRound(Constants.WOODS_IMMOBILITY_ROUNDS);
            r.setOvertimeDamageRound(Constants.WOODS_IMMOBILITY_ROUNDS);
            r.setCanMove(0);
        } else {
            r.setImmobilityRound(Constants.STANDARD_IMMOBILITY_ROUNDS);
            r.setOvertimeDamageRound(Constants.STANDARD_IMMOBILITY_ROUNDS);
            r.setCanMove(0);
        }
    }

    /* Implements the fight between a Rogue and a Wizard*/
    public void battle(final Wizard w) {
        w.removeOvertimeDamage();

        float basicBackstabDamage = this.getBasicBackstabDamage();
        float basicParalysisDamage = this.getBasicParalysisDamage();

        if (this.getAttackCount() % Constants.ROUND_NUMBER_BONUS == 0
                && this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'W') {
            basicBackstabDamage *= Constants.WOODS_DAMAGE_MULTIPLIER;
        }

        int basicBackstabDamageRounded = Math.round(basicBackstabDamage);
        int basicParalysisDamageRounded = Math.round(basicParalysisDamage);

        int totalDamage = basicBackstabDamageRounded + basicParalysisDamageRounded;
        w.setPreviousDamage(totalDamage);

        basicBackstabDamage *= this.getBackstabWizardPercent();
        basicParalysisDamage *= this.getParalysisWizardPercent();

        basicBackstabDamageRounded = Math.round(basicBackstabDamage);
        basicParalysisDamageRounded = Math.round(basicParalysisDamage);

        totalDamage = basicBackstabDamageRounded + basicParalysisDamageRounded;
        w.setHp(w.getHp() - totalDamage);

        w.setOvertimeDamage(basicParalysisDamageRounded);
        if (this.getGround().getGround().get(this.getCurrentX()).charAt(this.getCurrentY())
                == 'W') {
            w.setImmobilityRound(Constants.WOODS_IMMOBILITY_ROUNDS);
            w.setOvertimeDamageRound(Constants.WOODS_IMMOBILITY_ROUNDS);
            w.setCanMove(0);
        } else {
            w.setImmobilityRound(Constants.STANDARD_IMMOBILITY_ROUNDS);
            w.setOvertimeDamageRound(Constants.STANDARD_IMMOBILITY_ROUNDS);
            w.setCanMove(0);
        }
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
