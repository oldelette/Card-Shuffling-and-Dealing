all: compile

compile:
	javac DeckOfCards.java
	javac Card.java
	javac Hand.java
	javac PokerHand.java
	javac mytest.java
	
	java mytest
