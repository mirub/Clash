/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package constants;

public final class Constants {
    private Constants() { }

    /* Player constants: */

    public static final int STANDARD_LEVEL_XP = 250;
    public static final int BONUS_LEVEL_XP = 50;
    public static final int MAX_WINNER_HP = 200;
    public static final int WINNER_HP_MULTIPLIER = 40;
    public static final int CREATE_NUMBER = 10;

    /* Pyromancer constants: */

    public static final int INITIAL_PYRO_HP = 500;
    public static final int PYRO_HP_LEVEL_BONUS = 50;

    public static final float FIREBLAST_DAMAGE = 350f;
    public static final float FIREBLAST_DAMAGE_BONUS = 50f;
    public static final float FIREBLAST_ROGUE_PERCENT = 0.8f;
    public static final float FIREBLAST_KNIGHT_PERCENT = 1.2f;
    public static final float FIREBLAST_PYRO_PERCENT = 0.9f;
    public static final float FIREBLAST_WIZARD_PERCENT = 1.05f;

    public static final float IGNITE_DAMAGE_FIRST = 150f;
    public static final float IGNITE_DAMAGE_FIRST_LEVEL_BONUS = 20f;
    public static final float IGNITE_DAMAGE = 50f;
    public static final float IGNITE_DAMAGE_LEVEL_BONUS = 30f;
    public static final float IGNITE_ROGUE_PERCENT = 0.8f;
    public static final float IGNITE_KNIGHT_PERCENT = 1.2f;
    public static final float IGNITE_PYRO_PERCENT = 0.9f;
    public static final float IGNITE_WIZARD_PERCENT = 1.05f;

    public static final float PYRO_VOLCANIC_PERCENT = 1.25f;

    /* Knight constants: */

    public static final int INITIAL_KNIGHT_HP = 900;
    public static final int KNIGHT_HP_LEVEL_BONUS = 80;

    public static final float EXECUTE_DAMAGE = 200f;
    public static final float EXECUTE_DAMAGE_BONUS = 30f;
    public static final float EXECUTE_ROGUE_PERCENT = 1.15f;
    public static final float EXECUTE_KNIGHT_PERCENT = 1f;
    public static final float EXECUTE_PYRO_PERCENT = 1.1f;
    public static final float EXECUTE_WIZARD_PERCENT = 0.8f;

    public static final float SLAM_DAMAGE = 100f;
    public static final float SLAM_DAMAGE_LEVEL_BONUS = 40f;
    public static final float SLAM_ROGUE_PERCENT = 0.8f;
    public static final float SLAM_KNIGHT_PERCENT = 1.2f;
    public static final float SLAM_PYRO_PERCENT = 0.9f;
    public static final float SLAM_WIZARD_PERCENT = 1.05f;

    public static final float KNIGHT_LAND_PERCENT = 1.15f;

    public static final float MAX_KNIGHT_HP_LIMIT = 0.4f;
    public static final float KNIGHT_OPPONENT_PERCENT_HP = 0.2f;
    public static final float OPPONENT_HP_MULTIPLIER = 0.01f;

    /* Wizard constants: */

    public static final int INITIAL_WIZARD_HP = 400;
    public static final int WIZARD_HP_LEVEL_BONUS = 30;

    public static final float DRAIN_DAMAGE_PERCENT = 0.2f;
    public static final float DRAIN_DAMAGE_PERCENT_BONUS = 0.05f;
    public static final float DRAIN_ROGUE_PERCENT = 0.8f;
    public static final float DRAIN_KNIGHT_PERCENT = 1.2f;
    public static final float DRAIN_PYRO_PERCENT = 0.9f;
    public static final float DRAIN_WIZARD_PERCENT = 1.05f;

