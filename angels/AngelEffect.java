package angels;

import main.ReadInput;

/* The Visitor Pattern Visitable Interface*/
public interface AngelEffect {
    void isAffected(Angel a, ReadInput readInput);
}
