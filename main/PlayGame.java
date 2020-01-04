/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package main;

import angels.Angel;
import angels.AngelFactory;
import angels.AngelType;
import constants.Constants;
import ground.BattleField;
import magician.GreatMagician;
import player.Player;
import player.PlayerType;
import player.PlayerFactory;
import strategy.WizardProtectStrategy;
import strategy.WizardDamageStrategy;
import strategy.RogueDamageStrategy;
import strategy.RogueProtectStrategy;
import strategy.PyromancerDamageStrategy;
import strategy.PyromancerProtectStrategy;
import strategy.KnightDamageStrategy;
import strategy.KnightProtectStrategy;
import java.util.ArrayList;
import java.util.List;

public final class PlayGame {
    private static PlayGame instance = null;

    private PlayGame() { }

    public static PlayGame getInstance() {
        if (instance == null) {
            instance = new PlayGame();
        }
        return instance;
    }

    /* Returns the array of players */
    public ArrayList<Player> getPlayersArray(final GameInput gameInput, final BattleField g,
                                             final PlayerFactory factory) {
        ArrayList<Player> gamePlayers = new ArrayList<Player>();
        List<String> beginningPlayers = gameInput.getPlayers();
        ArrayList<ArrayList<Integer>> beginningPositions = gameInput.getPositions();
        for (int i = 0; i < beginningPlayers.size(); ++i) {
            char c = beginningPlayers.get(i).charAt(0);
            switch (c) {
                case 'P':
                    gamePlayers.add(factory.getPlayerType(PlayerType.PYRO, i,
                            Constants.INITIAL_PYRO_HP, Constants.PYRO_HP_LEVEL_BONUS,
                            g, beginningPositions.get(i).get(0), beginningPositions.get(i).get(1),
                            'P'));
                    break;
                case 'R':
                    gamePlayers.add(factory.getPlayerType(PlayerType.ROGUE, i,
                            Constants.INITIAL_ROGUE_HP, Constants.ROGUE_HP_LEVEL_BONUS,
                            g, beginningPositions.get(i).get(0), beginningPositions.get(i).get(1),
                            'R'));
                    break;
                case 'K':
                    gamePlayers.add(factory.getPlayerType(PlayerType.KNIGHT, i,
                            Constants.INITIAL_KNIGHT_HP, Constants.KNIGHT_HP_LEVEL_BONUS,
                            g, beginningPositions.get(i).get(0), beginningPositions.get(i).get(1),
                            'K'));
                    break;
                case 'W':
                    gamePlayers.add(factory.getPlayerType(PlayerType.WIZARD, i,
                            Constants.INITIAL_WIZARD_HP, Constants.WIZARD_HP_LEVEL_BONUS,
                            g, beginningPositions.get(i).get(0), beginningPositions.get(i).get(1),
                            'W'));
                    break;
                default:
                    break;
            }
        }
        return gamePlayers;
    }

    /* Returns the array of players */
    public ArrayList<Angel> getAngelsArray(final GameInput gameInput, final AngelFactory factory) {
        ArrayList<Angel> gameAngels = new ArrayList<Angel>();
        List<String> angels = gameInput.getAngels();
        int digit = 0;
        for (int i = 0; i < angels.size(); ++i) {
            int index = angels.get(i).indexOf(',');
            String angelType = angels.get(i).substring(0, index);
            // System.out.print(angelType + " ");
            index++;
            int currentX = angels.get(i).charAt(index) - '0';
            index++;
            while (angels.get(i).charAt(index) != ',') {
                digit = angels.get(i).charAt(index) - '0';
                currentX = currentX * Constants.CREATE_NUMBER + digit;
                index++;
            }
            // System.out.print(currentX + " ");
            index++;
            int currentY = angels.get(i).charAt(index) - '0';
            index++;
            while (index != angels.get(i).length()  && angels.get(i).charAt(index) != ',') {
                digit = angels.get(i).charAt(index) - '0';
                currentY = currentY * Constants.CREATE_NUMBER + digit;
                index++;
            }
            // System.out.print(currentY);
            // System.out.println(" ");
            switch (angelType) {
                case "DamageAngel":
                    gameAngels.add(factory.getAngelType(AngelType.DAMAGE, currentX, currentY));
                    break;
                case "DarkAngel":
                    gameAngels.add(factory.getAngelType(AngelType.DARK, currentX, currentY));
                    break;
                case "Dracula":
                    gameAngels.add(factory.getAngelType(AngelType.DRACULA, currentX, currentY));
                    break;
                case "GoodBoy":
                    gameAngels.add(factory.getAngelType(AngelType.GOODBOY, currentX, currentY));
                    break;
                case "LevelUpAngel":
                    gameAngels.add(factory.getAngelType(AngelType.LEVEL, currentX, currentY));
                    break;
                case "LifeGiver":
                    gameAngels.add(factory.getAngelType(AngelType.LIFE, currentX, currentY));
                    break;
                case "SmallAngel":
                    gameAngels.add(factory.getAngelType(AngelType.SMALL, currentX, currentY));
                    break;
                case "Spawner":
                    gameAngels.add(factory.getAngelType(AngelType.SPAWN, currentX, currentY));
                    break;
                case "TheDoomer":
                    gameAngels.add(factory.getAngelType(AngelType.DOOM, currentX, currentY));
                    break;
                case "XPAngel":
                    gameAngels.add(factory.getAngelType(AngelType.XP, currentX, currentY));
                    break;
                default:
                    break;
            }
        }
        return gameAngels;
    }