    public static final float DEFLECT_DAMAGE_PERCENT = 0.35f;
    public static final float DEFLECT_DAMAGE_LEVEL_BONUS = 0.02f;
    public static final float DEFLECT_ROGUE_PERCENT = 1.2f;
    public static final float DEFLECT_KNIGHT_PERCENT = 1.4f;
    public static final float DEFLECT_PYRO_PERCENT = 1.3f;
    public static final float DEFLECT_WIZARD_PERCENT = 0f;

    public static final float WIZARD_DESERT_PERCENT = 1.10f;

    public static final float WIZARD_MAX_DEFLECT_PERCENT = 0.7f;
    public static final float WIZARD_DRAIN_PERCENT = 0.3f;

    /* Rogue constants: */

    public static final int INITIAL_ROGUE_HP = 600;
    public static final int ROGUE_HP_LEVEL_BONUS = 40;

    public static final float BACKSTAB_DAMAGE = 200f;
    public static final float BACKSTAB_DAMAGE_LEVEL_BONUS = 20f;
    public static final float BACKSTAB_ROGUE_PERCENT = 1.2f;
    public static final float BACKSTAB_KNIGHT_PERCENT = 0.9f;
    public static final float BACKSTAB_PYRO_PERCENT = 1.25f;
    public static final float BACKSTAB_WIZARD_PERCENT = 1.25f;

    public static final float PARALYSIS_DAMAGE = 40f;
    public static final float PARALYSIS_DAMAGE_LEVEL_BONUS = 10f;
    public static final float PARALYSIS_ROGUE_PERCENT = 0.9f;
    public static final float PARALYSIS_KNIGHT_PERCENT = 0.8f;
    public static final float PARALYSIS_PYRO_PERCENT = 1.2f;
    public static final float PARALYSIS_WIZARD_PERCENT = 1.25f;

    public static final int STANDARD_IMMOBILITY_ROUNDS = 3;
    public static final int WOODS_IMMOBILITY_ROUNDS = 6;
    public static final int ROUND_NUMBER_BONUS = 3;
    public static final float WOODS_DAMAGE_MULTIPLIER = 1.5f;

    public static final float ROGUE_WOODS_PERCENT = 1.15f;

    /* DamageAngel constants: */

    public static final float KNIGHT_DA_RAISE = 0.15f;
    public static final float PYRO_DA_RAISE = 0.20f;
    public static final float ROGUE_DA_RAISE = 0.30f;
    public static final float WIZARD_DA_RAISE = 0.40f;

    /* DarkAngel constants: */
    public static final int KNIGHT_DA_SUBSTRACT = 40;
    public static final int PYRO_DA_SUBSTRACT = 30;
    public static final int ROGUE_DA_SUBSTRACT = 10;
    public static final int WIZARD_DA_SUBSTRACT = 20;

    /* Dracula constants: */
    public static final float KNIGHT_DRACULA_SUB = 0.20f;
    public static final int KNIGHT_DRACULA_HP_SUB = 60;

    public static final float PYRO_DRACULA_SUB = 0.30f;
    public static final int PYRO_DRACULA_HP_SUB = 40;

    public static final float ROGUE_DRACULA_SUB = 0.10f;
    public static final int ROGUE_DRACULA_HP_SUB = 35;

    public static final float WIZARD_DRACULA_SUB = 0.40f;
    public static final int WIZARD_DRACULA_HP_SUB = 20;

    /* GoodBoy constants: */
    public static final float KNIGHT_GB_RAISE = 0.40f;
    public static final int KNIGHT_GB_HP_RAISE = 20;

    public static final float PYRO_GB_RAISE = 0.50f;
    public static final int PYRO_GB_HP_RAISE = 30;

    public static final float ROGUE_GB_RAISE = 0.40f;
    public static final int ROGUE_GB_HP_RAISE = 40;

    public static final float WIZARD_GB_RAISE = 0.30f;
    public static final int WIZARD_GB_HP_RAISE = 50;

