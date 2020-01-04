package angels;

import main.ReadInput;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

/* The Visitor Pattern Visitor Interface */
public interface AngelAffect {
    void affect(Pyromancer p, ReadInput readInput);
    void affect(Wizard w, ReadInput readInput);
    void affect(Knight k, ReadInput readInput);
    void affect(Rogue r, ReadInput readInput);
}
