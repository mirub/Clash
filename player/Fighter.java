/* Banu Miruna Elena - 321CA - League of OOP - Stage 1 - 2019 */
package player;

/* The Visitor Pattern Visitor Interface */
public interface Fighter {
    void battle(Pyromancer p);
    void battle(Wizard w);
    void battle(Knight k);
    void battle(Rogue r);
}
