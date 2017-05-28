# Aethernal_Td

This is a basic tower defence game.

## Description

The games objective is rather simple. It contains a field through which a road runs.
At the roads one end, mobs will spawn, and they will try to get to the end of the road.
The player can place towers on the field, but not on the road itself and they can't be stacked.
The towers cost gold, and you only have a handful of gold at the start. But each mob that is killed
by a tower will drop his loot that you can use to make even more towers.
When a mob reaches the end of the road it will attack you, thus you will lose one life.
If your life drops to zero the game is over.

### Installation and usage

``` 
$ mvn clean package
$ mvn exec:java
```

#### License

MIT