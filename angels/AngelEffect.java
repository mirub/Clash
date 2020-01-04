package angels;

import magician.GreatMagician;
import main.ReadInput;

/* The Visitor Pattern Visitable Interface*/
public interface AngelEffect {
    void isAffected(Angel a, ReadInput readInput, GreatMagician greatMagician);
}
