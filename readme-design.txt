Classes:
-Command > to deal with actions of the command
-CommandParser > class to parse input and provide correct arguments for the Command.
-GameMap > For making a map object
-GameMapFactory > For instantiating custom maps with different types of rooms.
- Item > class defining characteristics of items
- ItemFactory > For instantiating specific weapons
- Player > class holding player characteristics such as HP, items held
- Room > hold fields for items, monster, other rooms it can visit
-ZorkGame > Instantiate GameMap and Player and has methods for game story execution.
-ZorkRunner > start game
-Monser > For making monster object
-MonsterFactory > Instantiate different monster object/s

Inheritance:
1. Superclass: Item
Subclasses- WeaponItem, UseableItem, QuestItem
Many fields/traits are similar so it helps with code reusability and can use Factory Method Design Pattern.

2. Interface: Monster
Subclasses- Mors and Kraken
Design choice is same reason as above