    /* Moves the players and decreases the inability to move if existing */
    public void movePlayers(final GameInput gameInput, final ArrayList<Player> gamePlayers,
                            final int r) {
        List<String> moves = gameInput.getRoundMoves();
        char c;
        int thisX, thisY;
        for (int j = 0; j < gameInput.getP(); ++j) {
            c = moves.get(r).charAt(j);
            switch (c) {
                case 'U':
                    if (gamePlayers.get(j).getCanMove() == 1
                            && gamePlayers.get(j).getStatus() == 1) {
                        thisX = gamePlayers.get(j).getCurrentX();
                        if (thisX - 1 >= 0) {
                            gamePlayers.get(j).setCurrentX(thisX - 1);
                        }
                    } else {
                        int round = gamePlayers.get(j).getImmobilityRound();
                        gamePlayers.get(j).setImmobilityRound(round - 1);
                        if (round == 1) {
                            gamePlayers.get(j).setCanMove(1);
                        }
                    }
                    break;
                case 'D':
                    if (gamePlayers.get(j).getCanMove() == 1
                            && gamePlayers.get(j).getStatus() == 1) {
                        thisX = gamePlayers.get(j).getCurrentX();
                        if (thisX + 1 < gameInput.getM()) {
                            gamePlayers.get(j).setCurrentX(thisX + 1);
                        }
                    } else {
                        int round = gamePlayers.get(j).getImmobilityRound();
                        gamePlayers.get(j).setImmobilityRound(round - 1);
                        if (round == 1) {
                            gamePlayers.get(j).setCanMove(1);
                        }
                    }
                    break;
                case 'L':
                    if (gamePlayers.get(j).getCanMove() == 1
                            && gamePlayers.get(j).getStatus() == 1) {
                        thisY = gamePlayers.get(j).getCurrentY();
                        if (thisY - 1 >= 0) {
                            gamePlayers.get(j).setCurrentY(thisY - 1);
                        }
                    } else {
                        int round = gamePlayers.get(j).getImmobilityRound();
                        gamePlayers.get(j).setImmobilityRound(round - 1);
                        if (round == 1) {
                            gamePlayers.get(j).setCanMove(1);
                        }
                    }
                    break;
                case 'R':
                    if (gamePlayers.get(j).getCanMove() == 1
                            && gamePlayers.get(j).getStatus() == 1) {
                        thisY = gamePlayers.get(j).getCurrentY();
                        if (thisY + 1 < gameInput.getM()) {
                            gamePlayers.get(j).setCurrentY(thisY + 1);
                        }
                    } else {
                        int round = gamePlayers.get(j).getImmobilityRound();
                        gamePlayers.get(j).setImmobilityRound(round - 1);
                        if (round == 1) {
                            gamePlayers.get(j).setCanMove(1);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /* Computes the overtime damage */
    public void calculateOvertimeDamage(final ArrayList<Player> gamePlayers) {
        for (int i = 0; i < gamePlayers.size(); ++i) {
            gamePlayers.get(i).computeOvertimeDamage();
            if (gamePlayers.get(i).getHp() == 0) {
                gamePlayers.get(i).setStatus(0);
            }
        }
    }


    public void setRoundXP(final ArrayList<Player> gamePlayers) {
        for (int i = 0; i < gamePlayers.size(); ++i) {
            int thisXP = gamePlayers.get(i).getXp();
            gamePlayers.get(i).setRoundXP(thisXP);
        }
    }

    public void chooseStrategy(final Player p) {
        if (p.getType() == 'W') {
            if (p.getHp() > (p.getMaxHp() / Constants.WIZARD_DMG_HP_LOW) && p.getHp()
                    < (p.getMaxHp() / Constants.WIZARD_DMG_HP_HIGH)) {
                p.chooseStrategy(new WizardDamageStrategy());
            } else {
                if (p.getHp() <= (p.getMaxHp() / Constants.WIZARD_PRT_HP_LOW)) {
                    p.chooseStrategy(new WizardProtectStrategy());
                }
            }
        }
        if (p.getType() == 'P') {
            if (p.getHp() > (p.getMaxHp() / Constants.PYRO_DMG_HP_LOW) && p.getHp()
                    < (p.getMaxHp() / Constants.PYRO_DMG_HP_HIGH)) {
                p.chooseStrategy(new PyromancerDamageStrategy());
            } else {
                if (p.getHp() <= (p.getMaxHp() / Constants.PYRO_PRT_HP_LOW)) {
                    p.chooseStrategy(new PyromancerProtectStrategy());
                }
            }
        }
        if (p.getType() == 'K') {
            if (p.getHp() > (p.getMaxHp() / Constants.KNIGHT_DMG_HP_LOW) && p.getHp()
                    < (p.getMaxHp() / Constants.KNIGHT_DMG_HP_HIGH)) {
                p.chooseStrategy(new KnightDamageStrategy());
            } else {
                if (p.getHp() <= (p.getMaxHp() / Constants.KNIGHT_PRT_HP_LOW)) {
                    p.chooseStrategy(new KnightProtectStrategy());
                }
            }
        }
        if (p.getType() == 'R') {
            if (p.getHp() > (p.getMaxHp() / Constants.ROGUE_DMG_HP_LOW) && p.getHp()
                    < (p.getMaxHp() / Constants.ROGUE_DMG_HP_HIGH)) {
                p.chooseStrategy(new RogueDamageStrategy());
            } else {
                if (p.getHp() <= (p.getMaxHp() / Constants.ROGUE_PRT_HP_LOW)) {
                    p.chooseStrategy(new RogueProtectStrategy());
                }
            }
        }
    }

    public void getPlayerStrategy(final ArrayList<Player> gamePlayers) {
        for (int i = 0; i < gamePlayers.size(); ++i) {
            if (gamePlayers.get(i).getCanMove() == 1) {
                chooseStrategy(gamePlayers.get(i));
            }
        }
    }

    public void seePlayersStatistics(final ArrayList<Player> gamePlayers) {
        for (int i = 0; i < gamePlayers.size(); ++i) {
            Player p = gamePlayers.get(i);
            System.out.println("ID " + p.getId() + " " + p.getType() + " HP:"
                    + p.getHp() + " XP:" + p.getXp() + " LEVEL:" + p.getLevel()
                    + " Row:" + p.getCurrentX() + " Column:" + p.getCurrentY()
                    + " Terrain:"
                    + p.getGround().getGround().get(p.getCurrentX()).charAt(p.getCurrentY()));
            if (p.getType() == 'P') {
                System.out.println(" FIREBLAST modifiers: ");
                System.out.println("Pyromancer: " + p.getFireblastPyroPercent());
                System.out.println("Knight: " + p.getFireblastKnightPercent());
                System.out.println("Wizard: " + p.getFireblastWizardPercent());
                System.out.println("Rogue: " + p.getFireblastRoguePercent());
                System.out.println("");
                System.out.println(" IGNITE modifiers: ");
                System.out.println("Pyromancer: " + p.getIgnitePyroPercent());
                System.out.println("Knight: " + p.getIgniteKnightPercent());
                System.out.println("Wizard: " + p.getIgniteWizardPercent());
                System.out.println("Rogue: " + p.getIgniteRoguePercent());
            }
            if (p.getType() == 'K') {
                System.out.println(" EXECUTE modifiers: ");
                System.out.println("Pyromancer: " + p.getExecutePyroPercent());
                System.out.println("Knight: " + p.getExecuteKnightPercent());
                System.out.println("Wizard: " + p.getExecuteWizardPercent());
                System.out.println("Rogue: " + p.getExecuteRoguePercent());
                System.out.println("");
                System.out.println(" SLAM modifiers: ");
                System.out.println("Pyromancer: " + p.getSlamPyroPercent());
                System.out.println("Knight: " + p.getSlamKnightPercent());
                System.out.println("Wizard: " + p.getSlamWizardPercent());
                System.out.println("Rogue: " + p.getSlamRoguePercent());
            }
            if (p.getType() == 'W') {
                System.out.println(" DRAIN modifiers: ");
                System.out.println("Pyromancer: " + p.getDrainPyroPercent());
                System.out.println("Knight: " + p.getDrainKnightPercent());
                System.out.println("Wizard: " + p.getDrainWizardPercent());
                System.out.println("Rogue: " + p.getDrainRoguePercent());
                System.out.println("");
                System.out.println(" DEFLECT modifiers: ");
                System.out.println("Pyromancer: " + p.getDeflectPyroPercent());
                System.out.println("Knight: " + p.getDeflectKnightPercent());
                System.out.println("Wizard: " + p.getDeflectWizardPercent());
                System.out.println("Rogue: " + p.getDeflectRoguePercent());
            }
            if (p.getType() == 'R') {
                System.out.println(" BACKSTAB modifiers: ");
                System.out.println("Pyromancer: " + p.getBackstabPyroPercent());
                System.out.println("Knight: " + p.getBackstabKnightPercent());
                System.out.println("Wizard: " + p.getBackstabWizardPercent());
                System.out.println("Rogue: " + p.getBackstabRoguePercent());
                System.out.println("");
                System.out.println(" PARALYSIS modifiers: ");
                System.out.println("Pyromancer: " + p.getParalysisPyroPercent());
                System.out.println("Knight: " + p.getParalysisKnightPercent());
                System.out.println("Wizard: " + p.getParalysisWizardPercent());
                System.out.println("Rogue: " + p.getParalysisRoguePercent());
            }
            System.out.println("\n\n\n");
        }
    }

    public void getAngelEffect(final ArrayList<Player> gamePlayers,
                               final ArrayList<Angel> gameAngels, final int round,
                               final GameInput gameInput, final ReadInput readInput,
                               final GreatMagician greatMagician) {
        int angelIndex = 0;
        for (int i = 0; i < round; ++i) {
            angelIndex += gameInput.getAngelsPerRound().get(i);
        }
        int numAngels = gameInput.getAngelsPerRound().get(round);
        for (int i = 0; i < numAngels; ++i) {
            if (gameAngels.get(angelIndex + i).getIsOnMap() == 0) {
                greatMagician .setNotice(readInput.spawnAngel(gameAngels.get(angelIndex + i)));
                gameAngels.get(angelIndex + i).setIsOnMap(1);
            }
            for (int j = 0; j < gamePlayers.size(); ++j) {
                if (gameAngels.get(angelIndex + i).getCurrentX()
                        == gamePlayers.get(j).getCurrentX()
                        && gameAngels.get(angelIndex + i).getCurrentY()
                        == gamePlayers.get(j).getCurrentY()) {
                    gamePlayers.get(j).isAffected(gameAngels.get(angelIndex + i), readInput,
                            greatMagician);
                }
            }
        }
    }

    /* Plays the game */
    public ArrayList<Player>  play(final GameInput gameInput, final BattleField ground,
                     final ReadInput readInput, final PlayerFactory factory,
                     final AngelFactory angelFactory, final GreatMagician greatMagician) {
        ArrayList<Player> gamePlayers = this.getPlayersArray(gameInput, ground, factory);
        ArrayList<Angel> gameAngels = this.getAngelsArray(gameInput, angelFactory);
        for (int i = 0; i < gameInput.getR(); ++i) {
            //System.out.println("Before round " + (i + 1));
            //this.seePlayersStatistics(gamePlayers);
            readInput.printRound(i + 1);
            this.movePlayers(gameInput, gamePlayers, i);
            this.calculateOvertimeDamage(gamePlayers);
            this.setRoundXP(gamePlayers);
            this.getPlayerStrategy(gamePlayers);
            for (int j = 0; j < gameInput.getP() - 1; ++j) {
                for (int k = j + 1; k < gameInput.getP(); ++k) {
                    if (gamePlayers.get(j).getCurrentX() == gamePlayers.get(k).getCurrentX()
                            && gamePlayers.get(j).getCurrentY()
                            == gamePlayers.get(k).getCurrentY()) {
                        if (gamePlayers.get(j).getStatus() == 1
                                && gamePlayers.get(k).getStatus() == 1) {
                            if (gamePlayers.get(j).getType() != 'W') {
                                /* If the current player is not a wizard, keep the
                                 normal order */
                                gamePlayers.get(k).accept(gamePlayers.get(j));
                                int currentAttackJ = gamePlayers.get(j).getAttackCount();
                                gamePlayers.get(j).setAttackCount(currentAttackJ + 1);

                                if (gamePlayers.get(k).getHp() <= 0) {
                                    gamePlayers.get(k).setStatus(0);
                                    if (gamePlayers.get(j).getHp() > 0) {
                                        gamePlayers.get(j).hasWon(gamePlayers.get(k));
                                    }
                                    readInput.printDeath(gamePlayers.get(k), gamePlayers.get(j));
                                }

                                gamePlayers.get(j).accept(gamePlayers.get(k));
                                int currentAttackK = gamePlayers.get(k).getAttackCount();
                                gamePlayers.get(k).setAttackCount(currentAttackK + 1);

                                if (gamePlayers.get(j).getHp() <= 0) {
                                    gamePlayers.get(j).setStatus(0);
                                    if (gamePlayers.get(k).getHp() > 0) {
                                        gamePlayers.get(k).hasWon(gamePlayers.get(j));
                                    }
                                    readInput.printDeath(gamePlayers.get(j), gamePlayers.get(k));
                                }

                                //System.out.println("Player " + gamePlayers.get(j).getId()
                                 //       + " and player " + gamePlayers.get(k).getId()
                                 //       + "are fighting");
                            } else {
                                /* If the player is a wizard, it attacks first */
                                gamePlayers.get(j).accept(gamePlayers.get(k));
                                int currentAttackK = gamePlayers.get(k).getAttackCount();
                                gamePlayers.get(k).setAttackCount(currentAttackK + 1);

                                gamePlayers.get(k).accept(gamePlayers.get(j));
                                int currentAttackJ = gamePlayers.get(j).getAttackCount();
                                gamePlayers.get(j).setAttackCount(currentAttackJ + 1);

                                if (gamePlayers.get(j).getHp() <= 0) {
                                    gamePlayers.get(j).setStatus(0);
                                    if (gamePlayers.get(k).getHp() > 0) {
                                        gamePlayers.get(k).hasWon(gamePlayers.get(j));
                                    }
                                    readInput.printDeath(gamePlayers.get(j), gamePlayers.get(k));
                                }
                                if (gamePlayers.get(k).getHp() <= 0) {
                                    gamePlayers.get(k).setStatus(0);
                                    if (gamePlayers.get(j).getHp() > 0) {
                                        gamePlayers.get(j).hasWon(gamePlayers.get(k));
                                    }
                                    readInput.printDeath(gamePlayers.get(k), gamePlayers.get(j));
                                }
                                //System.out.println("Player " + gamePlayers.get(j).getId()
                                //        + " and player " + gamePlayers.get(k).getId()
                                 //       + "are fighting");
                            }
                            gamePlayers.get(k).increaseLevel(gamePlayers.get(k).getLevel(),
                                    readInput);
                            gamePlayers.get(j).increaseLevel(gamePlayers.get(j).getLevel(),
                                    readInput);
                        }
                    }
                }
            }
            this.getAngelEffect(gamePlayers, gameAngels, i, gameInput, readInput, greatMagician);
            readInput.printLine();
        }
        return gamePlayers;
    }
}
