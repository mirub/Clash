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
		   
