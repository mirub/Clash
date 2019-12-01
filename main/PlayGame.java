/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package main;

import constants.Constants;
import ground.BattleField;
import player.PlayerFactory;
import player.Player;
import player.PlayerType;

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

    /* Plays the game */
    public void play(final GameInput gameInput, final BattleField ground,
                     final ReadInput readInput, final PlayerFactory factory) {
        ArrayList<Player> gamePlayers = this.getPlayersArray(gameInput, ground, factory);
        for (int i = 0; i < gameInput.getR(); ++i) {
            this.movePlayers(gameInput, gamePlayers, i);
            this.calculateOvertimeDamage(gamePlayers);
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

                                gamePlayers.get(j).accept(gamePlayers.get(k));
                                int currentAttackK = gamePlayers.get(k).getAttackCount();
                                gamePlayers.get(k).setAttackCount(currentAttackK + 1);
                            } else {
                                /* If the player is a wizard, it attacks first */
                                gamePlayers.get(j).accept(gamePlayers.get(k));
                                int currentAttackK = gamePlayers.get(k).getAttackCount();
                                gamePlayers.get(k).setAttackCount(currentAttackK + 1);

                                gamePlayers.get(k).accept(gamePlayers.get(j));
                                int currentAttackJ = gamePlayers.get(j).getAttackCount();
                                gamePlayers.get(j).setAttackCount(currentAttackJ + 1);

                            }
                            gamePlayers.get(k).increaseLevel(gamePlayers.get(k).getLevel());
                            gamePlayers.get(j).increaseLevel(gamePlayers.get(j).getLevel());
                        }
                    }
                }
            }
        }
        readInput.writeResult(gamePlayers);
    }
}