    /* LevelUpAngel constants: */
    public static final float KNIGHT_LA_RAISE = 0.10f;
    public static final float PYRO_LA_RAISE = 0.20f;
    public static final float ROGUE_LA_RAISE = 0.15f;
    public static final float WIZARD_LA_RAISE = 0.25f;

    /* LifeGiver constants: */
    public static final int KNIGHT_LG_HP_RAISE = 100;
    public static final int PYRO_LG_HP_RAISE = 80;
    public static final int ROGUE_LG_HP_RAISE = 90;
    public static final int WIZARD_LG_HP_RAISE = 120;

    /* SmallAngel constants: */
    public static final float KNIGHT_SA_RAISE = 0.10f;
    public static final int KNIGHT_SA_HP_RAISE = 10;

    public static final float PYRO_SA_RAISE = 0.15f;
    public static final int PYRO_SA_HP_RAISE = 15;

    public static final float ROGUE_SA_RAISE = 0.05f;
    public static final int ROGUE_SA_HP_RAISE = 20;

    public static final float WIZARD_SA_RAISE = 0.10f;
    public static final int WIZARD_SA_HP_RAISE = 25;

    /* Spawner constants: */
    public static final int KNIGHT_SPAWN_HP = 200;
    public static final int PYRO_SPAWN_HP = 150;
    public static final int ROGUE_SPAWN_HP = 180;
    public static final int WIZARD_SPAWN_HP = 120;

    /* XPAngel constants: */
    public static final int KNIGHT_XA_XP = 45;
    public static final int PYRO_XA_XP = 50;
    public static final int ROGUE_XA_XP = 40;
    public static final int WIZARD_XA_XP = 60;

    /* Knight Damage Strategy */
    public static final int KNIGHT_DMG_HP_LOW = 3;
    public static final int KNIGHT_DMG_HP_HIGH = 2;
    public static final int KNIGHT_DMG_HP_SUB = 5;
    public static final float KNIGHT_DMG_COEF_RAISE = 0.5f;

    /* Knight Protect Strategy */
    public static final int KNIGHT_PRT_HP_LOW = 3;
    public static final int KNIGHT_PRT_HP_RAISE = 4;
    public static final float KNIGHT_PRT_COEF_SUB = 0.2f;

    /* Pyromancer Damage Strategy */
    public static final int PYRO_DMG_HP_LOW = 4;
    public static final int PYRO_DMG_HP_HIGH = 3;
    public static final int PYRO_DMG_HP_SUB = 4;
    public static final float PYRO_DMG_COEF_RAISE = 0.7f;

    /* Pyromancer Protect Strategy */
    public static final int PYRO_PRT_HP_LOW = 4;
    public static final int PYRO_PRT_HP_RAISE = 3;
    public static final float PYRO_PRT_COEF_SUB = 0.3f;

    /* Rogue Damage Strategy */
    public static final int ROGUE_DMG_HP_LOW = 7;
    public static final int ROGUE_DMG_HP_HIGH = 5;
    public static final int ROGUE_DMG_HP_SUB = 7;
    public static final float ROGUE_DMG_COEF_RAISE = 0.4f;

    /* Rogue Protect Strategy */
    public static final int ROGUE_PRT_HP_LOW = 7;
    public static final int ROGUE_PRT_HP_RAISE = 2;
    public static final float ROGUE_PRT_COEF_SUB = 0.1f;

    /* Wizard Damage Strategy */
    public static final int WIZARD_DMG_HP_LOW = 4;
    public static final int WIZARD_DMG_HP_HIGH = 2;
    public static final int WIZARD_DMG_HP_SUB = 10;
    public static final float WIZARD_DMG_COEF_RAISE = 0.6f;

    /* Wizard Protect Strategy */
    public static final int WIZARD_PRT_HP_LOW = 4;
    public static final int WIZARD_PRT_HP_RAISE = 5;
    public static final float WIZARD_PRT_COEF_SUB = 0.2f;
}
