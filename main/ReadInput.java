/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package main;

import angels.Angel;
import angels.AngelType;
import fileio.FileSystem;
import player.Player;
import java.util.ArrayList;
import java.util.List;

public final class ReadInput {
    private static String inFile;
    private static String outFile;
    private static ReadInput instance = null;
    private FileSystem fs;


    public static ReadInput getInstance(final String inputFile,
                                        final String outputFile) {
        if (instance == null) {
            instance = new ReadInput(inputFile, outputFile);
        }
        return instance;
    }


    private ReadInput(final String inputFile, final String outputFile) {
        this.inFile = inputFile;
        this.outFile = outputFile;
        try {
            fs = new FileSystem(inputFile, outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Returns a variable of type Input upon reading from a file */
    public static GameInput load() {
        int n = 0;
        int m = 0;
        List<String> ground = new ArrayList<String>();
        int p = 0;
        List<String> players = new ArrayList<String>();
        ArrayList<ArrayList<Integer>> positions = new ArrayList<ArrayList<Integer>>();
        int r = 0;
        List<String> roundMoves = new ArrayList<String>();
        List<Integer> angelsPerRound = new ArrayList<Integer>();
        int a = 0;
        List<String> angels = new ArrayList<String>();
        try {
            FileSystem fs = new FileSystem(inFile, outFile);

            n = fs.nextInt();
            m = fs.nextInt();

            for (int i = 0; i < n; ++i) {
                ground.add(fs.nextWord());
            }

            p = fs.nextInt();

            for (int i = 0; i < p; ++i) {
                ArrayList<Integer> currentPosition = new ArrayList<Integer>(2);
                players.add(fs.nextWord());
                currentPosition.add(fs.nextInt());
                currentPosition.add(fs.nextInt());
                positions.add(currentPosition);
            }

            r = fs.nextInt();

            for (int i = 0; i < r; ++i) {
                roundMoves.add(fs.nextWord());
            }

            for (int i = 0; i < r; ++i) {
                int currentAngelNumber = fs.nextInt();
                angelsPerRound.add(currentAngelNumber);
                a += currentAngelNumber;
                for (int j = 0; j < currentAngelNumber; ++j) {
                    angels.add(fs.nextWord());
                }
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(n, m, ground, p, players, positions, r,
                roundMoves, angelsPerRound, a, angels);
    }

    /* Prints the name of the angel*/
    public String getAngelName(final Angel a) {
        try {
            String name = null;
            if (a.getType() == AngelType.DAMAGE) {
                fs.writeWord("DamageAngel ");
                name = "DamageAngel ";
            } else if (a.getType() == AngelType.DARK) {
                fs.writeWord("DarkAngel ");
                name = "DarkAngel ";
            }  else if (a.getType() == AngelType.DRACULA) {
                fs.writeWord("Dracula ");
                name = "Dracula ";
            } else if (a.getType() == AngelType.GOODBOY) {
                fs.writeWord("GoodBoy ");
                name = "GoodBoy ";
            } else if (a.getType() == AngelType.LEVEL) {
                fs.writeWord("LevelUpAngel ");
                name = "LevelUpAngel  ";
            } else if (a.getType() == AngelType.LIFE) {
                fs.writeWord("LifeGiver ");
                name = "LifeGiver  ";
            } else if (a.getType() == AngelType.SMALL) {
                fs.writeWord("SmallAngel ");
                name = "SmallAngel ";
            } else if (a.getType() == AngelType.SPAWN) {
                fs.writeWord("Spawner ");
                name = "Spawner ";
            } else if (a.getType() == AngelType.DOOM) {
                fs.writeWord("TheDoomer ");
                name = "TheDoomer ";
            } else if (a.getType() == AngelType.XP) {
                fs.writeWord("XPAngel ");
                name = "XPAngel ";
            }
            return name;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* Prints the message for spawning */
    public String spawnAngel(final Angel a) {
        try {
            String message = "";
            fs.writeWord("Angel ");
            message += "Angel ";
            message += this.getAngelName(a);
            fs.writeWord("was spawned at ");
            message += "was spawned at ";
            fs.writeInt(a.getCurrentX());
            message += a.getCurrentX();
            fs.writeCharacter(' ');
            message += " ";
            fs.writeInt(a.getCurrentY());
            message += a.getCurrentY();
            fs.writeNewLine();
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    /* Prints the message for round beginning */
    public void printRound(final int roundNumber) {
        try {
            fs.writeWord("~~ ");
            fs.writeWord("Round ");
            fs.writeInt(roundNumber);
            fs.writeWord(" ~~");
            fs.writeNewLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Prints the name of the player */
    public String getPlayerTypeName(final Player p) {
        try {
            String playerType = null;
            if (p.getType() == 'P') {
                fs.writeWord("Pyromancer ");
                playerType = "Pyromancer ";
            } else if (p.getType() == 'K') {
                fs.writeWord("Knight ");
                playerType = "Knight ";
            } else if (p.getType() == 'W') {
                fs.writeWord("Wizard ");
                playerType = "Wizard ";
            } else if (p.getType() == 'R') {
                fs.writeWord("Rogue ");
                playerType = "Rogue ";
            }
            return playerType;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* Prints the message for angel kill */
    public String killedByAngel(final Player p) {
        try {
            String angelKill = "";
            fs.writeWord("Player ");
            angelKill += "Player ";
            angelKill += getPlayerTypeName(p);
            fs.writeInt(p.getId());
            angelKill += p.getId();
            fs.writeWord(" was killed by an angel");
            angelKill += " was killed by an angel";
            fs.writeNewLine();
            return angelKill;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* Prints the message for angel hit */
    public String printHit(final Angel a, final Player p) {
        try {
            String hit = "";
            hit += getAngelName(a);
            fs.writeWord("hit ");
            hit += "hit ";
            hit += getPlayerTypeName(p);
            fs.writeInt(p.getId());
            hit += p.getId();
            fs.writeNewLine();
            return hit;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* Prints the message for angel help */
    public String printHelp(final Angel a, final Player p) {
        try {
            String help = "";
            help += getAngelName(a);
            fs.writeWord("helped ");
            help += "helped ";
            help += getPlayerTypeName(p);
            fs.writeInt(p.getId());
            help += p.getId();
            fs.writeNewLine();
            return help;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* Prints the message for leveling up */
    public String printLevelUp(final Player p) {
        try {
            String levelUp = "";
            levelUp += getPlayerTypeName(p);
            fs.writeInt(p.getId());
            levelUp += p.getId();
            fs.writeWord(" reached level ");
            levelUp += " reached level ";
            fs.writeInt(p.getLevel());
            levelUp += p.getLevel();
            fs.writeNewLine();
            return levelUp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* Prints the message for resurrection */
    public String printResurrection(final Player p) {
        try {
            String res = "";
            fs.writeWord("Player ");
            res += "Player ";
            res += getPlayerTypeName(p);
            fs.writeInt(p.getId());
            res += p.getId();
            fs.writeWord(" was brought to life by an angel");
            res += " was brought to life by an angel";
            fs.writeNewLine();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* Prints the message for player kill */
    public String printDeath(final Player p1, final Player p2) {
        try {
            String death = "";
            fs.writeWord("Player ");
            death += "Player ";
            death += getPlayerTypeName(p1);
            fs.writeInt(p1.getId());
            death += p1.getId();
            fs.writeWord(" was killed by ");
            death += " was killed by ";
            death += getPlayerTypeName(p2);
            fs.writeInt(p2.getId());
            death += p2.getId();
            fs.writeNewLine();
            return death;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* Prints the player type char */
    public void returnTypeChar(final Player p) {
        try {
            fs.writeCharacter(p.getType());
            fs.writeCharacter(' ');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Prints the message for final standings */
    public void printOutput(final ArrayList<Player> players) {
        try {
            int size = players.size();
            fs.writeWord("~~ Results ~~");
            fs.writeNewLine();
            for (int i = 0; i < size; ++i) {
                if (players.get(i).getStatus() == 0) {
                    returnTypeChar(players.get(i));
                    fs.writeWord("dead");
                    fs.writeNewLine();
                } else {
                    returnTypeChar(players.get(i));
                    fs.writeInt(players.get(i).getLevel());
                    fs.writeCharacter(' ');
                    fs.writeInt(players.get(i).getXp());
                    fs.writeCharacter(' ');
                    fs.writeInt(players.get(i).getHp());
                    fs.writeCharacter(' ');
                    fs.writeInt(players.get(i).getCurrentX());
                    fs.writeCharacter(' ');
                    fs.writeInt(players.get(i).getCurrentY());
                    fs.writeNewLine();
                }
            }
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Prints a new line */
    public void printLine() {
        try {
            fs.writeNewLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
