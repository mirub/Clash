package main;

import constants.Constants;
import ground.BattleField;
import player.*;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {
    private static PlayGame instance = null;

    private PlayGame () {}

    public static PlayGame getInstance() {
        if (instance == null) {
            instance = new PlayGame();
        }
        return instance;
    }

    public ArrayList<Player> getPlayersArray (Input gameInput, BattleField g) {
        ArrayList<Player> gamePlayers = new ArrayList<Player>();
        List<String> beginningPlayers = gameInput.getPlayers();
        for (int i = 0; i < beginningPlayers.size(); ++i) {
            char c = beginningPlayers.get(i).charAt(0);
            switch (c) {
                case 'P':
                    gamePlayers.add(new Pyromancer(i, Constants.INITIAL_PYRO_HP,
                            Constants.PYRO_HP_LEVEL_BONUS, g,
                            Character.getNumericValue(beginningPlayers.get(i).charAt(1)),
                            Character.getNumericValue(beginningPlayers.get(i).charAt(2)), 'P'));
                    break;
                case 'R':
                    gamePlayers.add(new Rogue(i, Constants.INITIAL_ROGUE_HP,
                            Constants.ROGUE_HP_LEVEL_BONUS, g,            // NU E F EFICIENT MAYBE RETHINK

                            Character.getNumericValue(beginningPlayers.get(i).charAt(1)),
                            Character.getNumericValue(beginningPlayers.get(i).charAt(2)), 'R'));
                    break;
                case 'K':
                    gamePlayers.add(new Knight(i, Constants.INITIAL_KNIGHT_HP,
                            Constants.KNIGHT_HP_LEVEL_BONUS, g,
                            Character.getNumericValue(beginningPlayers.get(i).charAt(1)),
                            Character.getNumericValue(beginningPlayers.get(i).charAt(2)), 'K'));
                    break;
                case 'W':
                    gamePlayers.add(new Wizard(i, Constants.INITIAL_WIZARD_HP,
                            Constants.WIZARD_HP_LEVEL_BONUS, g,
                            Character.getNumericValue(beginningPlayers.get(i).charAt(1)),
                            Character.getNumericValue(beginningPlayers.get(i).charAt(2)), 'W'));
                    break;
                default:
                    break;
            }
        }
        return gamePlayers;
    }

    public void movePlayers(Input gameInput, ArrayList<Player> gamePlayers, int r) {
        List<String> moves = gameInput.getRoundMoves();
        char c;
        int thisX, thisY;
        for (int j = 0; j < gameInput.getP(); ++j) {
            c = moves.get(r).charAt(j);
            switch (c) {
                case 'U':
                    if (gamePlayers.get(j).getCanMove() == 1) {
                        thisX = gamePlayers.get(j).getCurrentX();
                        if (thisX - 1 >= 0) {
                            gamePlayers.get(j).setCurrentX(thisX - 1);
                        }
                    }
                    break;
                case 'D':
                    if (gamePlayers.get(j).getCanMove() == 1) {
                        thisX = gamePlayers.get(j).getCurrentX();
                        if (thisX + 1 < gameInput.getM()) {
                            gamePlayers.get(j).setCurrentX(thisX + 1);
                        }
                    }
                    break;
                case 'L':
                    if (gamePlayers.get(j).getCanMove() == 1) {
                        thisY = gamePlayers.get(j).getCurrentY();
                        if (thisY - 1 >= 0) {
                            gamePlayers.get(j).setCurrentY(thisY - 1);
                        }
                    }
                    break;
                case 'R':
                    if (gamePlayers.get(j).getCanMove() == 1) {
                        thisY = gamePlayers.get(j).getCurrentY();
                        if (thisY + 1 < gameInput.getM()) {
                            gamePlayers.get(j).setCurrentY(thisY + 1);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void setHasNotFought (ArrayList<Player> gamePlayers, int r) {
        for (int i = 0; i < gamePlayers.size(); ++i) {
            gamePlayers.get(i).setHasFought(0);
            gamePlayers.get(i).setCurrentRound(r);
        }
    }

    public void play (Input gameInput, BattleField ground, ReadInput readInput) {
        ArrayList<Player> gamePlayers = this.getPlayersArray(gameInput, ground);
        for (int i = 0; i < gameInput.getR(); ++i) {
            this.movePlayers(gameInput, gamePlayers, i);
            this.setHasNotFought(gamePlayers, i);
            for (int j = 0; j < gameInput.getP() - 1; ++j) {
                this.setHasNotFought(gamePlayers, i);
                if (gamePlayers.get(j).getStatus() == 1) {
                    for (int k = j + 1; k < gameInput.getP(); ++k) {
                        if (gamePlayers.get(j).getCurrentX() == gamePlayers.get(k).getCurrentX() &&
                                gamePlayers.get(j).getCurrentY() == gamePlayers.get(k).getCurrentY()) {
                            if (gamePlayers.get(j).getHasFought() == 0 &&
                                    gamePlayers.get(k).getHasFought() == 0) {

                                gamePlayers.get(k).accept(gamePlayers.get(j));
                                gamePlayers.get(j).accept(gamePlayers.get(k));

                                gamePlayers.get(j).setHasFought(1);
                                gamePlayers.get(k).setHasFought(1);
                            }
                        }
                    }
                }
            }
        }
        readInput.writeResult(gamePlayers);
    }


}
