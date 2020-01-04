# LeagueOfOOP - Stage 1

Student: Banu Miruna Elena

Group: 321CA

Project description:
  
  
  This project implements a MMO-style game which sees a number of players
that move in a 2D Universe and fight eachother for a number of rounds and, in
the end, prints the state of the players along with their HP, XP and placement
on the map.

   Each of the players has one of the 4 types: Pyromancer, Rogue, Wizard or
Knight. These 4 races of players have 2 types of damage hits that change their
intensity depending on the race they are applied to. Also, every player has a
preferred land type that boosts their abilities: Pyromancer - Volcanic, Knight -
Land, Wizard - Desert, Rogue - Woods.
   
   The players can move (or not) each round in one of the four directions: Up,
Down, Left, Right (or '_' if they remain in their current position). However,
their mobility could be altered depending on the player that hit them in one of
the prior rounds (in case that player had the ability to do so).

   If two players land on the same coordinates, they fight eachother, damaging
the opponent with both their hits. However, if any of the two players dies due
to the overtime damage caused by a prior hit, the fight does not happen anymore.

 Concepts used in the implementation of the problem:


- The Singleton Pattern: needing just one instance of the following classes,
			 this pattern is used for: BattleField, PlayGame,
			 ReadInput, PlayerFactory;
			 

- The Factory Pattern: to generate the player types without exposing the
		       creation logic, this pattern is used for PlayerFactory;


- Double Dispatch: to ease the interaction between the players during the
		   fights, the Double Dispatch concept has been implemented
		   by using the Visitor Pattern (the interfaces Fighter, Fought)
		   and their corresponding functions (battle - the visit
		   function and accept). Thus, the polymorphism is highlighted.


# LeagueOfOOP - Stage 2		   

Project description:


  This part of the project extends the first stage by adding some new elements
such as angels that help or prevent them from battling eachother or a great
magician that observes the behaviour of the players. Another addition to the
old version is that the players adopt 2 types of strategies: defensive and
offensive.

  The angels have the following effect on the playes: they either raise their
hp and/or their power, of they lower these effects. Also, they can kill or
ressurect the characters. The great magician is noticed every time an angel is
spawn or it affects any of the players.

  Strategy-wise, the players choose to attack harder or defend themselves based
on the hp they have at the beginning of the round. Each player chooses its
strategy at the beginning of the round. 

  The fight itself happens exactly the same as it did in the first stage.

Concepts used in the further implementation of the program:


- The Singleton Pattern: using only one instance of the following classes,
			 this pattern is used in: AngelFactory, GreatMagician;


- The Factory Pattern: to generate the angel types without exposing the
		       creation logic, this pattern is used for AngelFactory;


- The Stategy Pattern: to change the executing algorithm of the player fight,
		       the strategy pattern is used for every class in the
		       strategy package;


- The Observer Pattern: to notice the Great Magician about the changes in the
			game, this pattern is used in: GreatMagician;   	 


- The Visitor Pattern: it is used to allow the angels to have a different
		       behaviour for every type of the players - used in:
		       AngelAffect and AngelEffect; 
