package player;

public interface Fighter {
    // VISITOR
    public void battle(Pyromancer p);
    public void battle(Wizard w);
    public void battle(Knight k);
    public void battle(Rogue r);
}
