package angels;

import magician.GreatMagician;
import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

/* The Visitor Pattern Visitor Interface */
public interface AngelAffect {
    void affect(Pyromancer p, ReadInput readInput, GreatMagician greatMagician);
    void affect(Wizard w, ReadInput readInput, GreatMagician greatMagician);
    void affect(Knight k, ReadInput readInput, GreatMagician greatMagician);
    void affect(Rogue r, ReadInput readInput, GreatMagician greatMagician);
}
